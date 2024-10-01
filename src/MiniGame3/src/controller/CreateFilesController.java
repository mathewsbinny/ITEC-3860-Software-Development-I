package controller;

import gameExceptions.GameException;
import model.GameDBCreate;

/**
 * class: CreateFilesController.java
 * author: Mathews Binny
 * @version: 1.0
 * course: ITEC 3860
 * written: 11 March 2024
 * purpose: This class calls into the model to build a database if it does not already exist
 */
public class CreateFilesController {

    /**
     * Method: createFile
     * Purpose: Create the database for MiniGame2
     * @return void
     */
    public void createFile() throws GameException {
        GameDBCreate sdb = new GameDBCreate();
        sdb.buildTables();
    }

    /**
     * Method: createFile
     * Purpose: Create the database for MiniGame2
     * @return void
     */
    public void createFile(String dbName) throws GameException {
        GameDBCreate sdb = new GameDBCreate();
        sdb.buildTables();
    }
}
