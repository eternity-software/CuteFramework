package ru.etysoft.cuteframework.methods.chat.BlockMember;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class BlockMemberResponse extends ResponseHandler {
    public BlockMemberResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {

    }
}