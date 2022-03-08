package ru.etysoft.cuteframework;

import ru.etysoft.cuteframework.exceptions.NotLoggedInExeption;
import ru.etysoft.cuteframework.methods.account.LoginRequest;
import ru.etysoft.cuteframework.storage.Cache;
import java.sql.SQLException;

public class CuteFramework {

    public static String API_DOMAIN = "https://api.mcute.ru/";
    public static String MEDIA_DOMAIN = "https://api.mcute.ru";
    public static String MAIN_DOMAIN = "https://mcute.ru/";
    public static String API_VERSION = "0.0.1";

    private static String token = "";
    private static long expiresIn = 0;
    private static String id;
    private static String cacheDirPath = "";
    private static String sqlClassName = "org.sqlite.JDBC";
    private static String jdbcUrl = "jdbc:sqlite:";

    public static void setSqlClassName(String sqlClassName) {
        CuteFramework.sqlClassName = sqlClassName;
    }

    public static void setJdbcUrl(String jdbcUrl) {
        CuteFramework.jdbcUrl = jdbcUrl;
    }

    public static void initialize()
    {
        LoginRequest.LoginResponse.setLoginCallback(new LoginRequest.LoginResponse.LoginCallback() {
            @Override
            public void onLogin(String token, String id, long expiresIn) {
                CuteFramework.token = token;
                CuteFramework.expiresIn = expiresIn * 1000;
                CuteFramework.id = id;
            }
        });
        try {
            Cache.initialize(cacheDirPath, sqlClassName, jdbcUrl);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void setCacheDir(String cacheDirPath) {
        CuteFramework.cacheDirPath = cacheDirPath;
    }

    public static long getExpiresIn() throws NotLoggedInExeption {
        if(token == null) throw new NotLoggedInExeption();
        return expiresIn;
    }

    public static String getId() throws NotLoggedInExeption {
        if(token == null) throw new NotLoggedInExeption();
        return id;
    }

    public static String getToken() throws NotLoggedInExeption {
        if(token == null) throw new NotLoggedInExeption();
        return token;
    }
}