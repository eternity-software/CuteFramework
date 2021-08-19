package ru.etysoft.cuteframework.methods.account.Authentication;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class AuthenticationResponse extends ResponseHandler {

    public AuthenticationResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
    }



}
