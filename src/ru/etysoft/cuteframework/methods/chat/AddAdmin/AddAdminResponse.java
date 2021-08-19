package ru.etysoft.cuteframework.methods.chat.AddAdmin;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class AddAdminResponse extends ResponseHandler {

    public AddAdminResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
    }
}
