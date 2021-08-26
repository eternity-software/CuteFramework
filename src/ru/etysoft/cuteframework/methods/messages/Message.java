package ru.etysoft.cuteframework.methods.messages;

import ru.etysoft.cuteframework.methods.chat.ServiceData;

public class Message {
    private int id;
    private int accountId;
    private int chatId;
    private String text;
    private String selfStatus;
    private String time;
    private String displayName;
    private String type;
    private ServiceData serviceData;

    public Message(int id, int accountId, int chatId, String text, String selfStatus, String time, String displayName, String type, ServiceData serviceData) {
        this.id = id;
        this.type = type;
        this.serviceData = serviceData;
        this.accountId = accountId;
        this.chatId = chatId;
        this.text = text;
        this.selfStatus = selfStatus;
        this.time = time;
        this.displayName = displayName;
    }

    public ServiceData getServiceData() {
        return serviceData;
    }

    public String getType() {
        return type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getId() {
        return id;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getChatId() {
        return chatId;
    }

    public String getText() {
        return text;
    }

    public String getSelfStatus() {
        return selfStatus;
    }

    public String getTime() {
        return time;
    }

    public static class Type
    {
        public static final String SERVICE = "service";
        public static final String USER = "user";
    }


    public static class Status
    {
        public static final String AVAILABLE = "Y";
        public static final String DELETED = "N";
    }

}
