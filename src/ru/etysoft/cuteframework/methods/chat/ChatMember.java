package ru.etysoft.cuteframework.methods.chat;

public class ChatMember {

    private int id;
    private String displayName;
    private String type;
    private String selfStatus;

    public ChatMember(int id, String displayName, String type, String selfStatus) {
        this.id = id;
        this.displayName = displayName;
        this.type = type;
        this.selfStatus = selfStatus;
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getType() {
        return type;
    }

    public String getSelfStatus() {
        return selfStatus;
    }

    public static class Types
    {
        public static final String CREATOR = "C";
        public static final String ADMIN = "A";
        public static final String USER = "U";
    }

}
