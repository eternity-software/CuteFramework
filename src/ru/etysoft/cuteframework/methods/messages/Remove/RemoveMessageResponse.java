package ru.etysoft.cuteframework.methods.messages.Remove;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class RemoveMessageResponse extends ResponseHandler {
    public RemoveMessageResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {

    }
}
