package ru.etysoft.cuteframework.methods.Confirmation;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class ConfirmationResponse extends ResponseHandler {
    public ConfirmationResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {

    }
}
