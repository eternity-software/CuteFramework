package ru.etysoft.cuteframework.sockets.paradigm.Chat;

import org.json.JSONObject;
import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.Logger;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.sockets.Event;
import ru.etysoft.cuteframework.sockets.WebSocket;
import ru.etysoft.cuteframework.sockets.events.MemberStateChangedEvent;
import ru.etysoft.cuteframework.sockets.events.NewMessageEvent;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

public class ChatSocket implements WebSocket.WebSocketHandler {

    private HashMap<Long, EventReceiveHandler> eventHandlers = new HashMap<>();
    private WebSocket webSocket;


    public ChatSocket(String token) throws URISyntaxException {
        String link = CuteFramework.webSocketLink + "/auth?token=" + token +
                "&paradigm=chat";
        System.out.println(link);
        webSocket = new WebSocket(new URI(link), "ChatSocket", this);
    }

    public WebSocket getWebSocket() {
        return webSocket;
    }

    @Override
    public void onMessageReceived(WebSocket webSocket, String message) {
        try {
            Logger.logSocket(message, webSocket.getName());

            Event event;
            String type = new JSONObject(message).getString(APIKeys.TYPE);
            long chatId = new JSONObject(message).getLong(APIKeys.CHAT_ID);
            if (type.equals(Event.Types.MEMBER_STATE)) {
                event = new MemberStateChangedEvent(message);
            } else if (type.equals(Event.Types.NEW_MESSAGE)) {
                event = new NewMessageEvent(message);
            } else {
                event = null;
            }

            eventHandlers.get(chatId).onEventReceived(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void subscribeToEvents(long chatId, EventReceiveHandler eventReceiveHandler) {
        eventHandlers.put(chatId, eventReceiveHandler);
        sendStatus(chatId, APIKeys.SUBSCRIBE);
    }

    public void sendStatus(long  chatId, String status)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(APIKeys.TYPE, status);
        jsonObject.put(APIKeys.DATA,  (new JSONObject()).put(APIKeys.CHAT_ID, chatId));
        webSocket.sendMessage(jsonObject.toString());
    }



    @Override
    public void onOpen(WebSocket webSocket) {

    }

    @Override
    public void onClosing(WebSocket webSocket) {

    }

    public interface EventReceiveHandler {
        void onEventReceived(Event event);
    }
}
