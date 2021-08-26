package ru.etysoft.cuteframework.methods.user.Get;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.Methods;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class GetUserResponse extends ResponseHandler {
    private String displayName, status, bio, id, onlineTime, avatarPath;
    public GetUserResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
        JSONObject jsonObject = getJsonResponse().getJSONObject(APIKeys.DATA).getJSONObject(APIKeys.USER);
        id = String.valueOf(jsonObject.getInt("id"));
        displayName = jsonObject.getString("displayName");
        if (!jsonObject.isNull("bioText")){
            bio = jsonObject.getString("bioText");
        }
        if (!jsonObject.isNull("statusText")){
            status = jsonObject.getString("statusText");
        }
        avatarPath = String.valueOf(jsonObject.getString(APIKeys.AVATAR_PATH));
        onlineTime = String.valueOf(jsonObject.getInt("onlineTime"));
    }

    public String getAvatarPath() {
        return Methods.mediaDomain + avatarPath;
    }

    public String getStatus(){
        if (status == null) return "";
        return status;
    }

    public String getId() {
        if (id == null) return "";
        return id;
    }

    public String getBio() {
        if (bio == null)  return "";
        return bio;
    }

    public String getDisplayName() {
        if (displayName == null)  return "";
        return displayName;
    }

    public String getOnlineTime() throws ResponseException{
        if (onlineTime == null) throw new ResponseException("onlineTime is null");
        return onlineTime;
    }

}
