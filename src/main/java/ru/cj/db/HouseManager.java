package ru.cj.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by df on 30.06.2015.
 */
public class HouseManager {

    private Connection conn;
    private final static String SELECT_ALL_HOUSES = "SELECT * FROM houses";
    private final static String INSERT_HOUSE = "INSERT INTO houses VALUES(?,?)";

    public HouseManager(){
        conn = JdbcConnector.newConnection();
    }

    public ResultSet getAllHouses(){
        try {
            return conn.createStatement().executeQuery(SELECT_ALL_HOUSES);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public void insertHouse(String adress, String countFloors){
        try {
            PreparedStatement pstm = conn.prepareStatement(INSERT_HOUSE);
            pstm.setString(1,adress);
            pstm.setString(2, countFloors);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        if(conn != null)
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
}
