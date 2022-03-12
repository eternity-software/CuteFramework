package ru.etysoft.cuteframework;


import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import ru.etysoft.cuteframework.methods.account.GetAccountRequest;
import ru.etysoft.cuteframework.methods.account.LoginRequest;
import ru.etysoft.cuteframework.methods.account.RegisterDeviceRequest;
import ru.etysoft.cuteframework.methods.chat.ChatCreateRequest;
import ru.etysoft.cuteframework.methods.chat.ChatGetInfoRequest;
import ru.etysoft.cuteframework.models.Chat;
import ru.etysoft.cuteframework.storage.Cache;

import java.util.ArrayList;
import java.util.HashMap;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CuteFrameworkTest {


    @Test
    public void aloginTest() {

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
            Assert.fail();
        }


        try {
            String token = Cache.getUserAccount().getToken();
            String deviceId = Cache.getUserAccount().getDeviceId();

            System.out.println("ACCOUNT TEST: \n   token=" + token + "\n   deviceId=" + deviceId);

            Assert.assertTrue((token != null && deviceId != null));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }


    }

    @Test
    public void chatTest() {
        CuteFramework.initialize();
        try {
            ChatCreateRequest.ChatCreateResponse getAccountResponse = new ChatCreateRequest("conversation", "ddd", "sadasdasdsadas").execute();


            ChatGetInfoRequest.ChatGetInfoResponse getChatResponse = new ChatGetInfoRequest(getAccountResponse.getChatId()).execute();


            Assert.assertEquals("ddd", getChatResponse.getChat().getName());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();

        }
    }

    @Test
    public void chatTestCache() {

        try {
            Cache.getChatsTable().clean();

            Chat testChat = new Chat();
            testChat.setBlocked(false);
            testChat.setType("s");
            testChat.setName("ss");
            testChat.setId("id");

            int testChatsCount = 100;
            long millisStartCreation = System.currentTimeMillis();
            for(int i = 0; i < testChatsCount; i++)
            {

                Cache.getChatsTable().addChat(testChat);
            }
            long millisCreation = System.currentTimeMillis() - millisStartCreation;

            Logger.logDebug("Test chat set created in " + millisCreation + "ms (" + testChatsCount + " chats)");

            long millisStartGetting = System.currentTimeMillis();

            HashMap<String, Chat> chats = Cache.getChatsTable().getAllChats();

            long millisGetting = System.currentTimeMillis() - millisStartGetting;

            Logger.logDebug("Getting all chats  (" + chats.size() + ") took " + millisGetting + "ms");

            Assert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();

        }
    }


    @Test
    public void getAccountTest() {
        try {
            GetAccountRequest.GetAccountResponse getAccountResponse = new GetAccountRequest().execute();
            Assert.assertTrue(getAccountResponse.getAccount().getEmail().contains("@"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();

        }
    }


}