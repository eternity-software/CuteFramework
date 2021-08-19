package ru.etysoft.cuteframework.methods.account.GetAccount;

import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Request;

public class GetAccountRequest extends RequestHolder {
    private String token;

    public GetAccountRequest(String token){
        super(APIMethods.Account.AUTHENTICATION);

        this.token = token;
        setParams(Pair.make(APIKeys.TOKEN, token));
    }

    public String getToken() {
        return token;
    }

    public GetAccountResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new GetAccountResponse(request.processAPI(), request.getFormattedURL());
    }


}
