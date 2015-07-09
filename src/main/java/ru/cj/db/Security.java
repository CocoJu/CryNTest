package ru.cj.db;

import ru.cj.db.jdbc.JdbcConnector;

import java.sql.*;



public class Security {

    public static final int NO_AUTHORY = 0;
    public static final int USER_ROLE = 1;
    public static final int ADMIN_ROLE = 2;


    public static int getUserRole(String login, String passwd){
        try {
            Connection conn = JdbcConnector.newConnection();
            PreparedStatement pstm = conn.prepareStatement(
                    "SELECT user_name, passwd, role " +
                    "FROM users " +
                    "WHERE user_name = ? and passwd = ?");
            pstm.setString(1, login);
            pstm.setString(2, passwd);
            ResultSet rs = pstm.executeQuery();
            rs.next();
            int userRole = rs.getInt("role");
            conn.close();
            return userRole;
        } catch (SQLException e) {
            e.printStackTrace();
            return NO_AUTHORY;
        }

    };
}
