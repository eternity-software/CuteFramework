package ru.etysoft.cuteframework.methods.chat;


import org.json.JSONObject;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;

public class ServiceData {
    private JSONObject messageServiceData;

    public ServiceData(String messageServiceData) {
        if (!messageServiceData.equals("0")) {
            this.messageServiceData = new JSONObject(messageServiceData);
        }
    }
    public ServiceData(JSONObject jsonObject){
        if(jsonObject.length() != 0){
            this.messageServiceData = jsonObject;
        }
    }

    public String getDisplayName() throws ResponseException {
        if (messageServiceData == null) throw new ResponseException("No service data");
        return messageServiceData.getString(APIKeys.DISPLAY_NAME);
    }

    public int getAccountId() throws ResponseException {
        if (messageServiceData == null) throw new ResponseException("No service data");
        return messageServiceData.getInt(APIKeys.ACCOUNT_ID);
    }

    public String getChatName() throws ResponseException {
        if (messageServiceData == null) throw new ResponseException("No service data");
        return messageServiceData.getString("chatName");
    }

    public String getType() {
        return messageServiceData.getString(APIKeys.TYPE);
    }

    public static class Types {
        public static final String CHAT_CREATED = "chatCreated";
        public static final String ADD_MEMBER = "addMember";
    }

}
