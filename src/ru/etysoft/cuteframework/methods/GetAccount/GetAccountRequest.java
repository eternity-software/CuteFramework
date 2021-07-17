package ru.etysoft.cuteframework.methods.GetAccount;

import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.methods.GetAccount.GetAccountResponse;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Request;

public class GetAccountRequest extends RequestHolder {
    private String sessionKey;

    public GetAccountRequest(String sessionKey){
        super(APIMethods.GETINFORNATION);

        this.sessionKey = sessionKey;
        setParams(Pair.make(APIKeys.SESSION, sessionKey));
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public GetAccountResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new GetAccountResponse(request.processAPI(), request.getFormattedURL());
    }


}
