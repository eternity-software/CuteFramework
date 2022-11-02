package ru.etysoft.cuteframework.storage.tables;

import ru.etysoft.cuteframework.Logger;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.exceptions.NotCachedException;
import ru.etysoft.cuteframework.exceptions.OneRowOperationException;
import ru.etysoft.cuteframework.storage.Cache;

import java.sql.SQLException;

public class UserAccountTable extends Table {

    public static final String TABLE_NAME = "profile";

    public UserAccountTable() throws SQLException {
        super(TABLE_NAME);
        initialize();
    }

    public boolean hasDeviceId() {
        return hasUniqueValue(APIKeys.Account.DEVICE);
    }

    public boolean hasToken()  {
       return hasUniqueValue(APIKeys.Account.TOKEN);
    }

    public String getDeviceId() throws NotCachedException {
        String token = null;
        try {
            token = getUniqueString(APIKeys.Account.DEVICE);
        } catch (OneRowOperationException | SQLException e) {
            e.printStackTrace();
        }
        if(token == null)
        {
            throw new NotCachedException(APIKeys.Account.DEVICE);
        }
        return token;
    }

    public void setDeviceId(String token) {
        try {
            if(getRowsCount() > 0)
            {
                updateValues(APIKeys.Account.DEVICE, token);
            }
            else
            {
                putValue(APIKeys.Account.DEVICE, token);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getId() throws NotCachedException {
        String token = null;
        try {
            token = getUniqueString(APIKeys.Account.ID);
        } catch (OneRowOperationException | SQLException e) {
            e.printStackTrace();
        }
        if(token == null)
        {
            throw new NotCachedException(APIKeys.Account.ID);
        }
        return token;
    }

    public void setId(String id) {
        try {
            if(getRowsCount() > 0)
            {
                updateValues(APIKeys.Account.ID, id);
            }
            else
            {
                putValue(APIKeys.Account.ID, id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getToken() throws NotCachedException {
        String token = null;
        try {
            token = getUniqueString(APIKeys.Account.TOKEN);
        } catch (OneRowOperationException | SQLException e) {
            e.printStackTrace();
        }
        if(token == null)
        {
            throw new NotCachedException(APIKeys.Account.TOKEN);
        }
        return token;
    }

    public void setAccessToken(String token) {
        try {
            if(getRowsCount() > 0)
            {
                updateValues(APIKeys.Token.ACCESS, token);
            }
            else
            {
                putValue(APIKeys.Token.ACCESS, token);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setRefreshToken(String token) {
        try {
            if(getRowsCount() > 0)
            {
                updateValues(APIKeys.Token.REFRESH, token);
            }
            else
            {
                putValue(APIKeys.Token.REFRESH, token);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getBio() throws NotCachedException {
        return getValue(APIKeys.Account.BIO);
    }

    public String getLogin() throws NotCachedException {
        return getValue(APIKeys.Account.LOGIN);
    }

    public String getStatus() throws  NotCachedException {
        return getValue(APIKeys.Account.STATUS);
    }

    public String getAccessToken() throws  NotCachedException {
        return getValue(APIKeys.Token.ACCESS);
    }

    public String getRefreshToken() throws  NotCachedException {
        return getValue(APIKeys.Token.REFRESH);
    }

    public void setStatus(String value)  {
         setValue(APIKeys.Account.STATUS, value);
    }

    public void setBio(String value)  {
        setValue(APIKeys.Account.BIO, value);
    }

    public void setLogin(String value) {
        setValue(APIKeys.Account.LOGIN, value);
    }

    public String getName() throws  NotCachedException {
        return getValue(APIKeys.Account.NAME);
    }

    public void setName(String value)  {
        setValue(APIKeys.Account.NAME, value);
    }

    public String getSessionId() throws SQLException, NotCachedException {
        return getValue(APIKeys.Account.SESSION_ID);
    }

    public void setSessionId(String value)  {
        setValue(APIKeys.Account.SESSION_ID, value);
    }

    private String getValue(String valueName) throws  NotCachedException {
        String value = null;
        try {
            value = getUniqueString(valueName);
        } catch (OneRowOperationException | SQLException e) {
            e.printStackTrace();
        }
        if(value == null)
        {
            throw new NotCachedException(valueName);
        }
        return value;
    }

    private void setValue(String valueName, String value)  {
        try {
            if(getRowsCount() > 0)
            {
                updateValues(valueName, value);
            }
            else
            {
                putValue(valueName, value);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void initialize() throws SQLException {
        String request = "CREATE TABLE if not exists '"+ TABLE_NAME + "' ('id' text, 'token' text, 'deviceId' text, 'login' text, " +
                "'name' text, 'status' text, 'bio' text, 'sessionId' text);";
        Cache.getStatement().execute(request);

            Logger.logDebug("SQL >> " + request);

    }


}
