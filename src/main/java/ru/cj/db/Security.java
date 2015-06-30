package ru.cj.db;

import java.sql.*;

/**
 * Created by ANK on 30.06.2015.
 */
public class Security {
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
            return 0;
        }

    };
}
