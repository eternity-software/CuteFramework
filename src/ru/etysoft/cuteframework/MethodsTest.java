package ru.etysoft.cuteframework;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import ru.etysoft.cuteframework.methods.account.Confirmation.ConfirmCodeResponse;
import ru.etysoft.cuteframework.methods.account.Confirmation.ConfirmationResponse;
import ru.etysoft.cuteframework.methods.account.EditDisplayName.EditResponse;
import ru.etysoft.cuteframework.methods.account.GetAccount.GetAccountResponse;
import ru.etysoft.cuteframework.methods.account.Login.LoginResponse;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.account.Registration.RegistrationResponse;
import ru.etysoft.cuteframework.methods.chat.ChatList.ChatListResponse;
import ru.etysoft.cuteframework.methods.chat.ChatSnippet;
import ru.etysoft.cuteframework.methods.chat.Creation.ChatCreateResponse;

@FixMethodOrder(MethodSorters.JVM)
public class MethodsTest {

    String testLogin = "kkkkkeqk1222";
    String testPassword = "q12345e6";
    String testMail = "russia1561@gmail.com";
    String testDisplay_name = "ilay";
    String sessionKey = "$2b$04$JMxIe67RtNfVUjKtQEuxhOojGcRYRhzr5XhPpmmQgES0W4nM.TvWC";
    String newName = "abobass";
    String desc = "z,aq,zll,azq";
    int code = 845696;

    @Test
    public void accountCreation() {
        ChatListResponse chatListResponse = null;
        try {
            chatListResponse = Methods.getChatList(sessionKey);
//            chatCreateResponse = Methods.createChat(sessionKey, testDisplay_name, desc, "C");

            ChatSnippet snippet = chatListResponse.getChats().get(1);
            System.out.println(snippet.getServiceData().getChatName());
        } catch (ResponseException e) {
            e.printStackTrace();
        }
//        Assert.assertTrue(authorizationResponseHandler.isSuccess() && registrationResponseHandler.isSuccess());

    }


}