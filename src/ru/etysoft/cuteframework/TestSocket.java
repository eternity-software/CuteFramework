package ru.etysoft.cuteframework;

import ru.etysoft.cuteframework.sockets.APISocket;

public class TestSocket extends APISocket {
    public TestSocket(String host, int port) {
        super(host, port, "TestSocket");
    }

    @Override
    public void onReceiveEvent(String eventString) {

    }
}
