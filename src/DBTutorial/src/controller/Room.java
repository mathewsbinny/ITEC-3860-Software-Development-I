package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.RoomDB;

/**
 * Class : Room.java
 * @author: Rick Price
 * @version: 1.3
 * Course: ITEC 3860
 * Written: August 27, 2023
 * This class is the business logic for the Room objects
 */
public class Room {
    private int roomID;
    private String roomName;
    private String roomDescription;
    private String exits;

    /**
     * Constructor: Room
     */
    public Room() throws GameException {
        RoomDB rdb = new RoomDB();
        roomID = rdb.getNextRoomID();
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

    /**
     * Method: getAllRoom
     * Purpose: Retrieves all rooms
     * @return ArrayList<Room>
     * @throws GameException
     */
    public ArrayList<Room> getAllRooms() throws GameException {
        RoomDB rdb = new RoomDB();
        return rdb.getAllRooms();
    }

    /**
     * Method: getRoomID
     * @return the roomID
     */
    public int getRoomID() {
        return roomID;
    }

    /**
     * Method: setRoomID
     * @param roomID the roomID to set
     */
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    /**
     * Method: getRoomName
     * @return the roomName
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * Method: setRoomName
     * @param roomName the roomName to set
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    /**
     * Method: getRoomDescription
     * @return the roomDescription
     */
    public String getRoomDescription() {
        return roomDescription;
    }

    /**
     * Method: setRoomDescription
     * @param roomDescription the roomDescription to set
     */
    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    /**
     * Method: getExits
     * @return the exits
     */
    public String getExits() {
        return exits;
    }

    /**
     * Method: setExits
     * @param exits the exits to set
     */
    public void setExits(String exits) {
        this.exits = exits;
    }

    /**
     * Method: updateRoom
     * This method uses the RoomDB in model to update the room
     */
    public void updateRoom() throws GameException {
        RoomDB rdb = new RoomDB();
        rdb.updateRoom(this);
    }

    /**
     * Method: toString
     * @return
     */
    @Override
    public String toString() {
        return "Room roomID = " + roomID + "\nroomName = " + roomName + "\nroomDescription = " + roomDescription + "\nexits = "
                + exits;
    }

}
