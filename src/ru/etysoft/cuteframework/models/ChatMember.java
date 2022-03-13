package ru.etysoft.cuteframework.models;

import org.json.JSONObject;

public class ChatMember extends Model
{

    public static final String TYPE_USER = "user";
    public static final String TYPE_MODERATOR = "moderator";
    public static final String TYPE_ADMIN = "admin";
    public static final String TYPE_OWNER = "owner";

    public ChatMember(JSONObject jsonObject) {
        super(jsonObject);
    }
}
