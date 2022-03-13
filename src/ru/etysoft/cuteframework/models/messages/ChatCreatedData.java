package ru.etysoft.cuteframework.models.messages;

import org.json.JSONObject;
import ru.etysoft.cuteframework.consts.APIKeys;

public class ChatCreatedData extends ServiceData{

    private String chatName;

    public ChatCreatedData(JSONObject jsonObject) {
        super(jsonObject);
        chatName = jsonObject.getString(APIKeys.ServiceData.CHAT_NAME);
    }

    public String getChatName() {
        return chatName;
    }
}
