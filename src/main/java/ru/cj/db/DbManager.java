package ru.cj.db;

import ru.cj.db.jdbc.JdbcConnector;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by df on 02.07.2015.
 */
class DbManager {

    protected Connection conn;

    public DbManager(){}

    public void openConnection(){
        if(this.conn==null)
            this.conn = JdbcConnector.newConnection();
    };

    public void closeConnection(){
        if(conn != null)
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
