/*
 * Created on Dec 28, 2009 by Artur Tomusiak
 * 
 * Copyright(c) 2000-2009 Hannon Hill Corporation.  All rights reserved.
 */
package com.hannonhill.smt.task;

import com.hannonhill.smt.MigrationStatus;
import com.hannonhill.smt.ProjectInformation;
import com.hannonhill.smt.service.Log;
import com.hannonhill.smt.service.Migrator;

/**
 * The background migration task
 * 
 * @author Artur Tomusiak
 * @since 1.0
 */
public class MigrationTask extends Thread
{
    public final static String TASK_NAME = "migration";
    private final ProjectInformation projectInformation;

    /**
     * Constructor
     * 
     * @param projectInformation
     */
    public MigrationTask(ProjectInformation projectInformation)
    {
        this.projectInformation = projectInformation;
    }

    /**
     * Runs the migration
     */
    @Override
    public void run()
    {
        MigrationStatus migrationStatus = new MigrationStatus();
        Log.createFile(projectInformation, migrationStatus, "migration");
        projectInformation.setMigrationStatus(migrationStatus);
        projectInformation.setCurrentTask(TASK_NAME);

        Migrator.createBlocks(projectInformation);
        if (migrationStatus.isShouldStop())
            Log.add("<br/>Migration stopped by the user.<br/>", migrationStatus);

        migrationStatus.setCompleted(true);
        logMigrationSummary();
        Log.close(migrationStatus);
    }

    /**
     * Adds the summary information to the log.
     */
    private void logMigrationSummary()
    {
        MigrationStatus migrationStatus = projectInformation.getMigrationStatus();
        Log.add("<br/><em>Migration summary:<br/>", migrationStatus);
        Log.add("Created: <span style=\"color: green;\">" + migrationStatus.getAssetsCreated() + "</span><br/>", migrationStatus);
        Log.add("Skipped: <span style=\"color: blue;\">" + migrationStatus.getAssetsSkipped() + "</span><br/>", migrationStatus);
        Log.add("Errors: <span style=\"color: red;\">" + migrationStatus.getAssetsWithErrors() + "</span><br/>", migrationStatus);
        Log.add("</em><br/>Migration completed.<br/><br/>", migrationStatus);
    }
}
