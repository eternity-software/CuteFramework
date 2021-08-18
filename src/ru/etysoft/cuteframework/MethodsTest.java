package ru.etysoft.cuteframework;


import org.junit.Assert;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import ru.etysoft.cuteframework.methods.Confirmation.ConfirmCodeRequest;
import ru.etysoft.cuteframework.methods.Confirmation.ConfirmCodeResponse;
import ru.etysoft.cuteframework.methods.Confirmation.ConfirmationResponse;
import ru.etysoft.cuteframework.methods.EditDisplayName.EditResponse;
import ru.etysoft.cuteframework.methods.GetAccount.GetAccountResponse;
import ru.etysoft.cuteframework.methods.Login.LoginResponse;
import ru.etysoft.cuteframework.methods.Registration.RegistrationResponse;
import ru.etysoft.cuteframework.exceptions.ResponseException;

@FixMethodOrder(MethodSorters.JVM)
public class MethodsTest {

    String testLogin = "kkkkkeqk1222";
    String testPassword = "q12345e6";
    String testMail = "russia1561@gmail.com";
    String testDisplay_name = "iluxaa";
    String sessionKey = "$2b$04$uYdJlxE42iU89TC01nkZluebKm40ZjfXOrBgEozqaghrzo1TMpzAS";
    String newName = "abobass";
    int code = 845696;

    @Test
    public void accountCreation() {
//        RegistrationResponse registrationResponseHandler = null;
        LoginResponse authorizationResponseHandler = null;
        GetAccountResponse getAccountResponse = null;
        EditResponse editResponse = null;
        ConfirmCodeResponse confirmCodeRequest = null;
        ConfirmationResponse confirmationResponse = null;
        try {
//            registrationResponseHandler = Methods.register(testLogin, testMail, testPassword, testDisplay_name);
            authorizationResponseHandler = Methods.authorize(testLogin, testPassword);
            getAccountResponse = Methods.getInfo(sessionKey);



            System.out.println(getAccountResponse.getConfirm());
            System.out.println(getAccountResponse.getLogin());
            System.out.println(getAccountResponse.getDisplay_name());
            editResponse = Methods.editDisplayName(sessionKey, newName);
            System.out.println(editResponse.getStatus());
            System.out.println(getAccountResponse.getDisplay_name());
        } catch (ResponseException e) {
            e.printStackTrace();
        }
//        Assert.assertTrue(authorizationResponseHandler.isSuccess() && registrationResponseHandler.isSuccess());

    }


}