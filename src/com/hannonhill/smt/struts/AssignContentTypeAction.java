/*
 * Created on Nov 24, 2009 by Artur Tomusiak
 * 
 * Copyright(c) 2000-2009 Hannon Hill Corporation. All rights reserved.
 */
package com.hannonhill.smt.struts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hannonhill.smt.ContentTypeInformation;
import com.hannonhill.smt.ContentTypeMapping;
import com.hannonhill.smt.ProjectInformation;
import com.hannonhill.smt.service.MappingPersister;

/**
 * In this action user is assigning the asset types from xml to Content Types in Cascade
 * 
 * @author Artur Tomusiak
 * @since 1.0
 */
public class AssignContentTypeAction extends BaseAction
{
    private static final long serialVersionUID = 3992252452526228826L;

    private final List<String> contentTypes = new ArrayList<String>(); // a list of available Cascade Content
                                                                       // Type paths in given site
    private final List<ContentTypeMapping> mappedContentTypes = new ArrayList<ContentTypeMapping>();

    private String dataDefinitionBlockExtensions;
    private String[] selectedContentTypes = new String[0]; // the Cascade Content Type path selected by the
                                                           // user after the form submission

    private String[] dataDefinitionBlockXPaths = new String[0];

    @Override
    public String execute() throws Exception
    {
        if (isSubmit())
            return processSubmit();

        return processView();
    }

    /**
     * Processes the form submission
     * 
     * @return
     */
    private String processSubmit()
    {
        ProjectInformation projectInformation = getProjectInformation();

        if (dataDefinitionBlockExtensions == null || dataDefinitionBlockExtensions.trim().equals(""))
        {
            addActionError("You must at least one page extension");
            return processView();
        }
        projectInformation.getDataDefinitionBlockExtensions().clear();
        projectInformation.setDataDefinitionBlockExtensions(dataDefinitionBlockExtensions);

        if (selectedContentTypes.length == 0)
        {
            addActionError("You must select at least one content type");
            return processView();
        }

        // Trim the mappings that were removed
        int mappingsSize = projectInformation.getMappedContentTypes().size();
        for (int i = selectedContentTypes.length; i < mappingsSize; i++)
            projectInformation.getMappedContentTypes().remove(selectedContentTypes.length);

        // Then add new ones or update existing ones
        for (int i = 0; i < selectedContentTypes.length; i++)
        {
            String selectedContentType = selectedContentTypes[i];
            if (selectedContentType.equals(""))
            {
                addActionError("You must select a content type");
                return processView();
            }

            ContentTypeInformation ctInfo = projectInformation.getContentTypes().get(selectedContentType);
            if (ctInfo != null)
            {
                if (i >= projectInformation.getMappedContentTypes().size())
                    projectInformation.getMappedContentTypes().add(new ContentTypeMapping(ctInfo));
                else
                {
                    ContentTypeMapping ctMapping = projectInformation.getMappedContentTypes().get(i);
                    ctMapping.setContentTypeInformation(ctInfo);
                }
            }
        }

        for (int i = 0; i < dataDefinitionBlockXPaths.length; i++)
            projectInformation.getMappedContentTypes().get(i).setDataDefinitionBlockXPath(dataDefinitionBlockXPaths[i]);

        try
        {
            MappingPersister.persistMappings(projectInformation);
        }
        catch (Exception e)
        {
            addActionError("An error occured: " + e.getMessage());
            return processView();
        }

        return SUCCESS;
    }

    /**
     * Sets appropriate information to be able to display the form
     * 
     * @return
     */
    private String processView()
    {
        ProjectInformation projectInformation = getProjectInformation();

        dataDefinitionBlockExtensions = projectInformation.getDataDefinitionBlockExtensionsString();
        contentTypes.addAll(projectInformation.getContentTypes().keySet());
        mappedContentTypes.addAll(projectInformation.getMappedContentTypes());

        Collections.sort(contentTypes);

        return INPUT;
    }

    /**
     * @return Returns the contentTypes.
     */
    public List<String> getContentTypes()
    {
        return contentTypes;
    }

    /**
     * @return Returns the selectedContentTypes.
     */
    public String[] getSelectedContentTypes()
    {
        return selectedContentTypes;
    }

    /**
     * @param selectedContentTypes the selectedContentTypes to set
     */
    public void setSelectedContentTypes(String[] selectedContentTypes)
    {
        this.selectedContentTypes = selectedContentTypes;
    }

    /**
     * @return Returns an action that should be used for the "Previous" button
     */
    public String getPreviousLink()
    {
        return "/AssignRootLevelFolders";
    }

    /**
     * @return Returns the dataDefinitionBlockExtensions.
     */
    public String getDataDefinitionBlockExtensions()
    {
        return dataDefinitionBlockExtensions;
    }

    /**
     * @param dataDefinitionBlockExtensions the dataDefinitionBlockExtensions to set
     */
    public void setDataDefinitionBlockExtensions(String dataDefinitionBlockExtensions)
    {
        this.dataDefinitionBlockExtensions = dataDefinitionBlockExtensions;
    }

    /**
     * @return Returns the dataDefinitionBlockXPaths.
     */
    public String[] getDataDefinitionBlockXPaths()
    {
        return dataDefinitionBlockXPaths;
    }

    /**
     * @param dataDefinitionBlockXPaths the dataDefinitionBlockXPaths to set
     */
    public void setDataDefinitionBlockXPaths(String[] dataDefinitionBlockXPaths)
    {
        this.dataDefinitionBlockXPaths = dataDefinitionBlockXPaths;
    }

    /**
     * @return Returns the mappedContentTypes.
     */
    public List<ContentTypeMapping> getMappedContentTypes()
    {
        return mappedContentTypes;
    }
}
