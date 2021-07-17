package ru.etysoft.cuteframework;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import ru.etysoft.cuteframework.methods.Authorization.AuthorizationResponse;
import ru.etysoft.cuteframework.methods.Registration.RegistrationResponse;
import ru.etysoft.cuteframework.exceptions.ResponseException;

@FixMethodOrder(MethodSorters.JVM)
class MethodsTest {

    String testLogin = "kkkkkek12";
    String testPassword = "12345e6";
    String testMail = "tesetmail@yandex.ru";

    @Test
    void accountCreation() {
        RegistrationResponse registrationResponseHandler = null;
        AuthorizationResponse authorizationResponseHandler = null;
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


}