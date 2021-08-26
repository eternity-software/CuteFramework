package ru.etysoft.cuteframework.methods.user;

import org.json.JSONObject;

public class User {
    private String onlineTime, bioText, statusText, displayName, id;
    public User(JSONObject jsonObject){
        onlineTime = String.valueOf(jsonObject.getInt("onlineTime"));
        if (!jsonObject.isNull("bioText")){
            bioText = jsonObject.getString("bioText");
        }
        if (!jsonObject.isNull("statusText")){
            statusText = jsonObject.getString("statusText");
        }
        displayName = jsonObject.getString("displayName");
        id = String.valueOf(jsonObject.getInt("id"));
    }

    public String getBioText() {
        return bioText;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getId() {
        return id;
    }

    public String getOnlineTime() {
        return onlineTime;
    }

    public String getStatusText() {
        return statusText;
    }
}
