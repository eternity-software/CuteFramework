package ru.etysoft.cuteframework.sockets;


import org.json.JSONObject;
import ru.etysoft.cuteframework.exceptions.SocketNotStartedException;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 *  TCPSocket Client
 */
public abstract class TCPSocket {

    private int port;
    private String host;
    private Socket socket;
    private boolean isStarted;
    private String name;

    public TCPSocket(String host, int port, String name) {
        this.port = port;
        this.host = host;
        this.name = name;
    }



    public void start() {

        try {

            socket = new Socket(host, port);

                out.println("[SOCKET] " + name +" connected");


                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                            out.flush();
                            isStarted = true;
                            while (isStarted) {
                                String eventString = in.readLine();

                                if(eventString == null)
                                {
                                    System.out.println("[SOCKET] Null received! Closing socket...");
                                    close();
                                }
                                else
                                {
                                    preReceive(eventString);
                                }

                            }
                        } catch (IOException e) {
                            close();
                        }
                    }
                });
                thread.start();



        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void close() {
        try {
            if (isStarted) {
                out.println("[SOCKET] Closing " + name);
                isStarted = false;
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendString(String stringToServer) throws SocketNotStartedException {
        try {
            if (isStarted) {

                out.println("[SOCKET] " + name +" sent '" + stringToServer + "'");
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                out.write(stringToServer);
                out.flush();
            } else throw new SocketNotStartedException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void preReceive(String eventString) {
        System.out.println("[SOCKET] " + name + " >> New event received: " + eventString);
        onReceiveEvent(eventString);
    }

    public abstract void onReceiveEvent(String eventString);

}
