package ru.etysoft.cuteframework.sockets.methods.Messages;

import org.json.JSONObject;
import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.Logger;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.methods.chat.SendMessage.SendMessageResponse;
import ru.etysoft.cuteframework.methods.messages.Message;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.sockets.WebSocket;

import java.net.URI;
import java.net.URISyntaxException;

public class MessagesSocket implements WebSocket.WebSocketHandler {

    private String token;
    private String chatId;
    private MessageReceiveHandler messageReceiveHandler;
    private WebSocket webSocket;



    public MessagesSocket(String token, String chatId,
                          MessageReceiveHandler messageReceiveHandler) throws URISyntaxException {
        this.token = token;
        this.chatId = chatId;
        this.messageReceiveHandler = messageReceiveHandler;
        webSocket = new WebSocket(new URI(CuteFramework.longpollDomain), "MessagesSocket", this);
    }

    public WebSocket getWebSocket() {
        return webSocket;
    }

    @Override
    public void onMessageReceived(WebSocket webSocket, String message) {
        try {
            Logger.logSocket(message, webSocket.getName());
            messageReceiveHandler.onMessageReceive(new SendMessageResponse(message, webSocket.getName()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onOpen(WebSocket webSocket) {
        try
        {
            webSocket.sendAPIRequest(APIMethods.Chat.GET_MESSAGE,
                    Pair.make(APIKeys.TOKEN, token),
                    Pair.make(APIKeys.CHAT_ID, chatId)
            );
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    @Override
    public void onClosing(WebSocket webSocket) {

    }

    public interface MessageReceiveHandler {
        void onMessageReceive(SendMessageResponse message);
    }
}
