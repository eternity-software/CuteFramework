package ru.etysoft.cuteframework.legacy.methods.account.Authentication;

import ru.etysoft.cuteframework.legacy.data.APIKeys;
import ru.etysoft.cuteframework.legacy.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class AuthenticationRequest extends RequestHolder {
    private String token;
    public AuthenticationRequest(String token) {
        super(APIMethods.Account.AUTHENTICATION);
        this.token = token;
        setParams(Pair.make(APIKeys.TOKEN, token));
    }

    public String getToken() {
        return token;
    }
    public AuthenticationResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new AuthenticationResponse(request.processAPI(), request.getFormattedURL());
    }
}
