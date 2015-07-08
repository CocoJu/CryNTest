package ru.cj.db;

import ru.cj.db.jdbc.JdbcDbManager;

/**
 * Created by ANK on 08.07.2015.
 */
public class DbManagerFactory {

    private DbManagerFactory() {};

    public static DbManager newInstance() {
        return new JdbcDbManager();
    }
}
