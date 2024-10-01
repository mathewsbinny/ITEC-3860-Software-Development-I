package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.GameException;
import controller.Monster;

/**
 * Class : MonsterDB.java
 * @author: Rick Price
 * @version: 1.1
 * Course: ITEC 3860
 * Written: June 22, 2021
 * This class handles all database access for the Monster class
 */
public class MonsterDB {
    /**
     * Method: getNextMonsterID
     * Purpose: Gets the id for the next monster.
     * @return int
     */
    public int getNextMonsterID() throws GameException {
        int next = 0;
        try {
            SQLiteDB sdb = null;
            try {
                sdb = new SQLiteDB();
                next = sdb.getMaxValue("monsterNumber", "Monster") + 1;
            } catch (ClassNotFoundException | SQLException e) {
                throw new GameException("Unable to get next Monster ID.");
            }
            //Close the SQLiteDB connection since SQLite only allows one updater
            sdb.close();
        }
        catch (SQLException ex) {
            throw new GameException("Next monster ID not found.");
        }
        return next;
    }

    /**
     * Method: getMonster
     * Purpose: handles db interactions to retrieve a single Monster
     * @param id
     * @return Monster
     * @throws GameException
     */
    public Monster getMonster(int id) throws GameException {
        Monster mon;
        try {
            SQLiteDB sdb = new SQLiteDB();
            mon = new Monster();
            String sql = "Select * from Monster WHERE monsterNumber = " + id;
            ResultSet rs = sdb.queryDB(sql);
            if (rs.next()) {
                mon.setMonsterID(rs.getInt("monsterNumber"));
                mon.setMonsterName(rs.getString("monsterName"));
                mon.setMonsterDescription(rs.getString("monsterDescription"));
                mon.setHitPoints(rs.getInt("hitPoints"));
                mon.setMaxDamage(rs.getInt("maxDamage"));
                mon.setMinDamage(rs.getInt("minDamage"));
            } else {
                throw new SQLException("Monster " + id + " not found.");
            }

            //Close the SQLiteDB connection since SQLite only allows one updater
            sdb.close();
        }
        catch (SQLException | ClassNotFoundException ex) {
            throw new GameException("Monster with monster number " + id + " not found");
        }
        return mon;
    }

    /**
     * Method: getAllMonsters
     * Purpose: Handles the DB interactions to retrieve all monsters
     * @return ArrayList<Monster>
     * @throws GameException
     */
    public ArrayList<Monster> getAllMonsters() throws GameException {
        ArrayList<Monster> monsters = new ArrayList<Monster>();
        try {
            SQLiteDB sdb = new SQLiteDB();
            String sql = "Select * from Monster";

            ResultSet rs = sdb.queryDB(sql);

            while (rs.next()) {
                Monster mon = new Monster();
                mon.setMonsterID(rs.getInt("monsterNumber"));
                mon.setMonsterName(rs.getString("monsterName"));
                mon.setMonsterDescription(rs.getString("monsterDescription"));
                mon.setHitPoints(rs.getInt("hitPoints"));
                mon.setMaxDamage(rs.getInt("maxDamage"));
                mon.setMinDamage(rs.getInt("minDamage"));
                monsters.add(mon);
            }

            //Close the SQLiteDB connection since SQLite only allows one updater
            sdb.close();
        }
        catch (SQLException | ClassNotFoundException ex) {
            throw new GameException("Unable to retrieve all monsters");
        }
        return monsters;
    }
}
