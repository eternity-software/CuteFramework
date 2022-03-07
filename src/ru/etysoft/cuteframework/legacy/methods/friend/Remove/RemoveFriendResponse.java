package ru.etysoft.cuteframework.legacy.methods.friend.Remove;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class RemoveFriendResponse extends ResponseHandler {

    public RemoveFriendResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {

    }
}
