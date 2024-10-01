package controller;

import gameExceptions.*;

import java.io.File;

/**
 * Class: GameController
 * @author Rick Price
 * @version 1.3
 * Course: ITEC 3860
 * Written: Sep 12, 2023
 * This class – Is the UI to controller interface for mini game 3
 * All user interactions will be sent to this class to be sent on for further processing.
 */
public class GameController {

	public static final int FIRST_ROOM = 1;
	private Commands commands;

	/**
	 * Method GameController
	 * Constructor for the GameController class
	 * Instantiates the Commands object for the game
	 */
	public GameController() {
		// TODO - implement GameController.GameController
		throw new UnsupportedOperationException();
	}

	/**
	 * Method : start
	 * Checks to see if the DB field exists and if not creates it
	 * by calling GameDBCreate buildTables().
	 */
	public void start() throws GameException {
		File dbFile = new File("Mini3.db");
		if (!dbFile.exists()) {
			CreateFilesController cfc = new CreateFilesController();
			cfc.CreateFile("Mini3.db");
		}
	}

	/**
	 * Method displayFirstRoom
	 * Retrieves the String for the current room. If the player does not have a room stored, returns the first room
	 * @return - the first room display String
	 * @throws GameException - if the first room is not found.
	 */
	public String displayFirstRoom() throws GameException {
		RoomDB rdb = new RoomDB();
		return rdb.GetRoom(id);
	}

	public Room getRoom(int id) throws GameException {
		RoomDB rdb = new RoomDB();
		return rdb.GetRoom(id);
	}

	/**
	 * Method executeCommand
	 * Handles the user input from Adventure
	 * Sends the user's command to Commands for processing
	 * throws an exception if the command is not valid
	 * @param cmd - String
	 * @return String - the result from the command
	 * @throws GameException if the command is invalid
	 */
	public String executeCommand(String cmd) throws GameException {
		// TODO - implement GameController.executeCommand
		throw new UnsupportedOperationException();
	}

	/**
	 * Method printMap
	 * Handles the print map command from Adventure
	 * Builds a  String representation of the current map
	 * @return String - the String of the current map
	 * @throws GameException if one of the files is not found or has an error
	 */
	public String printMap() throws GameException {
		// TODO - implement GameController.printMap
		throw new UnsupportedOperationException();
	}

	/**
	 * Method: getPlayerName
	 * Requests the Player name from the Commands class
	 * @return String - player name
	 */
	public String getPlayerName() {
		// TODO - implement GameController.getPlayerName
		throw new UnsupportedOperationException();
	}

}