package ru.etysoft.cuteframework.legacy.methods.account.Confirmation;

import org.json.JSONException;
import ru.etysoft.cuteframework.legacy.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class ConfirmationResponse extends ResponseHandler {
    private String status;

    public ConfirmationResponse(String jsonResponse, String url) throws JSONException {
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
