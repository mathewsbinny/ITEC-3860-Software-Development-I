package controller;

import java.awt.*;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

import model.SQLiteDB;

/**
 * Class : GameController.java
 * @author: Rick Price
 * @version: 1.5
 * Course: ITEC 3860
 * Written: August 27, 2023
 * This class is the main controller for the DB Demo program.
 * Will hold utility functions as well as central functionality
 */
public class GameController {

    public void start() throws GameException {
        File dbFile = new File("Game.db");
        if (!dbFile.exists()) {
            CreateFilesController cfc = new CreateFilesController();
            cfc.createFile("Game.db");
        }
     }

    /**
     * Method: getRoomData
     * Purpose: gets room data and returns a String containing it
     * @return String
     * @throws GameException
     */
    public String getRoomData(int roomNumber) throws GameException {
        Room rm = new Room();
        rm = rm.getRoom(roomNumber);
        return rm.toString();
    }

    /**
     * Method: getAllRoomsData
     * Purpose: Gets all rooms and returns an ArrayList<String> of all of the rooms
     * @return ArrayList<String>
     * @throws GameException
     */
    public ArrayList<String> getAllRoomsData() throws GameException {
        ArrayList<Room> rooms = null;
        Room rm = new Room();
        rooms = rm.getAllRooms();
        ArrayList<String> roomStrs = new ArrayList<>();
        for (Room room : rooms) {
            roomStrs.add(room.toString());
        }
        return roomStrs;
    }

    /**
     * Method: getMonsterData
     * Purpose: gets Monster data and returns a String containing it
     * @return String
     * @throws GameException
     */
    public String getMonsterData(int monsterNumber) throws GameException {
        Monster mon = new Monster();
        mon = mon.getMonster(monsterNumber);
        return mon.toString();
    }

    /**
     * Method: getAllMonstersData
     * Purpose: Get all of the monster data from the DB
     * @return ArrayList<String>
     * @throws GameException
     */
    public ArrayList<String> getAllMonstersData() throws GameException {
        Monster mon = new Monster();
        ArrayList<Monster> monsters = null;
        monsters = mon.getAllMonsters();
        ArrayList<String> monstersStr = new ArrayList<String>();
        for (Monster monster : monsters) {
            monstersStr.add(monster.toString());
        }
        return monstersStr;
    }

    /**
     * Method: getMonsterRoomData
     * Purpose: Gets the monster and room for the specified room and displays list of monsters in specified rooms
     * @return void
     *
     * @throws GameException
     */
    public String getMonsterRoomData(int monsterRoomNumber) throws GameException {
        MonsterRoom mr = new MonsterRoom();
        ArrayList<MonsterRoom> mrs = mr.getMonster(monsterRoomNumber);
        String mrStr = "";
        for (MonsterRoom monRoom : mrs) {
            mrStr += monRoom.toString();
            mrStr += "\n";
        }
        return mrStr;
    }

    /**
     * Method: getAllMonsterRoomData
     * Purpose: Get all of the monster and room data.  Joins these two tables.
     * @return ArrayList<String>
     * @throws SQLException
     */
    public ArrayList<String> getAllMonsterRoomData() throws GameException {
        MonsterRoom mr = new MonsterRoom();
        ArrayList<MonsterRoom> monsterRooms = null;
        monsterRooms = mr.getAllMonsters();
        ArrayList<String> mrStrs = new ArrayList<String>();
        for (MonsterRoom monsterRoom : monsterRooms) {
            mrStrs.add(monsterRoom.toString());
        }
        return mrStrs;
    }

    /**
     * Method: updateRoom
     * This method calls updateRoom in the room class to allow the user to see an update
     */
    public void updateRoom() throws GameException {
        Room room = new Room();
        room = room.getRoom(2);
        room.setExits("north");
        room.updateRoom();
    }
}
