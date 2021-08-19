package ru.etysoft.cuteframework.methods.chat.UnblockMember;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class UnblockMemberResponse extends ResponseHandler {
    public UnblockMemberResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {

    }
}
