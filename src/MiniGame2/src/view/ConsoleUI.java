package view;

import controller.Direction;
import controller.GameController;
import controller.GameException;
import controller.Room;
import controller.Exit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * class: ConsoleUI
 * @author:
 * @version: 1.0
 * course: ITEC 3860
 * written:
 * purpose:
 */
public class ConsoleUI {
    private GameController gc;
    //private int currentRoomID=1;

    /**
     * Method: startGame
     * Purpose: starts the game loop.
     */
    public void startGame() throws GameException {
        gc = new GameController();
        Scanner input = new Scanner(System.in);
        int roomID = 1;
            //gc.getRoomData(roomID);
        Room firstRoom = gc.getRoom(roomID);
        List<Exit> exits = gc.getExits(roomID);
        firstRoom.setExits(exits);
        Room currentRoom = firstRoom;

        while(true){
            printDetailsForTheRoom(currentRoom);
            currentRoom.setRoomVisited(true);
            // and take user input for next step
            Direction direction = getAndValidateUserDirections(currentRoom);
            //find the next room to visit based on user direction
            if(direction != null) {
                currentRoom = visitNextRoomByUserDirection(currentRoom,direction);
            }
        }

        /**
         * Press 1 to print all rooms
         * Press 2 to start game at room 1
         * Track current roomID variable from Room class
         *
         * After room 1, while loop unless player types option to exit game
         *      prompt user to enter direction
         *      validate user's direction by comparing with db query
         */

    }
    /**
     * Method: getRoomID
     * Purpose: Retrieve the roomID from Room class
     *
     * @param: void
     * @return: int
     */
    public int getRoomID() throws GameException {
        Room rID = new Room();
        return rID.getRoomID();
    }

    /**
     * Method: getFirstRoomData
     * Purpose: Retrieve the room from the database and return it as a String
     *
     * @param: void
     * @return: String
     *
    private Room getFirstRoomData(int currentRoomID) throws GameException {
        gc.updateRoom();
        return gc.getRoomData(currentRoomID);
    }
    */
    private Direction getAndValidateUserDirections(Room currentRoom) {
        String inputDirection = getUserDirectionInputFromConsole();
        System.out.println(inputDirection);
        Direction direction = Direction.getDirectionEnumByCodeOrValue(inputDirection);
        List<Direction> possibleDirections = getDirectionsForAllPossibleExits(currentRoom.getExits());
        validateUserInputForDirection(inputDirection, possibleDirections);
        return direction;
    }
    private Room visitNextRoomByUserDirection(Room currentRoom, Direction direction) throws GameException {
        Room nextRoom = currentRoom;
        Exit nextExit = null;
        List <Exit> possibleExits = currentRoom.getExits();
        for(Exit exit:possibleExits){
            if(exit.getDirection().equals(direction)){
                nextExit = exit;
            }
        }
        if(nextExit!=null){
            nextRoom = gc.getRoom(nextExit.getDestination());
            nextRoom.setExits(gc.getExits(currentRoom.getRoomID()));
        }
        return nextRoom;
    }
    private Room getRoomByRoomNumber(List<Room> allRoomData, Integer roomNumber) {
        for(Room room:allRoomData){
            if(room.getRoomID()==roomNumber){
                return room;
            }
        }
        return null;
    }
    private void validateUserInputForDirection(String direction, List<Direction> possibleDirections) {
        Direction userInputDirection = Direction.getDirectionEnumByCodeOrValue(direction);
        boolean validDirection = possibleDirections.contains(userInputDirection);
        if(!validDirection){
            System.out.println("This room doesn't have an exit in this direction");
        }
    }
    private String getUserDirectionInputFromConsole() {
        System.out.println("Which direction do you want to take ?");
        Scanner scanner = new Scanner(System.in);
        String direction = scanner.nextLine();
        return direction;
    }
    private void printDetailsForTheRoom(Room room) throws GameException {
        System.out.println("You are in "+room.getRoomName());
        System.out.println(room.getRoomDescription());
        if(room.isRoomVisited()){
            System.out.println("You have been here before");
        }
        List<Exit> exits = room.getExits();
        List<Direction> possibleDirections = getDirectionsForAllPossibleExits(exits);
        System.out.println("You can navigate to following directions : "+possibleDirections);
    }
    private List<Direction> getDirectionsForAllPossibleExits(List<Exit> exits) {
        List<Direction> directions = new ArrayList<>();
        for(Exit exit:exits){
            directions.add(exit.getDirection());
        }
        return directions;
    }

    private Room getFirstRoomFromRoomData(List<Room> roomList) {
        for(Room room:roomList){
            if(room.getRoomID()==1){
                return room;
            }
        }
        return null;
    }
}
