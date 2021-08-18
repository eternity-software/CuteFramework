package ru.etysoft.cuteframework.methods.Registration;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.responses.ResponseHandler;
import ru.etysoft.cuteframework.exceptions.ResponseException;

public class RegistrationResponse extends ResponseHandler {

    private String sessionKey;
    private int accountId;
    private long expires;
    public RegistrationResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
        JSONObject jsonObject = getJsonResponse().getJSONObject(APIKeys.DATA);
        sessionKey = jsonObject.getString(APIKeys.SESSION_KEY);
        accountId = jsonObject.getInt(APIKeys.ACCOUNT_ID);
        expires = jsonObject.getInt(APIKeys.EXPIRES);
    }


    public String getSessionKey() throws ResponseException {
        if(sessionKey == null) throw new ResponseException("Session key is null");
        return sessionKey;
    }

}
