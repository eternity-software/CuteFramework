package ru.etysoft.cuteframework.methods.user.Get;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.user.User;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class GetUserResponse extends ResponseHandler {
    private User user,
    coverPath;

    private int friendId;
    private boolean isFriend;
    public GetUserResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
        JSONObject jsonObject = getJsonResponse().getJSONObject(APIKeys.DATA).getJSONObject(APIKeys.USER);

        user = new User(jsonObject);
    }

    public int getFriendId() {
        return friendId;
    }

    public User getUser() {
        return user;
    }
}
