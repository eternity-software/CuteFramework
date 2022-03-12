package ru.etysoft.cuteframework.models;

import org.json.JSONObject;
import ru.etysoft.cuteframework.consts.APIKeys;

public class Chat extends Model{

    private String type, name, id;
    private boolean isBlocked;

    private static final String TYPE_CONVERSATION = "conversation";
    private static final String TYPE_P2P = "pointToPoint";
    private static final String TYPE_PRIVATE = "private";
    private static final String TYPE_WEBRTC = "webRTC";

    public Chat(JSONObject jsonObject) {
        super(jsonObject);
        type = jsonObject.getString(APIKeys.Chat.TYPE);
        name = jsonObject.getString(APIKeys.Chat.NAME);
        isBlocked = jsonObject.getBoolean(APIKeys.Chat.IS_BLOCKED);
        id = jsonObject.getString(APIKeys.Chat.ID);
    }

    public Chat() {
        super(new JSONObject());
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public boolean isBlocked() {
        return isBlocked;
    }
}
