package ru.etysoft.cuteframework.sqlite.tables;

import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.sqlite.SQLite;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileData extends Table {

    public static final String TABLE_NAME = "profile";

    public ProfileData() throws SQLException {
        super(TABLE_NAME);
        initialize();
    }

    public String getToken() throws SQLException {
        ResultSet resultSet = getAllRows();
        String token = "";
        while(resultSet.next())
        {
            token = resultSet.getString(APIKeys.Account.TOKEN);
        }
        return token;
    }

    public void setToken(String token) throws SQLException {
        if(!getToken().equals(""))
        {
            updateValues(APIKeys.Account.TOKEN, token);
        }
        else
        {
            putValue(APIKeys.Account.TOKEN, token);
        }

    }

    public static void initialize() throws SQLException {
        SQLite.getStatement().execute("CREATE TABLE if not exists '"+ TABLE_NAME + "' ('id' text, 'token' text);");
    }


}
