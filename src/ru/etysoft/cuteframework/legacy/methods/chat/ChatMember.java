package ru.etysoft.cuteframework.legacy.methods.chat;

public class ChatMember {

    private long id;
    private String displayName;
    private String type;
    private String avatar;

    public ChatMember(long id, String displayName, String type,
                      String avatar) {
        this.id = id;
        this.displayName = displayName;
        this.type = type;

        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public long getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getType() {
        return type;
    }


    public static class Types
    {
        public static final String CREATOR = "C";
        public static final String ADMIN = "A";
        public static final String USER = "U";
    }

}
