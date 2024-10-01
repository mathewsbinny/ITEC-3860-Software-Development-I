package model;

import gameExceptions.GameException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Class : GameDBCreate
 *
 * @author: Rick Price
 * @version: 1.1
 * Course: ITEC 3860
 * Written: September 7, 2022
 * This class creates the Game db if it doesn't exist
 * Purpose: Creates the DB for Mini Game 3
 */
public class GameDBCreate {
	SQLiteDB sdb;

	/**
	 * Method: buildTables
	 * Purpose: Build all tables
	 *
	 * @return void
	 * @throws SQLException
	 */
	public void buildTables() throws GameException {
		buildRoom();
		buildExit();
		buildItem();
		buildItemRoom();
		buildPlayer();
		buildPlayerItem();
	}

	/**
	 * Method: buildRoom
	 * Purpose: Build the Room table and load data
	 *
	 * @return void
	 * @throws SQLException
	 */
	public void buildRoom() throws GameException {
		try {
			sdb = new SQLiteDB();

			FileReader fr;
			try {
				fr = new FileReader("src/mini3/rooms3.txt");
				Scanner inFile = new Scanner(fr);
				while (inFile.hasNextLine()) {
					String sql = inFile.nextLine();
					sdb.updateDB(sql);
				}
				inFile.close();
			} catch (FileNotFoundException e) {
				throw new GameException("rooms3.txt was not found.");
			}

			//Close the SQLiteDB connection since SQLite only allows one updater
		} catch (SQLException | ClassNotFoundException ex) {
			throw new GameException("Error creating table Room");
		}
		finally {
			if (sdb != null) {
				try {
					//Close the SQLiteDB connection since SQLite only allows one updater
					sdb.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	/**
	 * Method: buildItem
	 * Purpose: Build the Item table and load data
	 *
	 * @return void
	 * @throws SQLException
	 */
	public void buildItem() throws GameException {
		FileReader fr;
		try {
			fr = new FileReader("src/mini3/Items3.txt");
			sdb = new SQLiteDB();
			Scanner inFile = new Scanner(fr);
			while (inFile.hasNextLine()) {
				String sql = inFile.nextLine();
				sdb.updateDB(sql);
			}
			inFile.close();
		} catch (SQLException | ClassNotFoundException | FileNotFoundException ex) {
			throw new GameException("Error creating table Item");
		}
		finally {
			if (sdb != null) {
				try {
					//Close the SQLiteDB connection since SQLite only allows one updater
					sdb.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	/**
	 * Method: buildItemRoom
	 * Purpose: Build the ItemRoom table and load data
	 *
	 * @return void
	 * @throws SQLException
	 */
	public void buildItemRoom() throws GameException {
		FileReader fr;
		try {
			fr = new FileReader("src/mini3/ItemRoom3.txt");
			sdb = new SQLiteDB();
			Scanner inFile = new Scanner(fr);
			while (inFile.hasNextLine()) {
				String sql = inFile.nextLine();
				sdb.updateDB(sql);
			}
			inFile.close();
		} catch (SQLException | ClassNotFoundException | FileNotFoundException ex) {
			throw new GameException("Error creating table ItemRoom");
		}
		finally {
			if (sdb != null) {
				try {
					//Close the SQLiteDB connection since SQLite only allows one updater
					sdb.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	/**
	 * Method: buildExit
	 * Purpose: Build the Item table and load data
	 *
	 * @return void
	 * @throws SQLException
	 */
	public void buildExit() throws GameException {
		FileReader fr;
		try {
			fr = new FileReader("src/mini3/Exit3.txt");
			sdb = new SQLiteDB();
			Scanner inFile = new Scanner(fr);
			while (inFile.hasNextLine()) {
				String sql = inFile.nextLine();
				sdb.updateDB(sql);
			}
			inFile.close();
		} catch (SQLException | ClassNotFoundException | FileNotFoundException ex) {
			throw new GameException("Error creating table Exit");
		}
		finally {
			if (sdb != null) {
				try {
					//Close the SQLiteDB connection since SQLite only allows one updater
					sdb.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	/**
	 * Method: buildPlayer
	 * Purpose: Builds the Player table and loads a phantom record
	 * @return void
	 * @throws GameException
	 */
	public void buildPlayer() throws GameException {
		try {
			sdb = new SQLiteDB();
			String sql = "CREATE TABLE Player(playerID int not Null, playerName text not null, currentRoom int not null)";
			sdb.updateDB(sql);
			sql = "INSERT INTO Player(playerID, playerName, currentRoom) Values(1, 'Fred', 1)";
			sdb.updateDB(sql);

		} catch (SQLException | ClassNotFoundException ex) {
			throw new GameException("Error creating table Player");
		}
		finally {
			if (sdb != null) {
				try {
					//Close the SQLiteDB connection since SQLite only allows one updater
					sdb.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	/**
	 * Method: buildPlayerItem
	 * Purpose: Build the PlayerItem table. No data loaded since the player starts with no items
	 * @return void
	 * @throws SQLException
	 */
	public void buildPlayerItem() throws GameException {
		try {
			sdb = new SQLiteDB();
			String sql = "CREATE TABLE PlayerItem(playerId int, itemID int)";
			sdb.updateDB(sql);
		} catch (SQLException | ClassNotFoundException ex) {
			throw new GameException("Error creating table PlayerItem");
		}
		finally {
			if (sdb != null) {
				try {
					//Close the SQLiteDB connection since SQLite only allows one updater
					sdb.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}
