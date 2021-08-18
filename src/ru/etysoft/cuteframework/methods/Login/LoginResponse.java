package ru.etysoft.cuteframework.methods.Login;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.responses.ResponseHandler;
import ru.etysoft.cuteframework.exceptions.ResponseException;

public class LoginResponse extends ResponseHandler {

    private String sessionKey;
    private String accountId;
    private int expires;

    public LoginResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
        JSONObject jsonObject = getJsonResponse().getJSONObject(APIKeys.DATA);
        sessionKey = jsonObject.getString(APIKeys.SESSION_KEY);
        accountId = jsonObject.getString(APIKeys.ACCOUNT_ID);
        expires = jsonObject.getInt(APIKeys.EXPIRES);
    }

    public String getSessionKey() throws ResponseException {
        if(sessionKey == null) throw new ResponseException("Session is null!");
        return sessionKey;
    }
}
