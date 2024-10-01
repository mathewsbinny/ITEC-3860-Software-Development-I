import model.Direction;
import model.Exit;
import model.Room;
import util.FileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MiniGame {


    public void runGame() {
        FileReader reader = new FileReader();
        List<Room> roomData = reader.readRoomDataFromFile();
        //Assuming that room number 1 is the starting point
        Room firstRoom = getFirstRoomFromRoomData(roomData);
        Room currentRoom = firstRoom;
        while(true){
            printDetailsForTheRoom(currentRoom);
            currentRoom.setVisited(true);
            // and take user input for next step
            Direction direction = getAndValidateUserDirections(currentRoom);
            //find the next room to visit based on user direction
            currentRoom = visitNextRoomByUserDirection(currentRoom,direction,roomData);
        }

    }

    private Direction getAndValidateUserDirections(Room currentRoom) {
        String inputDirection = getUserDirectionInputFromConsole();
        System.out.println(inputDirection);
        Direction direction = Direction.getDirectionEnumByCodeOrValue(inputDirection);
        List<Direction> possibleDirections = getDirectionsForAllPossibleExits(currentRoom.getExits());
        validateUserInputForDirection(inputDirection, possibleDirections);
        return direction;
    }

    private Room visitNextRoomByUserDirection(Room currentRoom, Direction direction, List<Room> allRoomData){
        Room nextRoom = null;
        Exit nextExit = null;
        List<Exit> possibleExits = currentRoom.getExits();
        for(Exit exit:possibleExits){
            if(exit.getDirection().equals(direction)){
                nextExit = exit;
            }
        }
        if(nextExit!=null){
            nextRoom = getRoomByRoomNumber(allRoomData, nextExit.getRoomId());
        }
        return nextRoom;
    }

    private Room getRoomByRoomNumber(List<Room> allRoomData, Integer roomNumber) {
        for(Room room:allRoomData){
            if(room.getRoomNumber()==roomNumber){
                return room;
            }
        }
        return null;
    }

    private void validateUserInputForDirection(String direction, List<Direction> possibleDirections) {
        Direction userInputDirection = Direction.getDirectionEnumByCodeOrValue(direction);
        boolean validDirection = possibleDirections.contains(userInputDirection);
        if(!validDirection){
            throw new RuntimeException("This room doesn't have an exit in this direction");
        }
    }

    private String getUserDirectionInputFromConsole() {
        System.out.println("Which direction do you want to take ?");
        Scanner scanner = new Scanner(System.in);
        String direction = scanner.nextLine();
        return direction;
    }

    /**
     * show room name, description, directions and if room is already visited
     * @param room
     */
    private void printDetailsForTheRoom(Room room) {
        System.out.println("You are in "+room.getName());
        System.out.println(room.getDescription());
        if(room.isVisited()){
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
            if(room.getRoomNumber()==1){
                return room;
            }
        }
        return null;
    }
}
