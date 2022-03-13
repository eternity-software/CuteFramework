package ru.etysoft.cuteframework.models;

import org.json.JSONObject;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.models.messages.Message;

public class ChatSnippet extends Model {
    private String type, name, id;
    private boolean isBlocked;
    private Message lastMessage;

    public ChatSnippet(JSONObject jsonObject) {
        super(jsonObject);
        type = jsonObject.getString(APIKeys.Chat.TYPE);
        name = jsonObject.getString(APIKeys.Chat.NAME);
        isBlocked = jsonObject.getBoolean(APIKeys.Chat.IS_BLOCKED);
        id = jsonObject.getString(APIKeys.Chat.ID);
        if(jsonObject.has(APIKeys.Chat.MESSAGE))
        {
            lastMessage = Message.createMessage(jsonObject.getJSONObject(APIKeys.Chat.MESSAGE));
        }
    }

    public ChatSnippet(String type, String name, String id, boolean isBlocked)
    {
        super(new JSONObject());
        this.type = type;
        this.name = name;
        this.id = id;
        this.isBlocked = isBlocked;
    }

    public Message getLastMessage() {
        return lastMessage;
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
