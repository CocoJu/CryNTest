package ru.cj.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseManager extends DbManager{

    private final static String SELECT_ALL_HOUSES = "SELECT * FROM houses";
    private final static String INSERT_HOUSE = "INSERT INTO houses(adress, count_floors) VALUES(?,?)";
    private final static String DELETE_HOUSE = "DELETE FROM houses WHERE id_house = ?";

    public HouseManager(){
        super();
    }

    public void deleteHouse(int id){
        try {
            PreparedStatement pstm = conn.prepareStatement(DELETE_HOUSE);
            pstm.setInt(1, id);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getAllHouses(){
        try {
            return conn.createStatement().executeQuery(SELECT_ALL_HOUSES);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public void insertHouse(String adress, int countFloors){
        try {
            PreparedStatement pstm = conn.prepareStatement(INSERT_HOUSE);
            pstm.setString(1, adress);
            pstm.setInt(2, countFloors);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
