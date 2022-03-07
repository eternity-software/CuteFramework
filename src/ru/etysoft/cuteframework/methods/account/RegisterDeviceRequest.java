package ru.etysoft.cuteframework.methods.account;

import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.consts.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

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
}
