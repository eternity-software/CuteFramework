package ru.etysoft.cuteframework.sockets;

import org.json.JSONObject;

public abstract class Event {

    String eventString;

    public Event(String eventString)
    {
        this.eventString = eventString;
    }



}
