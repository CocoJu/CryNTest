package ru.cj.db.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.cj.db.dao.House;
import ru.cj.db.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by df on 07.07.2015.
 */
public class JdbcDbManager implements DbManager {

    private final static String SELECT_ALL_HOUSES = "SELECT * FROM houses";
    private final static String INSERT_HOUSE = "INSERT INTO houses(adress, count_floors) VALUES(?,?)";
    private final static String DELETE_HOUSE = "DELETE FROM houses WHERE id_house = ?";
    private Connection connection;
    private Logger log = LoggerFactory.getLogger("SYSOUT");

    public JdbcDbManager() {
        log.info("jdb construct! ");
    }

    public List<House> getAllHouses() {
        try {
            openConnection();
            ResultSet resultSetHouses = connection.createStatement().executeQuery(SELECT_ALL_HOUSES);
            List<House> houseList = new ArrayList<House>();
            while(resultSetHouses.next()){
                House house = new House();
                house.setId(resultSetHouses.getInt("id_house"));
                house.setAddress(resultSetHouses.getString("adress"));
                house.setCountFloors(resultSetHouses.getInt("count_floors"));
                houseList.add(house);
                log.info(resultSetHouses.getString("adress"));
            }
        return houseList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            closeConnection();
        }
    }

    public void deleteHouse(int id) {
        openConnection();
        PreparedStatement pstm = null;
        try {
            pstm = connection.prepareStatement(DELETE_HOUSE);
            pstm.setInt(1, id);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }

    }

    public void insertHouse(String address, int countFloors) {
        try {
            openConnection();
            PreparedStatement pstm = connection.prepareStatement(INSERT_HOUSE);
            pstm.setString(1, address);
            pstm.setInt(2, countFloors);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }
    }

    private void openConnection() {
        log.info("open connection!");
        if(connection == null)
            connection = JdbcConnector.newConnection();
    }

    private void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
