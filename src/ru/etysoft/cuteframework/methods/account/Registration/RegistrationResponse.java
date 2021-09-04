package ru.etysoft.cuteframework.methods.account.Registration;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.responses.ResponseHandler;
import ru.etysoft.cuteframework.exceptions.ResponseException;

public class RegistrationResponse extends ResponseHandler {

    private String token, id, expires;
    public RegistrationResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
        JSONObject jsonObject = getJsonResponse().getJSONObject(APIKeys.DATA);
        token = jsonObject.getString(APIKeys.TOKEN);
        id = String.valueOf(jsonObject.getInt(APIKeys.ID));
        expires = String.valueOf(jsonObject.getInt(APIKeys.EXPIRES));
    }


    public String getToken() throws ResponseException {
        if(token == null) throw new ResponseException("token is null");
        return token;
    }

    public String getId() throws ResponseException{
        if(id == null) throw new ResponseException("id is null");
        return id;
    }

    public String getExpires() throws ResponseException{
        if(expires == null) throw new ResponseException("expires is null");
        return expires;
    }
}
