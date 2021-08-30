package ru.etysoft.cuteframework.methods.friend.SendRequest;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class SendFriendRequestResponse extends ResponseHandler {

    public SendFriendRequestResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {

    }
}
