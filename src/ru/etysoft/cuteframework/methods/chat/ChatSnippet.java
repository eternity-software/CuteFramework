package ru.etysoft.cuteframework.methods.chat;

import org.json.JSONObject;
import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.methods.messages.Message;

public class ChatSnippet {
    private int id;
    private String type;
    private String name;
    private String state;
    private String avatarPath;
    private Message message;


    public ChatSnippet(JSONObject snippetObj) {
        JSONObject chatObj = snippetObj.getJSONObject(APIKeys.CHAT);

        name = chatObj.getString(APIKeys.NAME);

        id = chatObj.getInt(APIKeys.ID);

        type = chatObj.getString(APIKeys.TYPE);
        state = chatObj.getString(APIKeys.STATE);


        if(snippetObj.has(APIKeys.Message.MESSAGE))
        {
            JSONObject messageObj = snippetObj.getJSONObject(APIKeys.Message.MESSAGE);
            message = new Message(messageObj);
        }


        if (!chatObj.isNull(APIKeys.AVATAR)) {
            avatarPath = CuteFramework.mediaDomain + chatObj.getString(APIKeys.AVATAR);
        }


    }

    public Message getMessage() {
        return message;
    }

    public String getAvatarPath() {
        return avatarPath;
    }


    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public int getId() {
        return id;
    }

    public static class Types {
        public static final String THREAD = "T";
        public static final String CONVERSATION = "C";
        public static final String PRIVATE = "P";
    }

    public static class Status {
        public static final String JOINED = "Y";
        public static final String LEAVED = "N";
        public static final String BLOCKED = "B";
    }
}
