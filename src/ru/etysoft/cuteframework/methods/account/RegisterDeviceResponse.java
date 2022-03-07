package ru.etysoft.cuteframework.methods.account;

import org.json.JSONException;
import org.json.JSONObject;

import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.exceptions.NoSuchValueException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class RegisterDeviceResponse extends ResponseHandler {

    private String deviceId;

    public RegisterDeviceResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
        JSONObject jsonObject = getJsonResponse().getJSONObject(APIKeys.Response.DATA);
        deviceId = jsonObject.getString(APIKeys.Account.DEVICE_ID);
    }

    public String getDeviceId() throws NoSuchValueException {
        if(deviceId == null) throw new NoSuchValueException();
        return deviceId;
    }
}
