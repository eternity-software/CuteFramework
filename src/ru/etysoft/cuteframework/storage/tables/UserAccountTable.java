package ru.etysoft.cuteframework.storage.tables;

import ru.etysoft.cuteframework.Logger;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.exceptions.NotCachedException;
import ru.etysoft.cuteframework.exceptions.OneRowOperationException;
import ru.etysoft.cuteframework.storage.Cache;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAccountTable extends Table {

    public static final String TABLE_NAME = "profile";

    public UserAccountTable() throws SQLException {
        super(TABLE_NAME);
        initialize();
    }

    public boolean hasDeviceId() {
        return hasUniqueValue(APIKeys.Account.DEVICE_ID);
    }

    public boolean hasToken()  {
       return hasUniqueValue(APIKeys.Account.TOKEN);
    }

    public String getDeviceId() throws SQLException, NotCachedException {
        String token = null;
        try {
            token = getUniqueString(APIKeys.Account.DEVICE_ID);
        } catch (OneRowOperationException e) {
            e.printStackTrace();
        }
        if(token == null)
        {
            throw new NotCachedException(APIKeys.Account.DEVICE_ID);
        }
        return token;
    }

    public void setDeviceId(String token) throws SQLException, OneRowOperationException {
        if(getRowsCount() > 0)
        {
            updateValues(APIKeys.Account.DEVICE_ID, token);
        }
        else
        {
            putValue(APIKeys.Account.DEVICE_ID, token);
        }
    }

    public String getToken() throws SQLException, NotCachedException {
        String token = null;
        try {
            token = getUniqueString(APIKeys.Account.TOKEN);
        } catch (OneRowOperationException e) {
            e.printStackTrace();
        }
        if(token == null)
        {
            throw new NotCachedException(APIKeys.Account.TOKEN);
        }
        return token;
    }

    public void setToken(String token) throws SQLException, OneRowOperationException {
        if(getRowsCount() > 0)
        {
            updateValues(APIKeys.Account.TOKEN, token);
        }
        else
        {
            putValue(APIKeys.Account.TOKEN, token);
        }
    }

    private static void initialize() throws SQLException {
        String request = "CREATE TABLE if not exists '"+ TABLE_NAME + "' ('id' text, 'token' text, 'deviceId' text);";
        Cache.getStatement().execute(request);

            Logger.logDebug("SQL >> " + request);

    }


}
