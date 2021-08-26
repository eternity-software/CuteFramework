package ru.etysoft.cuteframework.methods.user.Get;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class GetUserResponse extends ResponseHandler {
    private String displayName, status, bio, id, onlineTime;
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
        onlineTime = String.valueOf(jsonObject.getInt("onlineTime"));
    }

    public String getStatus() throws ResponseException {
        if (status==null) throw new ResponseException("status is null");
        return status;
    }

    public String getId() throws ResponseException{
        if (id==null) throw new ResponseException("id is null");
        return id;
    }

    public String getBio() throws ResponseException{
        if (bio==null) throw new ResponseException("bio is null");
        return bio;
    }

    public String getDisplayName() throws ResponseException{
        if (displayName==null) throw new ResponseException("displayName is null");
        return displayName;
    }

    public String getOnlineTime() throws ResponseException{
        if (onlineTime==null) throw new ResponseException("onlineTime is null");
        return onlineTime;
    }

}
