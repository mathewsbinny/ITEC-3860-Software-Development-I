package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.GameController;
import controller.GameException;

/**
 * Class : ConsoleUI.java
 * @author: Rick Price
 * @version: 1.4
 * Course: ITEC 3860
 * Written: August 27, 2023
 * This class is the view component for the Console
 */
public class ConsoleUI {
    private GameController gc;
    private final int LAST_CHOICE = 8;

    /**
     * Method: startGame
     * Purpose: handles the demo
     * @return void
     */
    public void startGame() {
        gc = new GameController();
        boolean again = true;
        Scanner input = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("Select the option you would like to execute");
            System.out.println("1. Get all rooms");
            System.out.println("2. Get a specific room");
            System.out.println("3. Show all Monster data");
            System.out.println("4. Show a specific monster");
            System.out.println("5. Show the monster in a specific room");
            System.out.println("6. Show the rooms where monsters are programmed.");
            System.out.println("7. Update a room");
            System.out.println(LAST_CHOICE + ". Exit the game");
            try {
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        printStrs(getAllRooms());
                        break;
                    case 2:
                        try {
                            System.out.println("What room would you like to retrieve?");
                            int room = input.nextInt();
                            System.out.println(getRoom(room));
                        }
                        catch (InputMismatchException ime) {
                            System.out.println("You must enter an integer for Room Number");
                        }
                        catch (GameException ge) {
                            System.out.println(ge.getMessage());
                        }
                        break;
					case 3:
						printStrs(getAllMonsters());
						break;
					case 4:
						try {
							System.out.println("What monster would you like to retrieve?");
							int monster = input.nextInt();
							System.out.println(getMonster(monster));
						}
						catch (GameException ge) {
							System.out.println(ge.getMessage());
						}
						break;
                    case 5:
                        try {
                            System.out.println("What room would you like to see the monster?");
                            int room = input.nextInt();
                            System.out.println(getMonsterInRoom(room));
                        }
                        catch (InputMismatchException ime) {
                            System.out.println("You must enter an integer for Room Number");
                        }
                        catch (GameException ge) {
                            System.out.println(ge.getMessage());
                        }
                        break;
					case 6:
						printStrs(getMonsterRoom());
						break;
                    case 7:
                        try {
                            System.out.println("Current room 2");
                            System.out.println(getRoom(2));
                            gc.updateRoom();
                        }
                        catch (GameException ge) {
                            System.err.println(ge.getMessage());
                        }
                        break;

                    case LAST_CHOICE:
						again = false;
                }
            }
            catch (NumberFormatException nfe) {
                System.out.println("You must enter an integer for your choice");
            }
            catch (GameException e) {
                System.out.println("An error occurred while reading data. " + e.getMessage());
                System.out.println("Exiting the program.");
                again = false;
            }
            finally {
                input.nextLine();
            }

        } while (again);

        input.close();
    }

    /**
     * Method: getAllRooms
     * Purpose: Retreieve all rooms from the database and return them as a List<String>
     * @param: None
     * @return: ArrayList<String>
     */
    private ArrayList<String> getAllRooms() throws GameException {
        return gc.getAllRoomsData();
    }

    /**
     * Method: getRoom
     * Purpose: Retreieve the room from the database and return it as a String
     * @param: room
     * @return: String
     */
    private String getRoom(int room) throws GameException {
        return gc.getRoomData(room);
    }

	/**
	 * Method: getAllMonsters
	 * Purpose: Retreieve all monsters from the database and return them as a List<String>
	 * @param: None
	 * @return: ArrayList<String>
	 */
	private ArrayList<String> getAllMonsters() throws GameException {
		return gc.getAllMonstersData();
	}

	/**
	 * Method: getMonster
	 * Purpose: Retreieve the monster from the database and return it as a String
	 * @param: monster
	 * @return: String
	 */
	private String getMonster(int monster) throws GameException {
		return gc.getMonsterData(monster);
	}

    /**
     * Method: getMonsterInRoom
     * Purpose : Retrieve the monster in a specific room
     * @param  roomNum
     * @return String
     */
    private String getMonsterInRoom(int roomNum) throws GameException{
        String monStr = "";
        try {
            monStr = gc.getMonsterRoomData(roomNum);
        } catch (GameException e ) {
            System.out.println(e.getMessage());
        }


        return monStr;
    }

	/**
	 * Method: getMonsterRooms
	 * Purpose: Retreieve all monsters and their associated rooms from the database and return them as a List<String>
	 * @param: None
	 * @return: ArrayList<String>
	 */
	private ArrayList<String> getMonsterRoom(){
		ArrayList<String> monRoom = new ArrayList<>();
		try {
			monRoom = gc.getAllMonsterRoomData();
		}
		catch (GameException e) {
            System.out.println(e.getMessage());
		}
		return monRoom;
	}

    /**
     * Method: printStrs
     * Purpose: Print the ArrayList of Strings
     * @param strs void
	 * @return void
     */
    private void printStrs(ArrayList<String> strs) {
        for (String str : strs) {
            System.out.println(str);
        }
    }

}
