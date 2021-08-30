package ru.etysoft.cuteframework.sockets;


import org.json.JSONObject;
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
    private boolean isStarted;
    private String name;

    public APISocket(String host, int port, String name) {
        this.port = port;
        this.host = host;
        this.name = name;
    }

    public JSONObject prepareData()
    {
        JSONObject jsonData = new JSONObject();

      // String[] methodPath = method.split("/");


        JSONObject requestObj = new JSONObject();
        requestObj.put("model", "message");
        requestObj.put("method", "getList");
        requestObj.put("version", "0.0.1");
        requestObj.put("action", "listen");

        JSONObject params = new JSONObject();
        params.put("token", "$2b$04$rjWOW/H2TQr1SRTjuKuDl.hrMzFCUOux2vWq8Rlq6eyrzlCRTCeaa");
        params.put("chatId", "1");

        jsonData.put("request", requestObj);
        jsonData.put("params", params);
        return jsonData;
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

    public void sendJSONString(String stringToServer) throws SocketNotStartedException {
       sendString(prepareData().toString());
    }

    public void preReceive(String eventString) {
        System.out.println("[SOCKET] " + name + " >> New event received: " + eventString);
        onReceiveEvent(eventString);
    }

    public abstract void onReceiveEvent(String eventString);

}
