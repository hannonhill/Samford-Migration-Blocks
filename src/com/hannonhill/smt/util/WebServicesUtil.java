/*
 * Created on Dec 7, 2009 by Artur Tomusiak
 * 
 * Copyright(c) 2000-2009 Hannon Hill Corporation. All rights reserved.
 */
package com.hannonhill.smt.util;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import com.hannonhill.smt.ChooserType;
import com.hannonhill.smt.ContentTypeMapping;
import com.hannonhill.smt.DataDefinitionField;
import com.hannonhill.smt.Field;
import com.hannonhill.smt.MetadataSetField;
import com.hannonhill.smt.ProjectInformation;
import com.hannonhill.smt.TaskStatus;
import com.hannonhill.smt.service.FileSystem;
import com.hannonhill.smt.service.JTidy;
import com.hannonhill.smt.service.LinkRewriter;
import com.hannonhill.smt.service.Log;
import com.hannonhill.smt.service.WebServices;
import com.hannonhill.smt.service.XmlAnalyzer;
import com.hannonhill.www.ws.ns.AssetOperationService.DynamicMetadataField;
import com.hannonhill.www.ws.ns.AssetOperationService.FieldValue;
import com.hannonhill.www.ws.ns.AssetOperationService.Metadata;
import com.hannonhill.www.ws.ns.AssetOperationService.StructuredData;
import com.hannonhill.www.ws.ns.AssetOperationService.StructuredDataAssetType;
import com.hannonhill.www.ws.ns.AssetOperationService.StructuredDataNode;
import com.hannonhill.www.ws.ns.AssetOperationService.StructuredDataType;
import com.hannonhill.www.ws.ns.AssetOperationService.XhtmlDataDefinitionBlock;

/**
 * Utility class with helper methods related to web services
 * 
 * @author Artur Tomusiak
 * @since 1.0
 */
public class WebServicesUtil
{
    private static final String NAME_XPATH = "/Content/Title/text()";
    private static final String ID_XPATH = "/Content/@ContentId";

    /**
     * Creates a Data Definition Block object based on the information provided in the projectInformation and
     * the actual file from which the Data Definition Block needs to be created.
     * 
     * @param blockFile
     * @param projectInformation
     * @return Null means that the block was skipped due to XPath
     * @throws Exception
     */
    public static XhtmlDataDefinitionBlock setupDataDefinitionBlockObject(File blockFile, ProjectInformation projectInformation) throws Exception
    {
        String fileContents = JTidy.tidyContentConditionallyFullHtml(FileSystem.getFileContents(blockFile));
        ContentTypeMapping contentTypeMapping = null;
        for (ContentTypeMapping ctMapping : projectInformation.getMappedContentTypes())
        {
            String blockXPath = ctMapping.getDataDefinitionBlockXPath();
            if (blockXPath != null && !blockXPath.equals(""))
            {
                String xpathResult = XmlUtil.evaluateXPathExpression(fileContents, ctMapping.getDataDefinitionBlockXPath());
                if (xpathResult != null && !xpathResult.equals(""))
                {
                    contentTypeMapping = ctMapping;
                    break;
                }
            }
        }

        if (contentTypeMapping == null)
            return null;

        String parentFolderPath = XmlUtil.evaluateXPathExpression(fileContents, "/Content/@Path");
        if (parentFolderPath == null)
            throw new Exception("Could not find path");
        if (!XmlAnalyzer.allCharactersLegal(parentFolderPath))
            parentFolderPath = XmlAnalyzer.removeIllegalCharacters(parentFolderPath);
        if (parentFolderPath.endsWith("/"))
            parentFolderPath = parentFolderPath.substring(0, parentFolderPath.length() - 1);
        if (parentFolderPath.startsWith("/"))
            parentFolderPath = parentFolderPath.substring(1, parentFolderPath.length());

        if (parentFolderPath.equals(""))
            parentFolderPath = "/";

        String blockName = XmlUtil.evaluateXPathExpression(fileContents, NAME_XPATH);
        if (blockName == null || blockName.equals(""))
            throw new Exception("Could not find name using XPath " + NAME_XPATH);
        blockName = XmlAnalyzer.removeIllegalCharactersInName(blockName);

        Set<String> metadataFieldNames = contentTypeMapping.getContentTypeInformation().getMetadataFields().keySet();

        XhtmlDataDefinitionBlock block = new XhtmlDataDefinitionBlock();
        block.setMetadataSetId(contentTypeMapping.getContentTypeInformation().getMetadataSetId());
        block.setName(blockName);
        block.setParentFolderPath(parentFolderPath);
        block.setSiteName(projectInformation.getSiteName());
        block.setMetadata(createMetadata(projectInformation, contentTypeMapping, fileContents, metadataFieldNames,
                projectInformation.getMigrationStatus()));

        // Create the structured data object with the tree of structured data nodes
        StructuredData structuredData = createStructuredData(projectInformation, contentTypeMapping, fileContents,
                parentFolderPath + "/" + blockName, contentTypeMapping.getContentTypeInformation().getDataDefinitionId());

        // If block uses data definition, assign it to the block object
        if (contentTypeMapping.getContentTypeInformation().isUsesDataDefinition())
            block.setStructuredData(structuredData);
        else
        {
            // if block does not use data definition, the tree mapping should contain only a single xhtml
            // field
            StructuredDataNode[] xhtmlNodes = structuredData.getStructuredDataNodes();
            String xhtml = null;
            if (xhtmlNodes.length == 1)
                xhtml = xhtmlNodes[0].getText();
            else if (xhtmlNodes.length == 0)
                ; // do nothing, no mappings
            else
                throw new Exception("The mappings for a block without Data Definition contains more than one field.");
            block.setXhtml(xhtml == null ? "" : xhtml);
        }

        return block;
    }

    /**
     * Creates the structured data object with the values from the fileContents. U
     * 
     * @param projectInformation
     * @param contentTypeMapping
     * @param fileContents
     * @param assetPath
     * @param dataDefinitionId
     * @return
     * @throws Exception
     */
    private static StructuredData createStructuredData(ProjectInformation projectInformation, ContentTypeMapping contentTypeMapping,
            String fileContents, String assetPath, String dataDefinitionId) throws Exception
    {
        // Create the root group object to which all the information will be attached
        StructuredDataGroup rootGroup = new StructuredDataGroup();

        // For each field mapping assign appropriate value in structured data
        for (String xPath : contentTypeMapping.getFieldMapping().keySet())
        {
            Field field = contentTypeMapping.getFieldMapping().get(xPath);

            if (field == null || !(field instanceof DataDefinitionField))
                continue;

            DataDefinitionField ddField = (DataDefinitionField) field;
            // Handle multiple field
            if (ddField.isMultiple())
            {
                List<String> fieldValues = XmlUtil.evaluateXPathExpressionAsList(fileContents, xPath);
                for (String fieldValue : fieldValues)
                {
                    if (ddField.isWysiwyg())
                        fieldValue = LinkRewriter.rewriteLinksInXml(fieldValue, assetPath, projectInformation);

                    assignAppropriateFieldValue(rootGroup, (DataDefinitionField) field, fieldValue, projectInformation);
                }

            }
            // Handle single field
            else
            {
                String fieldValue = XmlUtil.evaluateXPathExpression(fileContents, xPath);
                if (ddField.isWysiwyg())
                    fieldValue = LinkRewriter.rewriteLinksInXml(fieldValue, assetPath, projectInformation);

                assignAppropriateFieldValue(rootGroup, (DataDefinitionField) field, fieldValue, projectInformation);
            }
        }

        // For each static value field, assign the static value in structured data
        for (Field field : contentTypeMapping.getStaticValueMapping().keySet())
            if (field instanceof DataDefinitionField)
            {
                // Escape ampersands to make it a valid xml
                String fieldValue = contentTypeMapping.getStaticValueMapping().get(field).replaceAll("&", "&amp;");
                assignAppropriateFieldValue(rootGroup, (DataDefinitionField) field, fieldValue, projectInformation);
            }

        return convertToStructuredData(rootGroup, dataDefinitionId);
    }

    /**
     * Creates the metadata object with the values from the fileContents.
     * 
     * @param projectInformation
     * @param contentTypeMapping
     * @param fileContents
     * @param availableMetadataFieldNames
     * @param taskStatus
     * @return
     * @throws Exception
     */
    private static Metadata createMetadata(ProjectInformation projectInformation, ContentTypeMapping contentTypeMapping, String fileContents,
            Set<String> availableMetadataFieldNames, TaskStatus taskStatus) throws Exception
    {
        // Create the metadata object and the list of dynamic fields
        Metadata metadata = new Metadata();
        List<DynamicMetadataField> dynamicFieldsList = new ArrayList<DynamicMetadataField>();

        // A web services bug work-around: supply all dynamic metadata field values as empty strings first
        for (String metadataFieldName : availableMetadataFieldNames)
            if (!WebServices.STANDARD_METADATA_FIELD_IDENTIFIERS.contains(metadataFieldName))
                dynamicFieldsList.add(new DynamicMetadataField(metadataFieldName, new FieldValue[]
                {
                    new FieldValue("")
                }));

        // Assign id
        String id = XmlUtil.evaluateXPathExpression(fileContents, ID_XPATH);
        MetadataSetField idField = contentTypeMapping.getContentTypeInformation().getMetadataFields()
                .get(ProjectInformation.METADATA_ID_FIELD_IDENTIFIER);
        assignAppropriateFieldValue(metadata, dynamicFieldsList, idField, id, taskStatus);

        // For each field mapping assign appropriate value in metadata
        for (String xPath : contentTypeMapping.getFieldMapping().keySet())
        {
            Field field = contentTypeMapping.getFieldMapping().get(xPath);

            if (field == null)
                continue;

            if (field instanceof MetadataSetField)
            {
                String fieldValue = XmlUtil.evaluateXPathExpression(fileContents, xPath);
                fieldValue = trimMetadataFieldValue(field.getIdentifier(), fieldValue, taskStatus);
                assignAppropriateFieldValue(metadata, dynamicFieldsList, (MetadataSetField) field, fieldValue, taskStatus);
            }
        }

        // For each static value field, assign the static value in the metadata
        for (Field field : contentTypeMapping.getStaticValueMapping().keySet())
            if (field instanceof MetadataSetField)
            {
                // Escape ampersands to make it a valid xml
                String fieldValue = trimMetadataFieldValue(field.getIdentifier(),
                        contentTypeMapping.getStaticValueMapping().get(field).replaceAll("&", "&amp;"), taskStatus);
                assignAppropriateFieldValue(metadata, dynamicFieldsList, (MetadataSetField) field, fieldValue, taskStatus);
            }

        // Convert the list of dynamic field to an array and assign it to the metadata object
        metadata.setDynamicFields(dynamicFieldsList.toArray(new DynamicMetadataField[dynamicFieldsList.size()]));
        return metadata;
    }

    /**
     * Checks if given field value has more than 250 characters and if so, returns only the first 250 and
     * outputs a warning in the log.
     * 
     * @param fieldName used for logging purposes
     * @param fieldValue field value to check
     * @param taskStatus used for logging purposes
     * @return
     */
    private static String trimMetadataFieldValue(String fieldName, String fieldValue, TaskStatus taskStatus)
    {
        int maxLength = 250;

        if (WebServices.LONG_METADATA_FIELDS.contains(fieldName))
            maxLength = 65535;

        if (fieldValue == null || fieldValue.length() <= maxLength)
            return fieldValue;

        Log.add("<span style=\"color:orange;\">Cascade metadata field \"" + fieldName + "\" contains " + fieldValue.length()
                + " characters. Trimming to " + maxLength + ".</span>", taskStatus);
        return fieldValue.substring(0, maxLength);
    }

    /**
     * Assigns given fieldValue of given fieldName to metadata object if it is a standard metadata field or
     * adds it to the list of dynamicFields.
     * 
     * @param metadata
     * @param dynamicFields
     * @param field
     * @param fieldValue
     * @param taskStatus
     * @throws Exception
     */
    private static void assignAppropriateFieldValue(Metadata metadata, List<DynamicMetadataField> dynamicFields, MetadataSetField field,
            String fieldValue, TaskStatus taskStatus) throws Exception
    {
        String fieldName = field.getIdentifier();

        // If it is a standard metadata field, call the appropriate setter
        if (!field.isDynamic() && WebServices.CALENDAR_METADATA_FIELD_IDENTIFIERS.contains(fieldName))
        {
            TimeZone utc = TimeZone.getTimeZone("CST"); // Dates are parsed based on the central standard time
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
            sdf.setTimeZone(utc);
            try
            {
                Date date = sdf.parse(fieldValue);
                Calendar calendarValue = new GregorianCalendar(utc);
                calendarValue.setTime(date);
                Metadata.class.getMethod("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), Calendar.class).invoke(metadata,
                        calendarValue);
            }
            catch (ParseException e)
            {
                Log.add("<span style=\"color:orange;\">Cascade metadata field \"" + fieldName + "\" contains value " + fieldValue
                        + " that cannot be parsed into a calendar format. The proper format is YYYY-MM-DD. Skipping this field.</span>", taskStatus);
            }
        }
        else if (!field.isDynamic() && !WebServices.CALENDAR_METADATA_FIELD_IDENTIFIERS.contains(fieldName))
            Metadata.class.getMethod("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), String.class).invoke(metadata,
                    fieldValue);
        // If it is not a standard metadata field, add a dynamic field
        else
        {
            // Remove the previous assignment
            for (DynamicMetadataField dynamicField : dynamicFields)
                if (dynamicField.getName().equals(fieldName))
                {
                    dynamicFields.remove(dynamicField);
                    break;
                }

            // Add the current one
            dynamicFields.add(new DynamicMetadataField(fieldName, new FieldValue[]
            {
                new FieldValue(fieldValue)
            }));
        }
    }

    /**
     * Assigns given fieldValue of given fieldName as the path to the actual field identifier to structured
     * data object forming a structural tree if necessary.
     * 
     * @param rootGroup
     * @param field
     * @param fieldValue
     * @param projectInformation
     */
    private static void assignAppropriateFieldValue(StructuredDataGroup rootGroup, DataDefinitionField field, String fieldValue,
            ProjectInformation projectInformation) throws Exception
    {
        String fieldName = field.getIdentifier();
        int lastSlashIdx = fieldName.lastIndexOf('/');
        String identifier = lastSlashIdx == -1 ? fieldName : fieldName.substring(lastSlashIdx + 1);
        String groupsPath = lastSlashIdx == -1 ? "" : fieldName.substring(0, lastSlashIdx);
        StructuredDataGroup currentNode = rootGroup;

        if (!groupsPath.equals(""))
        {
            String[] groups = groupsPath.split("/");
            for (String group : groups)
            {
                StructuredDataGroup thisGroup = currentNode.getGroups().get(group);
                if (thisGroup == null)
                {
                    thisGroup = new StructuredDataGroup();
                    currentNode.getGroups().put(group, thisGroup);
                }

                currentNode = thisGroup;
            }
        }

        if (field.getChooserType() == null)
        {
            fieldValue = JTidy.tidyContentConditionally(fieldValue);
            StructuredDataNode textNode = new StructuredDataNode();
            textNode.setIdentifier(identifier);
            textNode.setText(fieldValue);
            textNode.setType(StructuredDataType.text);
            addStructuredDataNode(currentNode.getContentFields(), textNode);
        }
        else if (field.getChooserType() == ChooserType.FILE)
        {
            fieldValue = JTidy.tidyContentConditionally(fieldValue);
            String path = XmlAnalyzer.getFirstSrcAttribute(fieldValue);

            if (path == null)
                path = fieldValue;

            if (path != null && !path.trim().equals(""))
            {
                path = path.trim();
                if (WebServices.getAssetId(path, projectInformation) != null)
                {
                    StructuredDataNode fileNode = new StructuredDataNode();
                    fileNode.setIdentifier(identifier);
                    fileNode.setFilePath(path);
                    fileNode.setType(StructuredDataType.asset);
                    fileNode.setAssetType(StructuredDataAssetType.fromString("file"));
                    addStructuredDataNode(currentNode.getContentFields(), fileNode);
                }
            }
        }
    }

    /**
     * Adds given node to a list of existing nodes if the list already exists in the <code>nodes</code> map
     * based on the node's identifier. If it does not exist, creates a new list there and adds the node to it.
     * 
     * @param nodes
     * @param node
     */
    private static void addStructuredDataNode(Map<String, List<StructuredDataNode>> nodes, StructuredDataNode node)
    {
        String identifier = node.getIdentifier();
        List<StructuredDataNode> nodeList = nodes.get(identifier);
        if (nodeList == null)
        {
            nodeList = new ArrayList<StructuredDataNode>();
            nodes.put(identifier, nodeList);
        }
        nodeList.add(node);
    }

    /**
     * Converts elements from rootGroup to StructuredData object with all the ancestry (hierarchy)
     * 
     * @param rootGroup
     * @param dataDefinitionid
     * @return
     */
    private static StructuredData convertToStructuredData(StructuredDataGroup rootGroup, String dataDefintionId)
    {
        StructuredData structuredData = new StructuredData();
        structuredData.setStructuredDataNodes(convertToStructuredDataNodes(rootGroup));
        structuredData.setDefinitionId(dataDefintionId);
        return structuredData;
    }

    /**
     * Converts group and its descendants with its contents to an array of StructuredDataNode objects
     * recursively.
     * 
     * @param group
     * @return
     */
    private static StructuredDataNode[] convertToStructuredDataNodes(StructuredDataGroup group)
    {
        List<StructuredDataNode> result = new ArrayList<StructuredDataNode>();

        for (String contentFieldIdentifier : group.getContentFields().keySet())
            for (StructuredDataNode structuredDataNode : group.getContentFields().get(contentFieldIdentifier))
                result.add(structuredDataNode);

        for (String groupIdentifier : group.getGroups().keySet())
        {
            StructuredDataGroup groupNode = group.getGroups().get(groupIdentifier);
            StructuredDataNode structuredDataNode = new StructuredDataNode();
            structuredDataNode.setIdentifier(groupIdentifier);
            structuredDataNode.setType(StructuredDataType.group);
            structuredDataNode.setStructuredDataNodes(convertToStructuredDataNodes(groupNode));
            result.add(structuredDataNode);
        }
        return result.toArray(new StructuredDataNode[0]);
    }

    /**
     * Represents a StructuredDataNode of type group. Using this instead of
     * {@link com.hannonhill.www.ws.ns.AssetOperationService.StructuredDataNode} of type group because we want
     * to deal with Maps instead of arrays for easy and fast insert and search.
     * 
     * @author Artur Tomusiak
     * @since 1.0
     */
    private static class StructuredDataGroup
    {
        // the fields in the group with their values
        private final Map<String, List<StructuredDataNode>> contentFields = new HashMap<String, List<StructuredDataNode>>();

        // other groups in the group
        private final Map<String, StructuredDataGroup> groups = new HashMap<String, StructuredDataGroup>();

        /**
         * @return Returns the groups.
         */
        public Map<String, StructuredDataGroup> getGroups()
        {
            return groups;
        }

        /**
         * @return Returns the contentFields.
         */
        public Map<String, List<StructuredDataNode>> getContentFields()
        {
            return contentFields;
        }
    }
}
