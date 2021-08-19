package ru.etysoft.cuteframework.methods.account.Confirmation;

import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class ConfirmationRequest extends RequestHolder {
    private String token;
    private String code;
    public ConfirmationRequest(String token, int code) {
        super(APIMethods.Account.CONFIRMATION);
        this.code = String.valueOf(code);
        this.token = token;
        setParams(Pair.make(APIKeys.TOKEN, this.token),
                Pair.make(APIKeys.CODE, this.code));
    }


    public ConfirmationResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new ConfirmationResponse(request.processAPI(), request.getFormattedURL());
    }
}
