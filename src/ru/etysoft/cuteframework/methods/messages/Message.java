package ru.etysoft.cuteframework.methods.messages;

public class Message {
    private int id;
    private int accountId;
    private int chatId;
    private String text;
    private String selfStatus;
    private String time;
    private String displayName;

    public Message(int id, int accountId, int chatId, String text, String selfStatus, String time, String displayName) {
        this.id = id;
        this.accountId = accountId;
        this.chatId = chatId;
        this.text = text;
        this.selfStatus = selfStatus;
        this.time = time;
        this.displayName = displayName;
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
}
