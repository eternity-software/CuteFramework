package ru.etysoft.cuteframework.sockets;


import org.json.JSONObject;
import ru.etysoft.cuteframework.Logger;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.methods.messages.Message;
import ru.etysoft.cuteframework.requests.Pair;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

/**
 * WebSocket Client
 */
@ClientEndpoint
public class WebSocket {

    private Session userSession = null;
    private static int lastSocketId = 0;
    private int socketId;
    private String name;
    private WebSocketHandler webSocketHandler;
    private ArrayList<Runnable > onCloseListeners = new ArrayList<>();

    /**
     * New socket constructor
     *
     * @param webSocketUrl
     * @param name         Socket name by intent
     */
    public WebSocket(URI webSocketUrl, String name, WebSocketHandler webSocketHandler) {
        this.name = name + " #" + lastSocketId;
        socketId = lastSocketId;
        lastSocketId++;
        this.webSocketHandler = webSocketHandler;
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        try {
            container.connectToServer(this, webSocketUrl);
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void addOnClose(Runnable onClose)
    {
        onCloseListeners.add(onClose);
    }


    public Session getUserSession() {
        return userSession;
    }

    /**
     * Get id of last created socket
     */
    public static int getLastSocketId() {
        return lastSocketId;
    }

    /**
     * Get id of current socket
     */
    public int getSocketId() {
        return socketId;
    }

    /**
     * Get name of current socket
     */
    public String getName() {
        return name;
    }

    /**
     * Callback hook for Connection open events.
     *
     * @param userSession the userSession which is opened.
     */
    @OnOpen
    public void onOpen(Session userSession) {
        Logger.logSocket("Socket opened", name);
        this.userSession = userSession;
        webSocketHandler.onOpen(this);
    }


    /**
     * Callback hook for Connection close events.
     */
    @OnClose
    public void onClose() {
        webSocketHandler.onClosing(this);

        try {
            getUserSession().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.userSession = null;
        for(Runnable runnable : onCloseListeners)
        {
            runnable.run();
        }
        Logger.logSocket("Socket closed", name);
    }

    /**
     * Callback hook for Message Events.
     * This method will be invoked when client receives message from server
     *
     * @param message The text message
     */
    @OnMessage
    public void onMessage(String message) {
        try {
            Logger.logSocket("Received string\n> " + message, name);
            webSocketHandler.onMessageReceived(this, message);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    /**
     * Send a message to server.
     *
     * @param message
     */
    public void sendMessage(String message) {
        Logger.logSocket("Sending " + message, name);
        this.userSession.getAsyncRemote().sendText(message);
    }

    public interface WebSocketHandler {
        void onMessageReceived(WebSocket webSocket, String message);

        void onOpen(WebSocket webSocket);

        void onClosing(WebSocket webSocket);
    }

}