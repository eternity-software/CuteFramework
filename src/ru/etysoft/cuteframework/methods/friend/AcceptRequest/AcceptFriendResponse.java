package ru.etysoft.cuteframework.methods.friend.AcceptRequest;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class AcceptFriendResponse extends ResponseHandler {

    public AcceptFriendResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {

    }
}
