package ru.cj.db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class JdbcConnector {

    private static final String CONNECTION_URL =
            "jdbc:mysql://localhost:3306/paydb?useUnicode=yes&amp;characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Connection conn;

    private JdbcConnector(){};

    public static Connection newConnection(){
        JdbcConnector jc = new JdbcConnector();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            jc.conn = DriverManager.getConnection(CONNECTION_URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return jc.conn;
    }

}
