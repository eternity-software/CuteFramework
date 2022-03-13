package ru.etysoft.cuteframework.models;

import org.json.JSONObject;
import ru.etysoft.cuteframework.consts.APIKeys;

public class ChatSnippet extends Model {
    private String type, name, id;
    private boolean isBlocked;

    public ChatSnippet(JSONObject jsonObject) {
        super(jsonObject);
        type = jsonObject.getString(APIKeys.Chat.TYPE);
        name = jsonObject.getString(APIKeys.Chat.NAME);
        isBlocked = jsonObject.getBoolean(APIKeys.Chat.IS_BLOCKED);
        id = jsonObject.getString(APIKeys.Chat.ID);
    }

    public ChatSnippet(String type, String name, String id, boolean isBlocked)
    {
        super(new JSONObject());
        this.type = type;
        this.name = name;
        this.id = id;
        this.isBlocked = isBlocked;
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
