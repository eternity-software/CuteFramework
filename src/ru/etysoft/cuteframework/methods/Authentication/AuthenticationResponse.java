package ru.etysoft.cuteframework.methods.Authentication;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class AuthenticationResponse extends ResponseHandler {

    public AuthenticationResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);

    }

    @Override
    public void onSuccess() {
    }



}
