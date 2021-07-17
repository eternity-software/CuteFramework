package ru.etysoft.cuteframework.methods.Registration;

import org.json.JSONException;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.responses.ResponseHandler;
import ru.etysoft.cuteframework.exceptions.ResponseException;

public class RegistrationResponse extends ResponseHandler {

    private String sessionKey;

    public RegistrationResponse(String jsonResponse, String url) throws JSONException {
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
