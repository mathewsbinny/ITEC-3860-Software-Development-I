package util;

import model.Direction;
import model.Exit;
import model.Room;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileReader {

    private String fileName = "resources/rooms.txt";

    public List<Room> readRoomDataFromFile(){
        // List of Room objects
        List<Room> rooms = new ArrayList<Room>();
        try {
            String filePath = Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)).getPath();
            InputStream in = new FileInputStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            // Read file line by line
            String line = "";
            while ((line = br.readLine()) != null) {
                // Parse line to extract individual fields
                String[] data = parseLine(line);
                if(data.length==4){
                    // Create new Room object
                    Room room = new Room();
                    room.setRoomNumber(Integer.valueOf(sanitizeInput(data[0])));
                    room.setName(sanitizeInput(data[1]));
                    room.setDescription(sanitizeInput(data[2]));
                    String exists = sanitizeInput(data[3]);
                    List<Exit> exits = getExitsFromString(exists);
                    room.setExits(exits);
                    // Add object to list
                    rooms.add(room);
                }
            }
        }catch(Exception ex){
            System.out.println("Exception occurred while reading from file : "+ex);
        }
        return rooms;
    }
    // sanitize the input from the room data file to remove extra blank spaces used for formatting
    private String sanitizeInput(String s){
        return s.trim();
    }

    private String[] parseLine(String line) {
        return line.split("\\|");
    }

    private List<Exit> getExitsFromString(String exits) {
        List<Exit> exitsList = new ArrayList<>();
        String [] exitsArray = exits.split(",");
        for(String exit:exitsArray){
            String[] exitRoomInfo =exit.split("=");//NORTH=2 gives ["NORTH","2"]
            if(exitRoomInfo!=null && exitRoomInfo.length==2){
                Direction direction = Direction.getDirectionEnumFromDirectionStringValue(exitRoomInfo[0]);
                Exit exit1 = new Exit(direction,Integer.parseInt(sanitizeInput(exitRoomInfo[1])));
                exitsList.add(exit1);
            }
        }
        return exitsList;
    }
}
