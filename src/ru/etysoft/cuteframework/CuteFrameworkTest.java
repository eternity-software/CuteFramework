package ru.etysoft.cuteframework;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import ru.etysoft.cuteframework.exceptions.ResponseException;


import ru.etysoft.cuteframework.sqlite.SQLite;
import ru.etysoft.cuteframework.sqlite.tables.ProfileData;

import java.net.URISyntaxException;
import java.sql.SQLException;

@FixMethodOrder(MethodSorters.JVM)
public class CuteFrameworkTest {

    String testLogin = "kkkkkeqk1222";
    String testPassword = "q12345e6";
    String testMail = "russia1561@gmail.com";
    String testDisplay_name = "ilay";
    String sessionKey = "$2b$04$JMxIe67RtNfVUjKtQEuxhOojGcRYRhzr5XhPpmmQgES0W4nM.TvWC";
    String newName = "abobass";
    String desc = "z,aq,zll,azq";
    int code = 845696;


    @Test
    public void profileCacheTest() {

        CuteFramework.initialize();
        try {
            System.out.println("CURRENT TOKEN: " +  SQLite.getProfileData().getToken());
            SQLite.getProfileData().setToken("123456");
            System.out.println("TOKEN AFTER SAVE: " +  SQLite.getProfileData().getToken());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void accountCreation() {
//        GetUserResponse getUserResponse = null;
//        SearchUserResponse searchUserResponse = null;

    }

    @Test
    public void socketTest() {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Server.start();
//            }
//        });
//        thread.start();




//        TestSocket testSocket = new TestSocket(Methods.longpollDomain, 8181);
//        testSocket.start();
//        TestSocket testSocket2 = new TestSocket(Methods.longpollDomain, 8181);
//        testSocket2.start();
//        int i = 0;
//        try {
//
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        while (true)
//        {
//
//
//        }

    }


}