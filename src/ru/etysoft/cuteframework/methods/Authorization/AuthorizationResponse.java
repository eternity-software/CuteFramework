package ru.etysoft.cuteframework.methods.Authorization;

import org.json.JSONException;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.responses.ResponseHandler;
import ru.etysoft.cuteframework.exceptions.ResponseException;

public class AuthorizationResponse extends ResponseHandler {

    private String sessionKey;

    public AuthorizationResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
        sessionKey = getJsonResponse().getJSONObject(APIKeys.DATA).getString(APIKeys.SESSION_KEY);
    }

    public String getSessionKey() throws ResponseException {
        if(sessionKey == null) throw new ResponseException("Session is null!");
        return sessionKey;
    }
}
