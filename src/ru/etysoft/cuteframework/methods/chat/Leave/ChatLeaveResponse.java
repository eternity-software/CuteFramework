package ru.etysoft.cuteframework.methods.chat.Leave;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class ChatLeaveResponse extends ResponseHandler {

    public ChatLeaveResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {

    }
}
