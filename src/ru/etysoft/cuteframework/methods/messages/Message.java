package ru.etysoft.cuteframework.methods.messages;

public class Message {
    private int id;
    private int accountId;
    private int chatId;
    private String text;
    private String activity;
    private String time;

    public Message(int id, int accountId, int chatId, String text, String activity, String time) {
        this.id = id;
        this.accountId = accountId;
        this.chatId = chatId;
        this.text = text;
        this.activity = activity;
        this.time = time;
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

    public String getActivity() {
        return activity;
    }

    public String getTime() {
        return time;
    }
}
