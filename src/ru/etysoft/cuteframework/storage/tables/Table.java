package ru.etysoft.cuteframework.storage.tables;

import ru.etysoft.cuteframework.Logger;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.exceptions.OneRowOperationException;
import ru.etysoft.cuteframework.storage.Cache;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Table {

    private String tableName;
    public Table(String tableName)
    {
        this.tableName = tableName;
    }

    public void putValue(String columnName, String value) throws SQLException {
        Logger.logDebug("inserted " + columnName + " with " + value);
        Cache.getStatement().execute("INSERT INTO '"+ tableName +"' ('"+ columnName +"') VALUES ('"+ value +"'); ");
    }

    public void updateValues(String columnName, String value) throws SQLException {
        Logger.logDebug("updated " + columnName + " with " + value);
        Cache.getStatement().execute("UPDATE '"+ tableName +"' SET '"+ columnName +"' = '"+ value +"'");
    }

    public ResultSet getRowByValue(String key, String rowName) throws SQLException {
       return Cache.getStatement().executeQuery("SELECT * FROM '"+ tableName +"' WHERE " + rowName + " = " + key);
    }

    public boolean hasUniqueValue(String key)
    {
        try {
            String value = getUniqueString(key);
            if(value != null)
            {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
           return false;
        }

    }

    public int getRowsCount() throws SQLException {
        ResultSet resultSet = getAllRows();
        int i = 0;
        while (resultSet.next())
        {
            i++;
        }
        resultSet.close();
        return i;
    }

    public String getUniqueString(String key) throws SQLException, OneRowOperationException {
        ResultSet resultSet = getAllRows();
        String value = null;
        int i = 0;
        while(resultSet.next())
        {
            if(i > 0)
            {
                throw new OneRowOperationException();
            }
            value = resultSet.getString(key);
            i++;
        }
        resultSet.close();
        return value;
    }

    public ResultSet getAllRows() throws SQLException {
        return Cache.getStatement().executeQuery("SELECT * FROM '"+ tableName +"'");
    }

}
