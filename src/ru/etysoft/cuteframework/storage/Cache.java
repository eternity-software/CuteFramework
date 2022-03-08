package ru.etysoft.cuteframework.storage;

import ru.etysoft.cuteframework.storage.tables.UserAccountTable;

import java.sql.*;

public class Cache {

    private static Connection connection;
    private static Statement statement;
    private static UserAccountTable userAccountTable;

    public static void initialize(String cacheDir, String sqliteClassName, String jdbcUrl) throws SQLException, ClassNotFoundException {
        Class.forName(sqliteClassName);
        connection = DriverManager.getConnection(jdbcUrl + cacheDir + "db.sqlite");
        createTables();

    }

    public static UserAccountTable getUserAccount() {
        return userAccountTable;
    }

    private static void createTables() throws SQLException {
        statement = connection.createStatement();
        userAccountTable = new UserAccountTable();
    }

    public static void clean() throws SQLException {
        statement.execute("DROP TABLE " + UserAccountTable.TABLE_NAME);
        createTables();
    }

    public static Statement getStatement() {
        return statement;
    }
}
