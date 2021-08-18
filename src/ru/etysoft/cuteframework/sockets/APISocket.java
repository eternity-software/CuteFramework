package ru.etysoft.cuteframework.sockets;


import ru.etysoft.cuteframework.exceptions.SocketNotStartedException;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

import static java.lang.System.in;
import static java.lang.System.out;

public abstract class APISocket {

    private int port;
    private String host;
    private Socket socket;
    private boolean isStarted = false;

    public APISocket(String host, int port) {
        this.port = port;
        this.host = host;
    }

    public void start() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            try {
                isStarted = true;
                socket = new Socket(host, port);

                out.flush();
                while (isStarted) {
                    String eventString = in.readLine();
                    onReceiveEvent(eventString);
                }
            } finally {
                socket.close();
                in.close();
                out.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if(isStarted) {
                socket.close();
                isStarted = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendString(String stringToServer) throws SocketNotStartedException {
        try {
            if(isStarted) {
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                out.write(stringToServer);
                out.close();
            }
            else throw new SocketNotStartedException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void onReceiveEvent(String eventString);

}
