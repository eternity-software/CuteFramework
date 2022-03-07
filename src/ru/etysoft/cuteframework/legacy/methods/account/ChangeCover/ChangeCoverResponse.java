package ru.etysoft.cuteframework.legacy.methods.account.ChangeCover;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class ChangeCoverResponse extends ResponseHandler {
    public ChangeCoverResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }
    @Override
    public void onSuccess() {
    }
}
