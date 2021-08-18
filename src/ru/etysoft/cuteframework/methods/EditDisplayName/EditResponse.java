package ru.etysoft.cuteframework.methods.EditDisplayName;

import org.json.JSONException;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class EditResponse extends ResponseHandler {
    private String status;

    public EditResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
        status = getJsonResponse().getString(APIKeys.DATA);
    }

    public String getStatus() throws ResponseException {
        if(status == null) throw new ResponseException("Status is null!");
        return status;
    }
}
