package model;

import java.util.List;
/*    The room data file could have the following information:
             A room number, which must be greater than zero
             Its name, which is a one-line string identifying the room
             Its description, which can be a multiline array describing the room
             A flag indicating whether the room has been visited
             A navigation table specifying the exits and where they lead
             Valid directions are NORTH, SOUTH, EAST, WEST, UP, and DOWN.
             Your program should allow the user to use either the full command or just the first letter, case-insensitive.
*/
public class Room {

    private int roomNumber;
    private String name;
    private String description;
    private boolean visited;
    private List<Exit> exits;

    //Getters & Setters
    public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isVisited() {
        return visited;
    }
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    public List<Exit> getExits() {
        return exits;
    }
    public void setExits(List<Exit> exists) {
        this.exits = exists;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", visited=" + visited +
                ", exists=" + exits +
                '}';
    }
}
