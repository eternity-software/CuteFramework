package ru.etysoft.cuteframework.legacy.methods.account.Edit;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class EditResponse extends ResponseHandler {

    public EditResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {

    }

}
