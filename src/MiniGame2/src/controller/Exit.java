package controller;

/**
 * class: Exit.java
 * @author: Mathews Binny
 * @version: 1.0
 * course: ITEC 3860
 * written: 11 March 2024
 * purpose: Contains the logic for the Exit objects
 */
public class Exit {
    private int exitID;
    private int roomID;
    private Direction direction;
    private int destination;

    /**
     * Method: getExitID
     * @return Retrieves exitID
     */
    public int getExitID() {
        return exitID;
    }
    /**
     * Method: setExitID
     * @return the exitID to set
     */
    public void setExitID(int exitID) {
        this.exitID = exitID;
    }
    /**
     * Method: getRoomID
     * @return Retrieves RoomID
     */
    public int getRoomID() {
        return roomID;
    }
    /**
     * Method: setRoomID
     * @return the roomID to set
     */
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }
    /**
     * Method: getDestination
     * @return Retrieves destination
     */
    public int getDestination() {
        return destination;
    }
    /**
     * Method: setDestination
     * @return the destination to set
     */
    public void setDestination(int destination) {
        this.destination = destination;
    }

    /**
     * Method: getDirection
     * @return Retrieves direction
     */
    public Direction getDirection() {
        return direction;
    }
    /**
     * Method: setDirection
     * @return the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
            public Exit getExitsFromString(String) {

            }
    */

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        return "Exit{" +
                "exitID=" + exitID +
                ", roomID=" + roomID +
                ", direction='" + direction + '\'' +
                ", destination=" + destination +
                '}';
    }
}
