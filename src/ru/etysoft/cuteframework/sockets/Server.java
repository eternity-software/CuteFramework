package ru.etysoft.cuteframework.sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static Socket clientSocket; //сокет для общения
    private static ServerSocket server; // серверсокет
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public static void start() {
        try {
            try {
                server = new ServerSocket(4004); // серверсокет прослушивает порт 4004
                System.out.println("Сервер запущен!"); // хорошо бы серверу
                clientSocket = server.accept(); // accept() будет ждать пока
                //кто-нибудь не захочет подключиться

                // к созданию потоков ввода/вывода.
                // теперь мы можем принимать сообщения
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // и отправлять
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                while (true) {

                    //   объявить о своем запуске


                    String word = in.readLine(); // ждём пока клиент что-нибудь нам напишет

                    // не долго думая отвечает клиенту
                    out.write("Привет, это Сервер! Подтверждаю, вы написали : " + word + "\n");
                    out.flush(); // выталкиваем все из буфера
                }

            } finally {
                System.out.println("Сервер закрыт!");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
