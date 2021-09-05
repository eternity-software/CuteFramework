package ru.etysoft.cuteframework.methods.account.Authentication;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class AuthenticationResponse extends ResponseHandler {

    private String token, id, expires, confirm;
    public AuthenticationResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
        JSONObject jsonObject = getJsonResponse().getJSONObject(APIKeys.DATA);
        token = jsonObject.getString(APIKeys.TOKEN);
        id = String.valueOf(jsonObject.getInt(APIKeys.ID));
        expires = String.valueOf(jsonObject.getInt(APIKeys.EXPIRES));
        confirm = jsonObject.getString(APIKeys.CONFIRM);
    }

    public String getToken() {
        return token;
    }

    public String getId() {
        return id;
    }

    public String getExpires() {
        return expires;
    }

    public String getConfirm() {
        return confirm;
    }
}
