package ru.etysoft.cuteframework.models.messages;

import org.json.JSONObject;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.models.Model;

public class Message extends Model {

    private String  id, type;
    private long createdTime, editedTime;


    public static final String TYPE_SERVICE = "service";
    public static final String TYPE_STICKER = "sticker";
    public static final String TYPE_MESSAGE = "message";
    public static final String TYPE_CALLS = "calls";

    public Message(JSONObject jsonObject) {
        super(jsonObject);
        id = jsonObject.getString(APIKeys.Message.ID);
        type = jsonObject.getString(APIKeys.Message.TYPE);
        createdTime = jsonObject.getLong(APIKeys.Message.CREATED_AT);
        editedTime = jsonObject.getLong(APIKeys.Message.UPDATED_AT);
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public long getEditedTime() {
        return editedTime;
    }

    public static Message createMessage(JSONObject jsonObject)
    {
       String type = jsonObject.getString(APIKeys.Message.TYPE);
       if(type.equals(TYPE_SERVICE))
       {
           return new ServiceMessage(jsonObject);
       }
       else if(type.equals(TYPE_MESSAGE))
        {
            return new SuperMessage(jsonObject);
        }
       return null;
    }

    public String getType() {
        return type;
    }


    public String getId() {
        return id;
    }
}
