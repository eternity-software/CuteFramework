package ru.etysoft.cuteframework.methods.chat;

import org.json.JSONException;
import org.json.JSONObject;

public class ServiceData {
    private JSONObject messageServiceData;
    private Boolean ismessagenull;
    public ServiceData(String messageServiceData){
        if(!messageServiceData.equals("0")){
            ismessagenull = false;
            JSONObject jsonObject = new JSONObject(messageServiceData);
            this.messageServiceData = jsonObject;
        }
        else {
            ismessagenull = true;
        }
    }

    public String getChatName(){
        if (!ismessagenull){
            return messageServiceData.getString("chatName");
        }
        return "NO_SERVICE_MESSAGE";

    }
    public static class Types
    {
        public static final String CHAT_CREATED = "chatCreated";

    }

}
