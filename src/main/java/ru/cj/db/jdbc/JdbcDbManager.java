package ru.cj.db.jdbc;

import ru.cj.db.HouseManager;
import ru.cj.db.dao.House;
import ru.cj.db.manage.DbManagerI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by df on 07.07.2015.
 */
public class JdbcDbManager implements DbManagerI{

    private final static String SELECT_ALL_HOUSES = "SELECT * FROM houses";
    private final static String INSERT_HOUSE = "INSERT INTO houses(adress, count_floors) VALUES(?,?)";
    private final static String DELETE_HOUSE = "DELETE FROM houses WHERE id_house = ?";

    private Connection connection;

    public JdbcDbManager(){
    }

    static class House implements HouseManagerI{

        public List<House> getAllHouses(){
            return null;
        }

        public void deleteHouse(int id) throws SQLException {
            PreparedStatement pstm = connection.prepareStatement(DELETE_HOUSE);
            pstm.setInt(1, id);
            pstm.execute();
        }

        public void deleteHouse(ru.cj.dao.House house) throws SQLException {
            deleteHouse(house.getId());
        }


        public void insertHouse(String adress, int countFloors) {

        }
    }

    public DbManagerI openConnection() {
        if(connection == null)
            connection = JdbcConnector.newConnection();
        return this;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

}
