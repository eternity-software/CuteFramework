package ru.etysoft.cuteframework;


import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import ru.etysoft.cuteframework.exceptions.NoSuchValueException;
import ru.etysoft.cuteframework.exceptions.NotCachedException;


import ru.etysoft.cuteframework.exceptions.OneRowOperationException;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.account.GetAccount;
import ru.etysoft.cuteframework.methods.account.LoginRequest;
import ru.etysoft.cuteframework.methods.account.RegisterDeviceRequest;
import ru.etysoft.cuteframework.storage.Cache;

import java.sql.SQLException;

@FixMethodOrder(MethodSorters.DEFAULT)
public class CuteFrameworkTest {

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

            RegisterDeviceRequest.RegisterDeviceResponse registerDeviceResponse =
                    new RegisterDeviceRequest("test device", "mobile").execute();

            LoginRequest.LoginResponse loginResponse = new LoginRequest("karlové", "123456").execute();



        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            String token = Cache.getUserAccount().getToken();
            String deviceId = Cache.getUserAccount().getDeviceId();

            System.out.println("ACCOUNT TEST: \n   token=" + token + "\n   deviceId=" + deviceId);

            Assert.assertTrue((token != null && deviceId != null));
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    @Test
    public void getAccountTest()
    {
        try {
            GetAccount.GetAccountResponse getAccountResponse = new GetAccount().execute();
            Assert.assertTrue(getAccountResponse.getAccount().getEmail().contains("@"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();

        }
    }



}