/*
 * Created on Aug 3, 2015 by tomusiaka
 * 
 * Copyright(c) 2000-2010 Hannon Hill Corporation.  All rights reserved.
 */
package com.hannonhill.smt;

import java.util.HashMap;
import java.util.Map;

public class ContentTypeMapping
{
    private ContentTypeInformation contentTypeInformation;
    private final Map<String, Field> fieldMapping; // a mapping from an XPath to a Cascade field
    private final Map<Field, String> staticValueMapping; // this mapping maps from a Cascade field to its
                                                         // static value it should get
    private String dataDefinitionBlockXPath = "";

    public ContentTypeMapping(ContentTypeInformation contentTypeInformation)
    {
        this.contentTypeInformation = contentTypeInformation;
        this.fieldMapping = new HashMap<String, Field>();
        this.staticValueMapping = new HashMap<Field, String>();
        this.dataDefinitionBlockXPath = "";
    }

    /**
     * @return Returns the dataDefinitionBlockXPath.
     */
    public String getDataDefinitionBlockXPath()
    {
        return dataDefinitionBlockXPath;
    }

    /**
     * @param dataDefinitionBlockXPath the dataDefinitionBlockXPath to set
     */
    public void setDataDefinitionBlockXPath(String dataDefinitionBlockXPath)
    {
        this.dataDefinitionBlockXPath = dataDefinitionBlockXPath;
    }

    /**
     * @return Returns the fieldMapping.
     */
    public Map<String, Field> getFieldMapping()
    {
        return fieldMapping;
    }

    /**
     * @return Returns the staticValueMapping.
     */
    public Map<Field, String> getStaticValueMapping()
    {
        return staticValueMapping;
    }

    /**
     * @param contentTypeInformation the contentTypeInformation to set
     */
    public void setContentTypeInformation(ContentTypeInformation contentTypeInformation)
    {
        this.contentTypeInformation = contentTypeInformation;
    }

    /**
     * @return Returns the contentTypeInformation.
     */
    public ContentTypeInformation getContentTypeInformation()
    {
        return contentTypeInformation;
    }

}
