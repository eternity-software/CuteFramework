package ru.etysoft.cuteframework.methods.chat;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.exceptions.ResponseException;

public class ServiceData {
    private JSONObject messageServiceData;

    public ServiceData(String messageServiceData) {
        if (!messageServiceData.equals("0")) {
            JSONObject jsonObject = new JSONObject(messageServiceData);
            this.messageServiceData = jsonObject;
        }
    }
    public ServiceData(JSONObject jsonObject){
        if(!jsonObject.isEmpty()){
            this.messageServiceData = jsonObject;
        }
    }

    public String getChatName() throws ResponseException {
        if (messageServiceData == null) throw new ResponseException("No service data");
        return messageServiceData.getString("chatName");
    }

    public static class Types {
        public static final String CHAT_CREATED = "chatCreated";

    }

}
