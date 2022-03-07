package ru.etysoft.cuteframework.methods.account;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.consts.APIMethods;
import ru.etysoft.cuteframework.exceptions.NoSuchValueException;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class RegisterDeviceRequest extends RequestHolder {
    public RegisterDeviceRequest(String name, String type) {
        super(APIMethods.Account.REGISTER_DEVICE);
        setParams(Pair.make(APIKeys.Account.TYPE, type),
                Pair.make(APIKeys.Account.NAME, name));
    }

    public RegisterDeviceResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new RegisterDeviceResponse(makeRequest().processAPI(), request.getFormattedURL());
    }

    public static class RegisterDeviceResponse extends ResponseHandler {

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
}
