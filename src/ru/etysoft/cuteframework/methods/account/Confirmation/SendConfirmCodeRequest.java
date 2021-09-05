package ru.etysoft.cuteframework.methods.account.Confirmation;

import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class SendConfirmCodeRequest extends RequestHolder {
    private String token;
    public SendConfirmCodeRequest(String token){
        super(APIMethods.Account.SEND_CONFIRMATION_CODE);
        this.token = token;
        setParams(Pair.make(APIKeys.TOKEN, token));
    }


    public ConfirmCodeResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new ConfirmCodeResponse(request.processAPI(), request.getFormattedURL());
    }
}
