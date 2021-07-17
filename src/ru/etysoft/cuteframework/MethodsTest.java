package ru.etysoft.cuteframework;

import org.junit.Assert;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import ru.etysoft.cuteframework.api.Methods;
import ru.etysoft.cuteframework.api.response.methods.AuthorizationResponseHandler;
import ru.etysoft.cuteframework.api.response.methods.InformationResponseHandler;
import ru.etysoft.cuteframework.api.response.methods.RegistrationResponseHandler;
import ru.etysoft.cuteframework.exceptions.ResponseException;

@FixMethodOrder(MethodSorters.JVM)
class MethodsTest {

    String testLogin = "kkkkfkekvqfg14f2";
    String testPassword = "1d2ffqg4f5e6";
    String testMail = "ftesetgmaqidfd@yandex.ru";
    String sessionKey = "a4c73ee4e8b664992958c530165ed0d27b02942eb3406471dcd4bf79376ee354";

    @Test
    void accountCreation() {
        RegistrationResponseHandler registrationResponseHandler = null;
        AuthorizationResponseHandler authorizationResponseHandler = null;
        try {
            registrationResponseHandler = Methods.register(testLogin, testMail, testPassword);
            authorizationResponseHandler = Methods.authorize(testLogin, testPassword);


            System.out.println(registrationResponseHandler.getSessionKey());


            System.out.println(authorizationResponseHandler.getSessionKey());


        } catch (ResponseException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(authorizationResponseHandler.isSuccess() && registrationResponseHandler.isSuccess());

    }
    @Test
    void getInfo() {
        InformationResponseHandler informationResponseHandler = null;
        try {
            informationResponseHandler = Methods.getInfo(sessionKey);
            if (informationResponseHandler.isSuccess()){
                System.out.println(informationResponseHandler.id() + " "+ informationResponseHandler.getActive());
                System.out.println(informationResponseHandler.getDisplay_name() + " ");

            }
            Assert.assertTrue(informationResponseHandler.isSuccess());

        } catch (ResponseException e) {
            e.printStackTrace();
        }


    }


}