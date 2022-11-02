package ru.etysoft.cuteframework;


import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import ru.etysoft.cuteframework.exceptions.NotCachedException;

import ru.etysoft.cuteframework.methods.account.RegisterRequest;
import ru.etysoft.cuteframework.methods.account.SignInRequest;

import ru.etysoft.cuteframework.models.Chat;
import ru.etysoft.cuteframework.models.ChatSnippet;
import ru.etysoft.cuteframework.models.Device;
import ru.etysoft.cuteframework.storage.Cache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.HashMap;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CuteFrameworkTest {


    @Test
    public void registerTest() {

        CuteFramework.initialize();
        String deviceIdB = null;


        try {



            SignInRequest.Response response = new RegisterRequest("karlov", "123456", "jopa@etysoft.ru", new Device("testDevice", "mobile", "testAddress")).execute();

            if(!response.isSuccess())
            {
                Assert.fail();
            }

            System.out.println("access token: " + response.getAccessToken());


        } catch (Exception e) {
            e.printStackTrace();

        }




    }

    @Test
    public void loginTest() {

        CuteFramework.initialize();
        String deviceIdB = null;
        try {
            String tokenB = Cache.getUserAccount().getToken();
            deviceIdB = Cache.getUserAccount().getDeviceId();
            System.out.println("ACCOUNT TEST: \n   token=" + tokenB + "\n   deviceId=" + deviceIdB);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {



            SignInRequest.Response response = new SignInRequest("karlov", "123456",  new Device("testDevice", "mobile", "testAddress")).execute();

            if(!response.isSuccess())
            {
                Assert.fail();
            }

            System.out.println("access token: " + response.getAccessToken());


        } catch (Exception e) {
            e.printStackTrace();

        }




    }


    @Test
    public void stressSql()
    {
        try
        {
            int i = 0;
            while (i < 100000)
            {
                try {

                    Cache.getUserAccount().getToken();
                    Cache.getUserAccount().getLogin();
                    Cache.getUserAccount().getAllRows();
                } catch (NotCachedException | SQLException e) {
                    e.printStackTrace();
                }

                i++;

            }
            Assert.assertTrue(true);


        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }




}