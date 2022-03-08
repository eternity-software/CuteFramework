package ru.etysoft.cuteframework.methods;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.Response;

public class BlankResponse extends Response {
    public BlankResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {

    }
}
