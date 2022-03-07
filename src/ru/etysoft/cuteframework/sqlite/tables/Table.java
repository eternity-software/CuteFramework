package ru.etysoft.cuteframework.sqlite.tables;

import ru.etysoft.cuteframework.sqlite.SQLite;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Table {

    private String tableName;
    public Table(String tableName)
    {
        this.tableName = tableName;
    }

    public void putValue(String columnName, String value) throws SQLException {
        SQLite.getStatement().execute("INSERT INTO '"+ tableName +"' ('"+ columnName +"') VALUES ('"+ value +"'); ");
    }

    public void updateValues(String columnName, String value) throws SQLException {
        SQLite.getStatement().execute("UPDATE '"+ tableName +"' ('"+ columnName +"') VALUES ('"+ value +"'); ");
    }

    public ResultSet getRowByValue(String key, String rowName) throws SQLException {
       return SQLite.getStatement().executeQuery("SELECT * FROM '"+ tableName +"' WHERE " + rowName + " = " + key);
    }

    public ResultSet getAllRows() throws SQLException {
        return SQLite.getStatement().executeQuery("SELECT * FROM '"+ tableName +"'");
    }

}
