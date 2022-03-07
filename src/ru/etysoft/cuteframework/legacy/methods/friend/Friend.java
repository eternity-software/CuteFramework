package ru.etysoft.cuteframework.legacy.methods.friend;

import org.json.JSONObject;
import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.legacy.data.APIKeys;

public class Friend {

    private String displayName, avatarPath, onlineTime;
    private int accountId, friendId, requestId;
    private boolean isRequest = false;

    public Friend(String displayName, String avatarPath, String onlineTime, int accountId, int friendId, int requestId, boolean isRequest) {
        this.displayName = displayName;
        this.avatarPath = avatarPath;
        this.onlineTime = onlineTime;
        this.accountId = accountId;
        this.friendId = friendId;
        this.isRequest = isRequest;
        this.requestId = requestId;
    }

    public static Friend fromJSON(JSONObject jsonObject, boolean isRequest)
    {
        String avatarPath = null;
        if(!jsonObject.isNull(APIKeys.AVATAR))
        {
            avatarPath = jsonObject.getString(APIKeys.AVATAR);
        }
        String displayName = jsonObject.getString(APIKeys.DISPLAY_NAME);
        String onlineTime = jsonObject.getString(APIKeys.ONLINE_TIME);
        int accountId = jsonObject.getInt(APIKeys.ACCOUNT_ID);
        int friendId = 0, requestId = 0;
        if(!isRequest)
        {
           friendId = jsonObject.getInt(APIKeys.FRIEND_ID);
        }
        else
        {
            requestId = jsonObject.getInt(APIKeys.REQUEST_ID);
        }

        return new Friend(displayName, avatarPath, onlineTime, accountId, friendId, requestId, isRequest);
    }

    public boolean isRequest() {
        return isRequest;
    }

    public int getRequestId() {
        return requestId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getAvatarPath() {
        return CuteFramework.MEDIA_DOMAIN + avatarPath;
    }

    public String getOnlineTime() {
        return onlineTime;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getFriendId() {
        return friendId;
    }
}
