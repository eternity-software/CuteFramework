package ru.etysoft.cuteframework.sockets.methods.ChatList;

import org.json.JSONObject;
import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.methods.chat.ChatSnippet;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.sockets.WebSocket;

import java.net.URI;
import java.net.URISyntaxException;

public class ChatListSocket implements WebSocket.WebSocketHandler {

    private String token;
    private ChatReceiveHandler chatReceiveHandler;
    private WebSocket webSocket;

    public ChatListSocket(String token,
                          ChatReceiveHandler chatReceiveHandler) throws URISyntaxException {
        this.token = token;
        this.chatReceiveHandler = chatReceiveHandler;
        webSocket = new WebSocket(new URI(CuteFramework.longpollDomain), "ChatSocket", this);
    }

    public WebSocket getWebSocket() {
        return webSocket;
    }

    @Override
    public void onMessageReceived(WebSocket webSocket, String message) {
        try {
            chatReceiveHandler.onMessageReceive(new ChatSnippet(new JSONObject(message)));
        }
        catch (Exception e)
        {
            chatReceiveHandler.onMessageReceive(null);
        }
    }

    @Override
    public void onOpen(WebSocket webSocket) {
        try
        {
            webSocket.sendAPIRequest(APIMethods.Chat.GET_LIST,
                    Pair.make(APIKeys.TOKEN, token));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    @Override
    public void onClosing(WebSocket webSocket) {

    }

    public interface ChatReceiveHandler {
        void onMessageReceive(ChatSnippet message);
    }
}
