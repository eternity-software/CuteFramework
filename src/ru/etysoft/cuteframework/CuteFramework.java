package ru.etysoft.cuteframework;


import ru.etysoft.cuteframework.exceptions.NotLoggedInExeption;
import ru.etysoft.cuteframework.methods.account.LoginResponse;

public class CuteFramework {

    public static String API_DOMAIN = "https://api.mcute.ru/";
    public static String MEDIA_DOMAIN = "https://api.mcute.ru";
    public static String MAIN_DOMAIN = "https://mcute.ru/";
    public static String API_VERSION = "0.0.1";

    private static String token = "";
    private static long expiresIn = 0;
    private static String id;

    public CuteFramework()
    {
        LoginResponse.setLoginCallback(new LoginResponse.LoginCallback() {
            @Override
            public void onLogin(String token, String id, String expiresIn) {
                CuteFramework.token = token;
                CuteFramework.expiresIn = Long.parseLong(expiresIn) * 1000;
                CuteFramework.id = id;
            }
        });
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
