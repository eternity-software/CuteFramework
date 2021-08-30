package ru.etysoft.cuteframework;

import ru.etysoft.cuteframework.sockets.TCPSocket;

public class TestSocket extends TCPSocket {
    public TestSocket(String host, int port) {
        super(host, port, "TestSocket");
    }

    @Override
    public void onReceiveEvent(String eventString) {

    }
}
