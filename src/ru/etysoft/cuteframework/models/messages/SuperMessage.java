package ru.etysoft.cuteframework.models.messages;

import org.json.JSONObject;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.models.Account;

public class SuperMessage extends Message{

    private Account sender;
    private String text;

    public SuperMessage(JSONObject jsonObject) {
        super(jsonObject);
        text = jsonObject.getString(APIKeys.Message.TEXT);
        if(jsonObject.has(APIKeys.Message.ACCOUNT_INFO))
        {
            sender = new Account(jsonObject.getJSONObject(APIKeys.Message.ACCOUNT_INFO));
        }
        else if(jsonObject.has(APIKeys.Message.SENDER))
        {
            sender = new Account(jsonObject.getJSONObject(APIKeys.Message.SENDER));
        }
    }

    public Account getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }
}
