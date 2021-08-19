package ru.etysoft.cuteframework.methods.chat;

public class Chat {

    private int id;
    private int accountId;
    private String type;
    private String name;
    private String description;
    private String selfStatus;

    public Chat(String name, int id, int accountId, String type, String description, String selfStatus)
    {
        this.id = id;
        this.accountId = accountId;
        this.type = type;
        this.name = name;
        this.description = description;
        this.selfStatus = selfStatus;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
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
}
