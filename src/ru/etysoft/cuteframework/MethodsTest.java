package ru.etysoft.cuteframework;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import ru.etysoft.cuteframework.exceptions.SocketNotStartedException;
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
import ru.etysoft.cuteframework.methods.messages.GetList.GetMessageListResponse;
import ru.etysoft.cuteframework.methods.messages.Message;
import ru.etysoft.cuteframework.methods.user.Get.GetUserResponse;
import ru.etysoft.cuteframework.methods.user.Search.SearchUserResponse;
import ru.etysoft.cuteframework.sockets.Server;

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
//        GetUserResponse getUserResponse = null;
//        SearchUserResponse searchUserResponse = null;
        GetMessageListResponse getMessageListResponse = null;
        ChatListResponse response = null;
        try {
           response = Methods.getChatList(sessionKey);
            ChatSnippet chatSnippet = response.getChats().get(0);

            getMessageListResponse = Methods.getMessageList(sessionKey, "5");
            for (int i = 0; i<getMessageListResponse.getMessages().size(); i++){
                Message message = getMessageListResponse.getMessages().get(0);
                System.out.println(message.getChatId());
                System.out.println(message.getServiceData().getChatName());
            }
            System.out.println();
//            System.out.println(searchUserResponse.getUsers().size());
//            chatCreateResponse = Methods.createChat(sessionKey, testDisplay_name, desc, "C");

        } catch (ResponseException e) {
            e.printStackTrace();
        }
//        Assert.assertTrue(authorizationResponseHandler.isSuccess() && registrationResponseHandler.isSuccess());

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

        TestSocket testSocket = new TestSocket(Methods.longpollDomain, 8181);
        testSocket.start();
        int i = 0;
        try {

            testSocket.sendJSONString("");


        } catch (Exception e) {
            e.printStackTrace();
        }
        while (true)
        {


        }

    }


}