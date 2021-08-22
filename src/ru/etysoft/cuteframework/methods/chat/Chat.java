package ru.etysoft.cuteframework.methods.chat;

public class Chat {

    private int id;
    private int accountId;
    private String type;
    private String name;
    private String description;
    private String selfStatus;
    private String lastMessageText;
    private String lastMessageTime;
    private String lastMessageSenderName;
    private boolean isRead;



    public Chat(String name, int id, int accountId, String type, String description, String selfStatus,
                String lastMessageText, String lastMessageSenderName, String lastMessageTime, boolean isRead)
    {
        this.id = id;
        this.accountId = accountId;
        this.type = type;
        this.name = name;
        this.description = description;
        this.selfStatus = selfStatus;
        this.lastMessageText = lastMessageText;
        this.lastMessageSenderName = lastMessageSenderName;
        this.lastMessageTime = lastMessageTime;
        this.isRead = isRead;
    }

    public String getLastMessageText() {
        return lastMessageText;
    }

    public String getLastMessageTime() {
        return lastMessageTime;
    }

    public String getLastMessageSenderName() {
        return lastMessageSenderName;
    }

    public boolean isRead() {
        return isRead;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getSelfStatus() {
        return selfStatus;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public int getAccountId() {
        return accountId;
    }

    public static class Types
    {
        public static final String THREAD = "T";
        public static final String CONVERSATION = "C";
        public static final String PRIVATE = "P";
    }

    public static class Status
    {
        public static final String JOINED = "Y";
        public static final String LEAVED = "N";
        public static final String BLOCKED = "B";
    }
}
