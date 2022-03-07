package ru.etysoft.cuteframework.sqlite;

import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.sqlite.tables.ProfileData;

import java.sql.*;

public class SQLite {



    private static Connection connection;
    private static Statement statement;
    private static ProfileData profileData;

    public static void initialize(String cacheDir, String sqliteClassName, String jdbcUrl) throws SQLException, ClassNotFoundException {
        Class.forName(sqliteClassName);
        connection = DriverManager.getConnection(jdbcUrl + cacheDir + "db.sqlite");
        createTables();
        profileData = new ProfileData();
    }

    public static ProfileData getProfileData() {
        return profileData;
    }

    private static void createTables() throws SQLException {
        statement = connection.createStatement();
    }

    public static Statement getStatement() {
        return statement;
    }
}
