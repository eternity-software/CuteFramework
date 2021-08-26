package ru.etysoft.cuteframework.methods.account.ChangeAvatar;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class ChangeAvatarResponse extends ResponseHandler {
    public ChangeAvatarResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }
    @Override
    public void onSuccess() {
    }
}
