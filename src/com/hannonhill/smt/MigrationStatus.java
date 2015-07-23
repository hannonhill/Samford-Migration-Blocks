/*
 * Created on Dec 9, 2009 by Artur Tomusiak
 * 
 * Copyright(c) 2000-2009 Hannon Hill Corporation. All rights reserved.
 */
package com.hannonhill.smt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * An object containing information about the current status of the actual migration process
 * 
 * @author Artur Tomusiak
 * @since 1.0
 */
public class MigrationStatus extends TaskStatus
{
    private int assetsCreated;
    private int assetsSkipped;
    private int assetsWithErrors;

    private final List<CascadeAssetInformation> createdBlocks; // a list of ids of created blocks

    private final Set<String> createdAssetPaths; // to quickly check for duplicates

    /**
     * Constructor
     */
    public MigrationStatus()
    {
        super();

        assetsCreated = 0;
        assetsSkipped = 0;
        assetsWithErrors = 0;

        createdBlocks = new ArrayList<CascadeAssetInformation>();

        createdAssetPaths = new HashSet<String>();
    }

    /**
     * @return Returns the assetsCreated.
     */
    public int getAssetsCreated()
    {
        return assetsCreated;
    }

    /**
     * Increments the number of pages created by 1
     */
    public void incrementAssetsCreated()
    {
        assetsCreated++;
    }

    /**
     * @return Returns the pagesSkipped.
     */
    public int getAssetsSkipped()
    {
        return assetsSkipped;
    }

    /**
     * Increments the number of pages skipped by 1
     */
    public void incrementAssetsSkipped()
    {
        assetsSkipped++;
    }

    /**
     * @return Returns the assetsWithErrors.
     */
    public int getAssetsWithErrors()
    {
        return assetsWithErrors;
    }

    /**
     * Increments the number of assets with errors by 1
     */
    public void incrementAssetsWithErrors()
    {
        assetsWithErrors++;
    }

    /**
     * @return Returns the createdBlocks.
     */
    public List<CascadeAssetInformation> getCreatedBlocks()
    {
        return createdBlocks;
    }

    /**
     * Adds the created block to the list and its path to the set
     * 
     * @param block
     */
    public void addCreatedBlock(CascadeAssetInformation block)
    {
        createdBlocks.add(block);
        createdAssetPaths.add(block.getPath().toLowerCase());
    }

    /**
     * @return Returns the createdAssetPaths.
     */
    public Set<String> getCreatedAssetPaths()
    {
        return createdAssetPaths;
    }
}
