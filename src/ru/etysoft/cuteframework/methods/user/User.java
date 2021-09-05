package ru.etysoft.cuteframework.methods.user;

import org.json.JSONObject;
import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.data.APIKeys;


public class User {
    private String onlineTime, bioText, statusText, displayName, id,
            login, avatar, cover;
    private boolean isFriend;

    public User(String onlineTime, String bioText, String statusText, String displayName, String id, String login, String avatar, String cover, boolean isFriend) {
        this.onlineTime = onlineTime;
        this.bioText = bioText;
        this.statusText = statusText;
        this.displayName = displayName;
        this.id = id;
        this.login = login;
        this.avatar = avatar;
        this.cover = cover;
        this.isFriend = isFriend;
    }

    public User(JSONObject jsonObject) {
        if (jsonObject.has(APIKeys.User.BIO)) {
            bioText = jsonObject.getString(APIKeys.User.BIO);
        }

        if (jsonObject.has(APIKeys.User.STATUS)) {
            statusText = jsonObject.getString(APIKeys.User.STATUS);
        }

        if (jsonObject.has(APIKeys.User.LOGIN)) {
            login = jsonObject.getString(APIKeys.User.LOGIN);
        }

        if (jsonObject.has(APIKeys.User.AVATAR)) {
            avatar = String.valueOf(jsonObject.getString(APIKeys.User.AVATAR));
        }

        if (jsonObject.has(APIKeys.COVER)) {
            cover = String.valueOf(jsonObject.getString(APIKeys.COVER));
        }

        if (jsonObject.has(APIKeys.IS_FRIEND)) {
            isFriend = jsonObject.getBoolean(APIKeys.IS_FRIEND);
        }


        displayName = jsonObject.getString(APIKeys.User.DISPLAY_NAME);
        id = String.valueOf(jsonObject.getInt(APIKeys.User.ID));
        onlineTime = String.valueOf(jsonObject.getInt(APIKeys.User.ONLINE_TIME));
    }

    public String getCover() {
        return CuteFramework.mediaDomain + cover;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatar() {
        return CuteFramework.mediaDomain + avatar;
    }

    public String getBioText() {
        return bioText;
    }

    public String getDisplayName() {
        return displayName;
    }

    public long getId() {
        return Long.parseLong(id);
    }

    public String getOnlineTime() {
        return onlineTime;
    }

    public String getStatusText() {
        return statusText;
    }

    public boolean isFriend() {
        return isFriend;
    }
}
