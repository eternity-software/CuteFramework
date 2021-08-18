package ru.etysoft.cuteframework.methods.Confirmation;

import org.json.JSONException;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class ConfirmCodeResponse extends ResponseHandler {
    private String status;

    public ConfirmCodeResponse(String jsonResponse, String url) throws JSONException {
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
