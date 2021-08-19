package ru.etysoft.cuteframework.methods.chat.MakeAdmin;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class MakeAdminResponse extends ResponseHandler {
    public MakeAdminResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {

    }
}
