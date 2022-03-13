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

    public String getId() throws SQLException, NotCachedException {
        String token = null;
        try {
            token = getUniqueString(APIKeys.Account.ID);
        } catch (OneRowOperationException e) {
            e.printStackTrace();
        }
        if(token == null)
        {
            throw new NotCachedException(APIKeys.Account.ID);
        }
        return token;
    }

    public void setId(String id) throws SQLException, OneRowOperationException {
        if(getRowsCount() > 0)
        {
            updateValues(APIKeys.Account.ID, id);
        }
        else
        {
            putValue(APIKeys.Account.ID, id);
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

    public String getBio() throws SQLException, NotCachedException {
        return getValue(APIKeys.Account.BIO);
    }

    public String getLogin() throws SQLException, NotCachedException {
        return getValue(APIKeys.Account.LOGIN);
    }

    public String getStatus() throws SQLException, NotCachedException {
        return getValue(APIKeys.Account.STATUS);
    }

    public void setStatus(String value) throws SQLException {
         setValue(APIKeys.Account.STATUS, value);
    }

    public void setBio(String value) throws SQLException {
        setValue(APIKeys.Account.BIO, value);
    }

    public void setLogin(String value) throws SQLException {
        setValue(APIKeys.Account.LOGIN, value);
    }

    public String getName() throws SQLException, NotCachedException {
        return getValue(APIKeys.Account.NAME);
    }

    public void setName(String value) throws SQLException {
        setValue(APIKeys.Account.NAME, value);
    }

    public String getSessionId() throws SQLException, NotCachedException {
        return getValue(APIKeys.Account.SESSION_ID);
    }

    public void setSessionId(String value) throws SQLException {
        setValue(APIKeys.Account.SESSION_ID, value);
    }

    private String getValue(String valueName) throws SQLException, NotCachedException {
        String value = null;
        try {
            value = getUniqueString(valueName);
        } catch (OneRowOperationException e) {
            e.printStackTrace();
        }
        if(value == null)
        {
            throw new NotCachedException(valueName);
        }
        return value;
    }

    private void setValue(String valueName, String value) throws SQLException {
        if(getRowsCount() > 0)
        {
            updateValues(valueName, value);
        }
        else
        {
            putValue(valueName, value);
        }
    }

    private static void initialize() throws SQLException {
        String request = "CREATE TABLE if not exists '"+ TABLE_NAME + "' ('id' text, 'token' text, 'deviceId' text, 'login' text, " +
                "'name' text, 'status' text, 'bio' text, 'sessionId' text);";
        Cache.getStatement().execute(request);

            Logger.logDebug("SQL >> " + request);

    }


}
