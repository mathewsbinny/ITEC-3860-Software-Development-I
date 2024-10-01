package controller;
import model.RoomDB;
import java.util.List;

/**
 * Class: Room.java
 * @author: Mathews Binny
 * @version: 1.0
 * course: ITEC 3860
 * written: 11 March 2024
 * purpose: This class contains the logic for the Room objects
 */
public class Room {
    private int roomID;
    private String roomName;
    private String roomDescription;
    private boolean roomVisited;
    private List <Exit> exits;

    /**
     * Method: getRoomID
     * @return: Retrieves Room ID
     */
    public int getRoomID() {
        return roomID;
    }
    /**
     * Method: setRoomID
     * @param: roomID the roomID to set
     */
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }
    /**
     * Method: getRoomName
     * @return: Retrieves Room Name
     */
    public String getRoomName() {
        return roomName;
    }
    /**
     * Method: setRoomName
     * @param: roomName the roomName to set
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    /**
     * Method: getRoomDescription
     * @return: Retrieves Room Description
     */
    public String getRoomDescription() {
        return roomDescription;
    }
    /**
     * Method: setRoomDescription
     * @param: roomDescription the roomDescription to set
     */
    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }
    /**
     * Method: getExits
     * @return: Retrieves the list of Exits
     */
    public List <Exit> getExits() {
        return exits;
    }
    /**
     * Method: setExits
     * @param exits the exits to set
     */
    public void setExits(List <Exit> exits) {
        this.exits = exits;
    }
    public boolean isRoomVisited() {
        return roomVisited;
    }
    public void setRoomVisited(boolean roomVisited) {
        this.roomVisited = roomVisited;
    }
    //------------------------------------------------------------------------//
    /**
     * Method: updateRoom
     * This method uses the RoomDB in model to update the room
     */
    public void updateRoom() throws GameException {
        RoomDB rdb = new RoomDB();
        rdb.updateRoom(this);
    }
    //------------------------------------------------------------------------//


    /**
     * Method: toString
     * @return String
     */
    @Override
    public String toString() {
         return "Room{" +
                "roomNumber=" + roomID +
                ", name='" + roomName + '\'' +
                ", description='" + roomDescription + '\'' +
                ", visited=" + roomVisited +
                '}';
    }
}
