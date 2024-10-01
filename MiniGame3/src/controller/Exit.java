package controller;

import gameExceptions.*;

import java.util.Arrays;

/**
 * Class: Exit
 * @author Rick Price
 * @version 1.3
 * Course: ITEC 3860
 * Written: September 15, 2023
 * 
 * This class – contains the Exit information. Allows the user to build an exit to be added to the Room
 */
public class Exit {

	private String direction;
	private int roomID;
	private int destination;
	private final java.util.List<String> VALID_DIRECTIONS = Arrays.asList(new String[] {"WEST", "NORTH", "SOUTH", "EAST", "UP", "DOWN"});

	public String getDirection() {
		return this.direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getRoomID() {
		return this.roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public int getDestination() {
		return this.destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		// TODO - implement Exit.toString
		throw new UnsupportedOperationException();
	}

}