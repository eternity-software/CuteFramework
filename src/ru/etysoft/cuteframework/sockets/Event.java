package ru.etysoft.cuteframework.sockets;

public abstract class Event {


    private String eventJson;

    public Event(String eventJson)
    {
        this.eventJson = eventJson;
        processEvent(eventJson);
    }

    public abstract void processEvent(String eventJson);

    public static class Types
    {
        public static final String NEW_MESSAGE = "newMessage";
        public static final String MEMBER_STATE = "memberState";
    }


}
