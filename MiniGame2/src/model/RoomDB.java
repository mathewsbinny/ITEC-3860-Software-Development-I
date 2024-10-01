package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.*;

/**
 * fill out
 */
public class RoomDB {
    /**
     * Method: getNextRoomID
     * Purpose: gets the next ID for a room
     * @return int
     */
    public int getNextRoomID() throws GameException {
        int next = 0;
        try {
            SQLiteDB sdb = null;
            try {
                sdb = new SQLiteDB();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            next = sdb.getMaxValue("roomID", "room") + 1;
            //Close the SQLiteDB connection since SQLite only allows one updater
            sdb.close();
        }
        catch (SQLException sqe) {
            throw new GameException("Could not get next room id");
        }

        return next;
    }

    /**
     * Method: getRoom
     * Purpose: Gets a room based upon the supplied ID
     * @param id
     * @return Room
     * @throws SQLException
     */
    public Room getRoom(int id) throws GameException {
        Room rm = new Room();
        try {
            SQLiteDB sdb = new SQLiteDB();
            String sql = "Select * from Room WHERE roomID = " + id;
            ResultSet rs = sdb.queryDB(sql);
            if (rs.next()) {
                System.out.println(rs.getInt("roomID"));
                rm.setRoomID(rs.getInt("roomID"));
                rm.setRoomName(rs.getString("roomName"));
                rm.setRoomDescription(rs.getString("roomDescription"));
            } else {
                throw new SQLException("Room " + id + " not found");
            }
            //Close the SQLiteDB connection since SQLite only allows one updater
            sdb.close();
        }
        catch (SQLException | ClassNotFoundException ex) {
            throw new GameException("Room id " + id + "was not found.");
        }
        return rm;
    }

    public List<Exit> getExits(int id) throws GameException {
        List<Exit> exits = new ArrayList<Exit>();

        try {
            SQLiteDB sdb = new SQLiteDB();
            String sql = "Select * from Exit WHERE roomID = " + id;
            ResultSet rs = sdb.queryDB(sql);
            while (rs.next()) {
                Exit exi = new Exit();
                System.out.println(rs.getInt("exitID"));
                exi.setExitID(rs.getInt("exitID"));
                exi.setRoomID(rs.getInt("roomID"));
                exi.setDirection(Direction.getDirectionEnumByCodeOrValue(rs.getString("direction")));
                exi.setDestination(rs.getInt("destination"));
                exits.add(exi);
            }
            //Close the SQLiteDB connection since SQLite only allows one updater
            sdb.close();
        }
        catch (SQLException | ClassNotFoundException ex) {
            throw new GameException("Room id " + id + "was not found.");
        }
        return exits;
    }

    /** Method: updateRoom
     * This method show how to update a SQL table.
     */
    public void updateRoom(Room room) throws GameException {
        String sql = "UPDATE room SET exits = '" + room.getExits() + "' WHERE roomID = " + room.getRoomID() ;
        try {
            SQLiteDB sdb = new SQLiteDB();
            sdb.updateDB(sql);
        }
        catch (SQLException | ClassNotFoundException e) {
            throw new GameException("Update encountered a problem.\n" + e.getMessage());
        }
    }
}
