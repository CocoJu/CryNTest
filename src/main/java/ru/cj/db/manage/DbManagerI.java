package ru.cj.db.manage;

import ru.cj.db.dao.House;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by df on 07.07.2015.
 */
public interface DbManagerI {

    public interface HouseManager{};

    public DbManagerI openConnection();

    public void closeConnection() throws SQLException;

}
