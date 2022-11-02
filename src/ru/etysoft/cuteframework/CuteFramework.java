package ru.etysoft.cuteframework;

import ru.etysoft.cuteframework.exceptions.NotLoggedInExeption;
import ru.etysoft.cuteframework.methods.account.SignInRequest;
import ru.etysoft.cuteframework.storage.Cache;
import java.sql.SQLException;

public class CuteFramework {

    public static String API_DOMAIN = "http://188.225.26.241:3000/";
    public static String MEDIA_DOMAIN = "https://api.mcute.ru";
    public static String MAIN_DOMAIN = "https://mcute.ru/";
    public static String API_VERSION = "0.0.1";

    private static String accessToken = "";
    private static String refreshToken = "";
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
        SignInRequest.Response.setLoginCallback(new SignInRequest.Response.LoginCallback() {
            @Override
            public void onLogin(String accessToken, String refreshToken) {
                CuteFramework.accessToken = accessToken;
                CuteFramework.refreshToken = refreshToken;
                // TODO: id get and set

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



    public static String getId() throws NotLoggedInExeption {
        if(accessToken == null) throw new NotLoggedInExeption();
        return id;
    }

    public static String getAccessToken() throws NotLoggedInExeption {
        if(accessToken == null) throw new NotLoggedInExeption();
        return accessToken;
    }
}