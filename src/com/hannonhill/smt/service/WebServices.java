/*
 * Created on Nov 19, 2009 by Artur Tomusiak
 * 
 * Copyright(c) 2000-2009 Hannon Hill Corporation. All rights reserved.
 */
package com.hannonhill.smt.service;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hannonhill.smt.CascadeAssetInformation;
import com.hannonhill.smt.DataDefinitionField;
import com.hannonhill.smt.Field;
import com.hannonhill.smt.MetadataSetField;
import com.hannonhill.smt.MigrationStatus;
import com.hannonhill.smt.ProjectInformation;
import com.hannonhill.smt.util.PathUtil;
import com.hannonhill.smt.util.WebServicesUtil;
import com.hannonhill.www.ws.ns.AssetOperationService.Asset;
import com.hannonhill.www.ws.ns.AssetOperationService.AssetOperationHandler;
import com.hannonhill.www.ws.ns.AssetOperationService.AssetOperationHandlerServiceLocator;
import com.hannonhill.www.ws.ns.AssetOperationService.Authentication;
import com.hannonhill.www.ws.ns.AssetOperationService.ContentType;
import com.hannonhill.www.ws.ns.AssetOperationService.ContentTypeContainer;
import com.hannonhill.www.ws.ns.AssetOperationService.CreateResult;
import com.hannonhill.www.ws.ns.AssetOperationService.DataDefinition;
import com.hannonhill.www.ws.ns.AssetOperationService.DynamicMetadataFieldDefinition;
import com.hannonhill.www.ws.ns.AssetOperationService.EntityTypeString;
import com.hannonhill.www.ws.ns.AssetOperationService.File;
import com.hannonhill.www.ws.ns.AssetOperationService.Folder;
import com.hannonhill.www.ws.ns.AssetOperationService.Identifier;
import com.hannonhill.www.ws.ns.AssetOperationService.ListSitesResult;
import com.hannonhill.www.ws.ns.AssetOperationService.MetadataFieldVisibility;
import com.hannonhill.www.ws.ns.AssetOperationService.MetadataSet;
import com.hannonhill.www.ws.ns.AssetOperationService.OperationResult;
import com.hannonhill.www.ws.ns.AssetOperationService.Path;
import com.hannonhill.www.ws.ns.AssetOperationService.ReadResult;
import com.hannonhill.www.ws.ns.AssetOperationService.Site;
import com.hannonhill.www.ws.ns.AssetOperationService.XhtmlDataDefinitionBlock;

/**
 * This class contains service methods for web services
 * 
 * @author Artur Tomusiak
 * @since 1.0
 */
public class WebServices
{
    private static final long MAX_FILE_SIZE_MB = 500l;

    private static final MetadataSetField[] STANDARD_METADATA_FIELDS = new MetadataSetField[]
    {
            new MetadataSetField("displayName", "Display Name", false), new MetadataSetField("title", "Title", false),
            new MetadataSetField("summary", "Summary", false), new MetadataSetField("teaser", "Teaser", false),
            new MetadataSetField("keywords", "Keywords", false), new MetadataSetField("metaDescription", "Description", false),
            new MetadataSetField("author", "Author", false), new MetadataSetField("startDate", "Start Date", false),
            new MetadataSetField("endDate", "End Date", false), new MetadataSetField("reviewDate", "Review Date", false)
    };

    // Names of metadata fields whose values can be longer than 250 characters
    public static final List<String> LONG_METADATA_FIELDS;

    public static final DataDefinitionField XHTML_DATA_DEFINITION_FIELD = new DataDefinitionField("xhtml", "XHTML", null, false, true);

    // Identifiers of the standard metadata fields
    public static final List<String> STANDARD_METADATA_FIELD_IDENTIFIERS;

    public static final Set<String> CALENDAR_METADATA_FIELD_IDENTIFIERS;

    static
    {
        // Assign the identifiers
        STANDARD_METADATA_FIELD_IDENTIFIERS = new ArrayList<String>();
        for (Field standardMetadataField : STANDARD_METADATA_FIELDS)
            STANDARD_METADATA_FIELD_IDENTIFIERS.add(standardMetadataField.getIdentifier());

        LONG_METADATA_FIELDS = new ArrayList<String>();
        LONG_METADATA_FIELDS.add("keywords");
        LONG_METADATA_FIELDS.add("summary");
        LONG_METADATA_FIELDS.add("teaser");
        LONG_METADATA_FIELDS.add("metaDescription");

        CALENDAR_METADATA_FIELD_IDENTIFIERS = new HashSet<String>();
        CALENDAR_METADATA_FIELD_IDENTIFIERS.add("startDate");
        CALENDAR_METADATA_FIELD_IDENTIFIERS.add("endDate");
        CALENDAR_METADATA_FIELD_IDENTIFIERS.add("reviewDate");
    }

    /**
     * Reads a site object
     * 
     * @param username
     * @param password
     * @param url
     * @param siteName
     * @return
     * @throws Exception
     */
    public static Site readSite(String username, String password, String url, String siteName) throws Exception
    {
        Authentication authentication = new Authentication(password, username);
        Path path = new Path(siteName, null, siteName);
        Identifier identifier = new Identifier(null, path, EntityTypeString.site, false);
        ReadResult readResult = getServer(url).read(authentication, identifier);
        if (!readResult.getSuccess().equals("true"))
            throw new Exception(readResult.getMessage());

        return readResult.getAsset().getSite();
    }

    /**
     * Gets all content types from given site
     * 
     * @param projectInformation
     * @return
     * @throws Exception
     */
    public static List<ContentType> getContentTypesFromSite(ProjectInformation projectInformation) throws Exception
    {
        Site site = readSite(projectInformation.getUsername(), projectInformation.getPassword(), projectInformation.getUrl(),
                projectInformation.getSiteName());

        // Recursively collect all ancestor content types
        List<ContentType> contentTypes = new ArrayList<ContentType>();
        collectContentTypes(projectInformation, site.getRootContentTypeContainerId(), contentTypes);
        return contentTypes;
    }

    /**
     * Returns a map of metadata field identifiers to actual fields of a metadata set that is assigned to a
     * content type with given contentTypePath
     * 
     * @param projectInformation
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Map<String, MetadataSetField> getMetadataFieldsForContentType(ProjectInformation projectInformation, ContentType contentType)
            throws Exception
    {
        Authentication authentication = getAuthentication(projectInformation);
        String metadataSetId = contentType.getMetadataSetId();

        Identifier identifier = new Identifier(metadataSetId, null, EntityTypeString.metadataset, false);
        ReadResult readResult = getServer(projectInformation.getUrl()).read(authentication, identifier);
        if (!readResult.getSuccess().equals("true"))
            throw new Exception("Error occured when reading a Metadata Set with id '" + metadataSetId + "': " + readResult.getMessage());

        MetadataSet metadataSet = readResult.getAsset().getMetadataSet();

        // add all the standard fields
        Map<String, MetadataSetField> resultMap = new HashMap<String, MetadataSetField>();
        for (MetadataSetField field : STANDARD_METADATA_FIELDS)
            resultMap.put(field.getIdentifier(), field);

        // add the dynamic fields
        for (DynamicMetadataFieldDefinition definition : metadataSet.getDynamicMetadataFieldDefinitions())
            if (!definition.getVisibility().equals(MetadataFieldVisibility.hidden)) // skip hidden fields
                resultMap.put(definition.getName(), new MetadataSetField(definition.getName(), definition.getLabel(), true));

        return resultMap;
    }

    /**
     * Returns a map of data definition field identifier to actual fields of a data definition that is
     * assigned to a content type with given contentTypePath. If no data definition is assigned to the content
     * type, returns null.
     * 
     * @param projectInformation
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Map<String, DataDefinitionField> getDataDefinitionFieldsForContentType(ProjectInformation projectInformation,
            ContentType contentType) throws Exception
    {
        Authentication authentication = getAuthentication(projectInformation);

        // Check if data definition is assigned. If it isn't, return null (we will just create the XHTML
        // field).
        String dataDefinitionId = contentType.getDataDefinitionId();
        if (dataDefinitionId == null)
            return null;

        Identifier identifier = new Identifier(dataDefinitionId, null, EntityTypeString.datadefinition, false);
        ReadResult readResult = getServer(projectInformation.getUrl()).read(authentication, identifier);
        if (!readResult.getSuccess().equals("true"))
            throw new Exception("Error occured when reading a Data Definition with id '" + dataDefinitionId + "': " + readResult.getMessage());

        DataDefinition dataDefinition = readResult.getAsset().getDataDefinition();
        return XmlAnalyzer.analyzeDataDefinitionXml(dataDefinition.getXml());
    }

    /**
     * Creates a data definition block in Cascade Server based on the information provided in the
     * projectInformation and the actual file from which the block needs to be created.
     * 
     * @param blockFile
     * @param projectInformation
     * @return Returns the {@link CascadeAssetInformation} about the created block. Null means it was skipped
     *         due to XPath.
     * @throws Exception
     */
    public static CascadeAssetInformation createDataDefinitionBlock(java.io.File blockFile, ProjectInformation projectInformation) throws Exception
    {
        // Set up the block object and assign it to the asset object
        XhtmlDataDefinitionBlock block = WebServicesUtil.setupDataDefinitionBlockObject(blockFile, projectInformation);
        if (block == null)
            return null;

        String path = block.getParentFolderPath() + "/" + block.getName();
        String parentFolderPath = block.getParentFolderPath();

        String overwriteBehavior = projectInformation.getOverwriteBehavior();
        if (overwriteBehavior.equals(ProjectInformation.OVERWRITE_BEHAVIOR_SKIP_EXISTING))
        {
            String blockId = getAssetId(path, projectInformation);
            if (blockId != null)
                return new CascadeAssetInformation(blockId, path, true);
        }

        // Check for duplicate paths
        if (projectInformation.getMigrationStatus().getCreatedAssetPaths().contains(path.toLowerCase()))
            throw new Exception("Duplicate path found - asset with given path already got created during this migration: " + path.toLowerCase());

        Asset asset = new Asset();
        asset.setXhtmlDataDefinitionBlock(block);

        // Check overwrite behavior. If overwrite behavior is to update existing, check if block with given
        // path exists and if so, get its id
        String existingBlockId = null;
        if (overwriteBehavior.equals(ProjectInformation.OVERWRITE_BEHAVIOR_UPDATE_EXISTING))
            existingBlockId = getBlockId(path, projectInformation);
        // If overwite existing is selected, we need to delete the existing block and ignore an error if it
        // did
        // not exists and we attempted to delete it
        else if (overwriteBehavior.equals(ProjectInformation.OVERWRITE_BEHAVIOR_OVERWRITE_EXISTING))
            deleteDataDefinitionBlock(path, projectInformation);

        // If block doesn't exist or overwrite behavior is not to update existing, create the block and
        // ancestor
        // folders if necessary
        if (existingBlockId == null)
        {
            Authentication authentication = getAuthentication(projectInformation);
            CreateResult createResult = getServer(projectInformation.getUrl()).create(authentication, asset);

            // If the block couldn't be created because parent folder doesn't exist, go ahead and create the
            // parent folder and attempt to create the block again
            if (!createResult.getSuccess().equals("true"))
            {
                String message = createResult.getMessage();
                if (message != null && message.contains("folder with path/name: ") && message.contains(parentFolderPath.trim())
                        && message.contains("could not be found"))
                {
                    createFolder(parentFolderPath, projectInformation);
                    return createDataDefinitionBlock(blockFile, projectInformation);
                }

                throw new Exception("Block " + path + " could not be created: " + createResult.getMessage() + " - Parent folder path is: -"
                        + parentFolderPath + "-");
            }

            projectInformation.getExistingCascadeDataDefinitionBlocks().put(path.toLowerCase(), createResult.getCreatedAssetId());
            return new CascadeAssetInformation(createResult.getCreatedAssetId(), path);
        }

        // If block exists, edit it
        block.setId(existingBlockId);
        editDataDefinitionBlock(block, projectInformation);
        return new CascadeAssetInformation(existingBlockId, path);
    }

    /**
     * Creates a file asset in Cascade Server with contents from the <code>filesystemFile</code> if one does
     * not exist. The path of the file is figured out using webViewUrl in linkFile.xml in current or ancestor
     * folders. If file with that path already exists, it is left as it is.
     * 
     * @param filesystemFile
     * @param projectInformation
     * @param metadataSetId
     * @throws Exception
     */
    public static void createFile(java.io.File filesystemFile, ProjectInformation projectInformation, String metadataSetId) throws Exception
    {
        createFile(filesystemFile, projectInformation, metadataSetId, true);
    }

    /**
     * See {@link #createFile(java.io.File, ProjectInformation, String)}
     * 
     * @param filesystemFile
     * @param projectInformation
     * @param metadataSetId
     * @param logCreatingFile whether or not the "Creating file ..." message should be logged
     * @throws Exception
     */
    private static void createFile(java.io.File filesystemFile, ProjectInformation projectInformation, String metadataSetId, boolean logCreatingFile)
            throws Exception
    {
        String filePath = PathUtil.getRelativePath(filesystemFile, projectInformation.getXmlDirectory());
        if (!XmlAnalyzer.allCharactersLegal(filePath))
            filePath = XmlAnalyzer.removeIllegalCharacters(filePath);

        String parentFolderPath = PathUtil.getParentFolderPathFromPath(filePath);
        String fileName = filesystemFile.getName();

        MigrationStatus migrationStatus = projectInformation.getMigrationStatus();
        if (logCreatingFile)
            Log.add("Creating file in Cascade " + filePath + "... ", migrationStatus);

        if (projectInformation.getExistingCascadeFiles().keySet().contains(filePath.toLowerCase()))
        {
            migrationStatus.incrementAssetsSkipped();
            Log.add("<span style=\"color:blue;\">file already exists</span><br/>", migrationStatus);
            return;
        }

        if (filesystemFile.length() > (MAX_FILE_SIZE_MB * 1024 * 1024))
            throw new Exception("File is too large. Maximum file size is " + MAX_FILE_SIZE_MB + " MB");

        // Set up the file object and assign it to the asset object
        File file = new File();
        file.setName(fileName);
        file.setParentFolderPath(parentFolderPath);
        file.setSiteName(projectInformation.getSiteName());
        file.setMetadataSetId(metadataSetId);
        file.setShouldBeIndexed(true);
        file.setShouldBePublished(true);
        file.setData(FileSystem.getBytesFromFile(filesystemFile));

        Asset asset = new Asset();
        asset.setFile(file);

        Authentication authentication = getAuthentication(projectInformation);
        CreateResult createResult = getServer(projectInformation.getUrl()).create(authentication, asset);

        // If the file couldn't be created because parent folder doesn't exist, go ahead and create the
        // parent folder and attempt to create the file again
        if (!createResult.getSuccess().equals("true"))
        {
            String message = createResult.getMessage();
            if (message != null && message.contains("folder with path/name: ") && message.contains(parentFolderPath.trim())
                    && message.contains("could not be found"))
            {
                createFolder(parentFolderPath, projectInformation);
                createFile(filesystemFile, projectInformation, metadataSetId, false);
                return;
            }

            throw new Exception("File " + filePath + " could not be created: " + createResult.getMessage() + " - Parent folder path is: -"
                    + parentFolderPath + "-");
        }
        Identifier cascadeFile = new Identifier(createResult.getCreatedAssetId(), new Path(filePath, null, projectInformation.getSiteName()),
                EntityTypeString.file, false);

        projectInformation.getExistingCascadeFiles().put(filePath.toLowerCase(), createResult.getCreatedAssetId());

        Log.add(PathUtil.generateFileLink(cascadeFile, projectInformation.getUrl()), migrationStatus);

        migrationStatus.incrementAssetsCreated();
        Log.add("<span style=\"color: green;\">success.</span><br/>", migrationStatus);
    }

    /**
     * Reads an XHTML Block with given id from Cascade Server
     * 
     * @param id
     * @param projectInformation
     * @return
     * @throws Exception
     */
    public static XhtmlDataDefinitionBlock readDataDefinitionBlock(String id, ProjectInformation projectInformation) throws Exception
    {
        Authentication authentication = getAuthentication(projectInformation);
        Identifier identifier = new Identifier(id, null, EntityTypeString.block_XHTML_DATADEFINITION, false);
        ReadResult readResult = getServer(projectInformation.getUrl()).read(authentication, identifier);
        if (!readResult.getSuccess().equals("true"))
            throw new Exception("Error occured when reading an XHTML Block with id '" + id + "': " + readResult.getMessage());

        return readResult.getAsset().getXhtmlDataDefinitionBlock();
    }

    /**
     * Returns id of asset if it exists. Null otherwise.
     * 
     * @param path
     * @param projectInformation
     * @return
     * @throws Exception
     */
    public static String getAssetId(String path, ProjectInformation projectInformation) throws Exception
    {
        path = PathUtil.removeLeadingSlashes(path).toLowerCase();
        // Check confirmed paths first
        String fileId = projectInformation.getExistingCascadeFiles().get(path);
        if (fileId != null)
            return fileId;

        String blockId = projectInformation.getExistingCascadeDataDefinitionBlocks().get(path);
        if (blockId != null)
            return blockId;

        // If not found, try reading the asset by path
        XhtmlDataDefinitionBlock readDataDefinitionBlock = readDataDefinitionBlockByPath(path, projectInformation);
        if (readDataDefinitionBlock != null)
        {
            projectInformation.getExistingCascadeDataDefinitionBlocks().put(path, readDataDefinitionBlock.getId());
            return readDataDefinitionBlock.getId();
        }

        File readFile = readFileByPath(path, projectInformation);
        if (readFile != null)
        {
            projectInformation.getExistingCascadeFiles().put(path, readFile.getId());
            return readFile.getId();
        }

        return null;
    }

    /**
     * Reads all files and blocks in selected site and stores their paths in projectInformation so that later
     * it doesn't have to read whole the asset only to see if it exists (as it can be very slow if the asset
     * is big).
     * 
     * @param projectInformation
     * @throws Exception
     */
    public static void populateExistingCascadeAssets(ProjectInformation projectInformation) throws Exception
    {
        Identifier identifier = new Identifier(null, new Path("/", null, projectInformation.getSiteName()), EntityTypeString.folder, false);
        populateExistingCascadeAssetsOfFolder(identifier, projectInformation);
    }

    /**
     * Gets the names of the sites in Cascade
     * 
     * @param url
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    public static List<String> getSiteNames(String url, String username, String password) throws Exception
    {
        Authentication authentication = new Authentication(password, username);
        List<String> result = new ArrayList<String>();
        ListSitesResult sitesResult;
        sitesResult = getServer(url).listSites(authentication);

        if (!sitesResult.getSuccess().equals("true"))
            throw new Exception("Error occured when getting all sites: " + sitesResult.getMessage());

        for (Identifier site : sitesResult.getSites())
            result.add(site.getPath().getPath());

        return result;
    }

    /**
     * Recursively reads all assets from given folder and its descendants and stores their paths in
     * {@link ProjectInformation#getExistingCascadeFiles()},
     * {@link ProjectInformation#getExistingCascadeXhtmlBlocks()}
     * 
     * @param folderIdentifier
     * @param projectInformation
     * @throws Exception
     */
    private static void populateExistingCascadeAssetsOfFolder(Identifier folderIdentifier, ProjectInformation projectInformation) throws Exception
    {
        if (projectInformation.getMigrationStatus().isShouldStop())
            return;

        ReadResult readResult = getServer(projectInformation.getUrl()).read(getAuthentication(projectInformation), folderIdentifier);
        if (!readResult.getSuccess().equals("true"))
            throw new Exception("Error occured when reading a Cascade Folder with path '" + folderIdentifier.getPath().getPath() + "': "
                    + readResult.getMessage());

        Folder folder = readResult.getAsset().getFolder();
        Identifier[] children = folder.getChildren();
        for (Identifier child : children)
        {
            if (child.getType().equals(EntityTypeString.file))
                projectInformation.getExistingCascadeFiles().put(child.getPath().getPath().toLowerCase(), child.getId());
            else if (child.getType().equals(EntityTypeString.block_XHTML_DATADEFINITION))
                projectInformation.getExistingCascadeDataDefinitionBlocks().put(child.getPath().getPath().toLowerCase(), child.getId());
            else if (child.getType().equals(EntityTypeString.folder))
                populateExistingCascadeAssetsOfFolder(child, projectInformation);
        }

    }

    /**
     * Reads a block with given path and returns its id. If the block doesn't exist, returns null.
     * 
     * @param path
     * @param projectInformation
     * @return
     * @throws Exception
     */
    private static String getBlockId(String path, ProjectInformation projectInformation) throws Exception
    {
        XhtmlDataDefinitionBlock existingBlock = readDataDefinitionBlockByPath(path, projectInformation);
        if (existingBlock != null)
            return existingBlock.getId();

        return null;
    }

    /**
     * Reads a file with given path from Cascade Server. If the file doesn't exist, returns null.
     * 
     * @param path
     * @param projectInformation
     * @return
     * @throws Exception
     */
    private static File readFileByPath(String path, ProjectInformation projectInformation) throws Exception
    {
        String cachePath = PathUtil.getCachePathFromPath(path);
        String siteName = PathUtil.getSiteNameFromPath(path);
        if (siteName == null)
            siteName = projectInformation.getSiteName();

        Authentication authentication = getAuthentication(projectInformation);
        Identifier identifier = new Identifier(null, new Path(cachePath, null, siteName), EntityTypeString.file, false);
        ReadResult readResult = getServer(projectInformation.getUrl()).read(authentication, identifier);
        if (!readResult.getSuccess().equals("true")
                && (readResult.getMessage() == null || !readResult.getMessage().equals(
                        "Unable to identify an entity based on provided entity path '" + cachePath + "' and type 'file'")))
            throw new Exception("Error occured when reading a File with path '" + path + "': " + readResult.getMessage());

        return readResult.getSuccess().equals("true") ? readResult.getAsset().getFile() : null;
    }

    /**
     * Reads a data definition block with given path from Cascade Server. If the block doesn't exist, returns
     * null.
     * 
     * @param path
     * @param projectInformation
     * @return
     * @throws Exception
     */
    private static XhtmlDataDefinitionBlock readDataDefinitionBlockByPath(String path, ProjectInformation projectInformation) throws Exception
    {
        String cachePath = PathUtil.getCachePathFromPath(path);
        String siteName = PathUtil.getSiteNameFromPath(path);
        if (siteName == null)
            siteName = projectInformation.getSiteName();

        Authentication authentication = getAuthentication(projectInformation);
        Identifier identifier = new Identifier(null, new Path(cachePath, null, siteName), EntityTypeString.block_XHTML_DATADEFINITION, false);
        ReadResult readResult = getServer(projectInformation.getUrl()).read(authentication, identifier);
        if (!readResult.getSuccess().equals("true")
                && (readResult.getMessage() == null || !readResult.getMessage().equals(
                        "Unable to identify an entity based on provided entity path '" + cachePath + "' and type 'block'")))
            throw new Exception("Error occured when reading a Block with path '" + path + "': " + readResult.getMessage());

        return readResult.getSuccess().equals("true") ? readResult.getAsset().getXhtmlDataDefinitionBlock() : null;
    }

    /**
     * Sends an edit request for given XHTML Block through web services
     * 
     * @param block
     * @param projectInformation
     * @throws Exception
     */
    private static void editDataDefinitionBlock(XhtmlDataDefinitionBlock block, ProjectInformation projectInformation) throws Exception
    {
        Authentication authentication = getAuthentication(projectInformation);
        Asset asset = new Asset();
        asset.setXhtmlDataDefinitionBlock(block);
        OperationResult operationResult = getServer(projectInformation.getUrl()).edit(authentication, asset);

        if (!operationResult.getSuccess().equals("true"))
            throw new Exception("Error occured when editing an XHTML BLOCK with id '" + block.getId() + "': " + operationResult.getMessage());
    }

    /**
     * Asks Cascade Server to delete a data definition block with given path. If block didn't exist, the error
     * will be ignored. If some other problem occurred, an exception will be thrown.
     * 
     * @param path
     * @param projectInformation
     * @throws Exception
     */
    private static void deleteDataDefinitionBlock(String path, ProjectInformation projectInformation) throws Exception
    {
        Authentication authentication = getAuthentication(projectInformation);
        Identifier identifier = new Identifier(null, new Path(path, null, projectInformation.getSiteName()),
                EntityTypeString.block_XHTML_DATADEFINITION, false);
        OperationResult deleteResult = getServer(projectInformation.getUrl()).delete(authentication, identifier);

        if (!deleteResult.getSuccess().equals("true")
                && (deleteResult.getMessage() == null || !deleteResult.getMessage().equals(
                        "Unable to identify an entity based on provided entity path '" + path + "' and type 'block'")))
            throw new Exception("Error occured when deleting a Block with path '" + path + "': " + deleteResult.getMessage());
    }

    /**
     * Creates a folder with given path. If the parent folder cannot be found, it will create it.
     * 
     * @param path
     * @param projectInformation
     * @throws Exception
     */
    private static void createFolder(String path, ProjectInformation projectInformation) throws Exception
    {
        String parentFolderPath = PathUtil.getParentFolderPathFromPath(path);

        Folder folder = new Folder();
        folder.setName(PathUtil.getNameFromPath(path));
        folder.setParentFolderPath(parentFolderPath);
        folder.setSiteName(projectInformation.getSiteName());

        Asset asset = new Asset();
        asset.setFolder(folder);

        Authentication authentication = getAuthentication(projectInformation);
        CreateResult createResult = getServer(projectInformation.getUrl()).create(authentication, asset);

        // If the folder couldn't be create because parent folder doesn't exist, go ahead and create the
        // parent folder and attempt to create the folder again
        if (!createResult.getSuccess().equals("true"))
        {
            String message = createResult.getMessage();
            if (message != null && message.contains("folder with path/name: ") && message.contains(parentFolderPath.trim())
                    && message.contains("could not be found"))
            {
                createFolder(parentFolderPath, projectInformation);
                createFolder(path, projectInformation);
            }
            else
                throw new Exception("Parent folder " + path + " could not be created: " + createResult.getMessage() + " - Parent folder path is: -"
                        + parentFolderPath + "-");
        }
    }

    /**
     * Adds all ancestor content types of content type container with given id to the contentTypes list
     * 
     * @param projectInformation
     * @param containerId
     * @param contentTypes
     * @throws Exception
     */
    private static void collectContentTypes(ProjectInformation projectInformation, String containerId, List<ContentType> contentTypes)
            throws Exception
    {
        Authentication authentication = getAuthentication(projectInformation);
        Identifier identifier = new Identifier(containerId, null, EntityTypeString.contenttypecontainer, false);
        ReadResult readResult = getServer(projectInformation.getUrl()).read(authentication, identifier);
        if (!readResult.getSuccess().equals("true"))
            throw new Exception("Error occured when getting a list of available Content Types in the Site: " + readResult.getMessage());

        ContentTypeContainer container = readResult.getAsset().getContentTypeContainer();
        Identifier[] childIdentifiers = container.getChildren();
        for (Identifier childIdentifier : childIdentifiers)
            if (childIdentifier.getType().equals(EntityTypeString.contenttypecontainer))
                collectContentTypes(projectInformation, childIdentifier.getId(), contentTypes);
            else
                contentTypes.add(readContentType(projectInformation, childIdentifier.getId()));
    }

    /**
     * Reads a content type with given id
     * 
     * @param projectInformation
     * @param contentTypeId
     * @return
     * @throws Exception
     */
    private static ContentType readContentType(ProjectInformation projectInformation, String contentTypeId) throws Exception
    {
        Authentication authentication = getAuthentication(projectInformation);
        Identifier identifier = new Identifier(contentTypeId, null, EntityTypeString.contenttype, false);
        ReadResult readResult = getServer(projectInformation.getUrl()).read(authentication, identifier);
        if (!readResult.getSuccess().equals("true"))
            throw new Exception("Error occured when reading a Content Type with id '" + contentTypeId + "': " + readResult.getMessage());

        return readResult.getAsset().getContentType();
    }

    /**
     * Returns the AssetOperationHandler object based on given url
     * 
     * @param urlString
     * @return
     * @throws Exception
     */
    private static AssetOperationHandler getServer(String urlString) throws Exception
    {
        URL url = new URL(urlString);
        return new AssetOperationHandlerServiceLocator().getAssetOperationService(url);
    }

    /**
     * Returns the Authentication object based on the project information provided
     * 
     * @param projectInformation
     * @return
     */
    private static Authentication getAuthentication(ProjectInformation projectInformation)
    {
        return new Authentication(projectInformation.getPassword(), projectInformation.getUsername());
    }
}
