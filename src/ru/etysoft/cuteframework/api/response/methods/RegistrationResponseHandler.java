package ru.etysoft.cuteframework.api.response.methods;

import org.json.JSONException;
import ru.etysoft.cuteframework.api.response.APIKeys;
import ru.etysoft.cuteframework.api.response.ResponseHandler;
import ru.etysoft.cuteframework.exceptions.ResponseException;

public class RegistrationResponseHandler extends ResponseHandler {

    private String sessionKey;

    public RegistrationResponseHandler(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
        sessionKey = getJsonResponse().getJSONObject(APIKeys.DATA).getString(APIKeys.SESSION_KEY);
    }


    public String getSessionKey() throws ResponseException {
        if(sessionKey == null) throw new ResponseException("Session key is null");
        return sessionKey;
    }

}
