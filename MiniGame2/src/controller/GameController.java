package controller;

import model.RoomDB;

import java.io.File;
import java.util.List;

/**
 * class: GameController.java
 * author: Mathews Binny
 * version: 1.0
 * course: ITEC 3860
 * written: 11 March 2024
 * purpose: idk a lot of stuff happens here
 */
public class GameController {
    public void start()  throws GameException {
        File dbFile = new File("Mini2.db");
        if (!dbFile.exists()) {
            CreateFilesController cfc = new CreateFilesController();
            cfc.createFile("Mini2.db");
        }
    }
    /**
     * Method: getRoom
     * Purpose: Retrieves a room based upon the supplied ID
     * @param id
     * @return Room
     * @throws GameException
     */
    public Room getRoom(int id) throws GameException {
        RoomDB rdb = new RoomDB();
        return rdb.getRoom(id);
    }

    public List<Exit> getExits(int id) throws GameException {
        RoomDB rdb = new RoomDB();
        return rdb.getExits(id);
    }

    /**
     * Method: updateRoom
     * This method calls updateRoom in the room class to allow the user to see an update
     *
    public void updateRoom(int currentRoomNum) throws GameException {
        Room room = new Room();
        room = room.getRoom(currentRoomNum);
        //change to get current room, this is fixed!
        room.setExits("north");
        //change to query exits from db, this is wrong!
        room.updateRoom();
    }
     */
}
