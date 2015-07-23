/*
 * Created on Dec 2, 2009 by Artur Tomusiak
 * 
 * Copyright(c) 2000-2009 Hannon Hill Corporation. All rights reserved.
 */
package com.hannonhill.smt.service;

import java.io.File;
import java.util.Set;

import com.hannonhill.smt.CascadeAssetInformation;
import com.hannonhill.smt.MigrationStatus;
import com.hannonhill.smt.ProjectInformation;
import com.hannonhill.smt.util.PathUtil;

/**
 * A service responsible for the actual migration
 * 
 * @author Artur Tomusiak
 * @since 1.0
 */
public class Migrator
{
    /**
     * Creates files in Cascade that do not end with {@link XmlAnalyzer#FILE_TO_PAGE_EXTENSIONS} or
     * {@link XmlAnalyzer#FILE_TO_BLOCK_EXTENSIONS} extension and are not hidden (do not start with "."). Uses
     * {@link ProjectInformation#getFilesToProcess()} to get the actual files.
     * 
     * @param files
     * @param projectInformation
     * @param metadataSetId
     */
    private static void createFiles(ProjectInformation projectInformation, String metadataSetId)
    {
        for (File folderFile : projectInformation.getFilesToProcess())
        {
            if (projectInformation.getMigrationStatus().isShouldStop())
                return;

            String name = folderFile.getName();

            // Skip hidden files and folders
            if (name.startsWith("."))
                continue;

            String extension = PathUtil.getExtension(name);
            if (projectInformation.getDataDefinitionBlockExtensions().contains(extension))
                continue;

            createFile(folderFile, projectInformation, metadataSetId);
            projectInformation.getMigrationStatus().incrementProgress(2);
        }
    }

    /**
     * Creates a file asset in Cascade based on the information from the passed filesystem {@link File}.
     * 
     * @param folderFile
     * @param projectInformation
     * @param metadataSetId
     */
    private static void createFile(File folderFile, ProjectInformation projectInformation, String metadataSetId)
    {
        MigrationStatus migrationStatus = projectInformation.getMigrationStatus();
        try
        {
            WebServices.createFile(folderFile, projectInformation, metadataSetId);
        }
        catch (Exception e)
        {
            // Sometimes the exception message is null, so we get the message from the parent
            // exception
            String message = e.getMessage();
            if (message == null && e.getCause() != null)
                message = e.getCause().getMessage();

            Log.add("<span class=\"text-error\">Error when creating a file: " + message + "</span><br/>", migrationStatus);
            e.printStackTrace();
            migrationStatus.incrementAssetsWithErrors();
        }
    }

    /**
     * Creates blocks based on the information provided in {@link ProjectInformation}
     * 
     * @param projectInformation
     */
    public static void createBlocks(ProjectInformation projectInformation)
    {
        Set<File> filesToProcess = projectInformation.getFilesToProcess();
        MigrationStatus migrationStatus = projectInformation.getMigrationStatus();
        String metadataSetId = null;

        // Get site's default metadata set id
        try
        {
            String siteName = projectInformation.getSiteName();
            metadataSetId = WebServices.readSite(projectInformation.getUsername(), projectInformation.getPassword(), projectInformation.getUrl(),
                    siteName).getDefaultMetadataSetId();
        }
        catch (Exception e)
        {
            // Sometimes the exception message is null, so we get the message from the parent exception
            String message = e.getMessage();
            if (message == null && e.getCause() != null)
                message = e.getCause().getMessage();

            Log.add("<span class=\"text-error\">Error when reading site's metadata set: " + message + "</span><br/>", migrationStatus);
            e.printStackTrace();
            return;
        }

        // Create file assets
        try
        {
            // Store existing file paths first to speed up creation of files
            Log.add("Reading Cascade folder structure...<br/>", migrationStatus);
            WebServices.populateExistingCascadeAssets(projectInformation);

            // Create files that do not exist in Cascade
            createFiles(projectInformation, metadataSetId);
        }
        catch (Exception e)
        {
            // Sometimes the exception message is null, so we get the message from the parent exception
            String message = e.getMessage();
            if (message == null && e.getCause() != null)
                message = e.getCause().getMessage();

            Log.add("<span class=\"text-error\">Error when uploading files: " + message + "</span><br/>", migrationStatus);
            e.printStackTrace();
        }

        for (File file : filesToProcess)
        {
            if (migrationStatus.isShouldStop())
                return;

            String name = file.getName();
            String extension = PathUtil.getExtension(name);

            if (!projectInformation.getDataDefinitionBlockExtensions().contains(extension))
                continue;

            try
            {
                // To build the file path that needs to be displayed, we show only the part of the abosute
                // path after the xml directory
                String relativePath = PathUtil.getRelativePath(file, projectInformation.getXmlDirectory());

                if (!XmlAnalyzer.allCharactersLegal(relativePath))
                    relativePath = XmlAnalyzer.removeIllegalCharacters(relativePath);

                Log.add("Creating an XHTML/Data Defintion block from file " + relativePath + "... ", migrationStatus);

                CascadeAssetInformation cascadeBlock = WebServices.createDataDefinitionBlock(file, projectInformation);

                Log.add(PathUtil.generateBlockLink(cascadeBlock, projectInformation.getUrl()), migrationStatus);

                migrationStatus.incrementProgress(1);
                migrationStatus.addCreatedBlock(cascadeBlock);

                // Add the block to the list because links will need to be realigned.
                if (cascadeBlock.isAlreadyExisted())
                {
                    migrationStatus.incrementAssetsSkipped();
                    Log.add("<span class=\"text-warning\">already existed.</span><br/>", migrationStatus);
                }
                else
                {
                    migrationStatus.incrementAssetsCreated();
                    Log.add("<span class=\"text-success\">success.</span><br/>", migrationStatus);
                }
            }
            catch (Exception e)
            {
                // Sometimes the exception message is null, so we get the message from the parent exception
                String message = e.getMessage();
                if (message == null && e.getCause() != null)
                    message = e.getCause().getMessage();

                Log.add("<span class=\"text-error\">Error: " + message + "</span><br/>", migrationStatus);

                // Increment progress by 2, because no link alignment will be needed for it
                migrationStatus.incrementProgress(2);
                migrationStatus.incrementAssetsWithErrors();

                e.printStackTrace();
            }
        }
    }
}
