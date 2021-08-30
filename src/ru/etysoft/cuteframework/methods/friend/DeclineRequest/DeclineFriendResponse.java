package ru.etysoft.cuteframework.methods.friend.DeclineRequest;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class DeclineFriendResponse extends ResponseHandler {

    public DeclineFriendResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {

    }
}
