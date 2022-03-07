package ru.etysoft.cuteframework;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.legacy.methods.chat.ChatList.ChatListResponse;
import ru.etysoft.cuteframework.legacy.methods.chat.ChatSnippet;
import ru.etysoft.cuteframework.legacy.methods.chat.GetHistory.GetMessageListResponse;
import ru.etysoft.cuteframework.legacy.methods.messages.Message;
import ru.etysoft.cuteframework.sockets.methods.Messages.MessagesSocket;

import java.net.URISyntaxException;

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


        try {

            MessagesSocket messagesSocket = new MessagesSocket("$2b$04$rjWOW/H2TQr1SRTjuKuDl.hrMzFCUOux2vWq8Rlq6eyrzlCRTCeaa", "2",
                    new MessagesSocket.MessageReceiveHandler() {
                        @Override
                        public void onMessageReceive(Message message) {
                            System.out.println("MEssage text: " + message.getText());
                        }
                    });
           Thread.sleep(100000);
        } catch (URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }

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