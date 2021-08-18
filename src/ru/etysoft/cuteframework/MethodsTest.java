package ru.etysoft.cuteframework;


import org.junit.Assert;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import ru.etysoft.cuteframework.methods.Login.LoginResponse;
import ru.etysoft.cuteframework.methods.Registration.RegistrationResponse;
import ru.etysoft.cuteframework.exceptions.ResponseException;

@FixMethodOrder(MethodSorters.JVM)
public class MethodsTest {

    String testLogin = "kkkkkeqk12";
    String testPassword = "q12345e6";
    String testMail = "teqsetmail@yandex.ru";
    String testDisplay_name = "iluxa";

    @Test
    public void accountCreation() {
        RegistrationResponse registrationResponseHandler = null;
        LoginResponse authorizationResponseHandler = null;
        try {
            registrationResponseHandler = Methods.register(testLogin, testMail, testPassword, testDisplay_name);
            authorizationResponseHandler = Methods.authorize(testLogin, testPassword);


            System.out.println(registrationResponseHandler.getSessionKey());

            System.out.println(authorizationResponseHandler.getSessionKey());


        } catch (ResponseException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(authorizationResponseHandler.isSuccess() && registrationResponseHandler.isSuccess());

    }


}