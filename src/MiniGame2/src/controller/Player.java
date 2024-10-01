package controller;

/**
 * class: Player.java
 * author: Mathews Binny
 * version: 1.0
 * course: ITEC 3860
 * written: 11 March 2024
 * purpose: Contains logic for Player objects
 * WARNING: CURRENTLY UNUSED.
 */

public class Player {
    private int playerID;
    private String playerName;
    private Room currentRoom;

    /**
     * Method: getPlayerID
     * @return Retrieve the playerID
     */
    public int getPlayerID() {
        return playerID;
    }
    /**
     * Method: setPlayerID
     * @param playerID to set
     */
    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }
    /**
     * Method: getPlayerName
     * @return Retrieve the playerName
     */
    public String getPlayerName() {
        return playerName;
    }
    /**
     * Method: setPlayerName
     * @param playerName to set
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    /**
     * Method: getCurrentRoom
     * @return Retrieve currentRoom
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }
    /**
     * Method: setCurrentRoom
     * @param currentRoom to set
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * Method: toString
     * @return String
     */
    @Override
    public String toString() {
        return  "Player{" +
                "playerID=" + playerID +
                ", playerName='" + playerName + '\'' +
                ", currentRoom=" + currentRoom +
                "}";
    }
}
