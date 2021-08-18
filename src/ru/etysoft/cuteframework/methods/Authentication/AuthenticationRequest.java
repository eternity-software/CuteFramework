package ru.etysoft.cuteframework.methods.Authentication;

import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.GetAccount.GetAccountResponse;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class AuthenticationRequest extends RequestHolder {
    private String token;
    public AuthenticationRequest(String token) {
        super(APIMethods.AUTHENTICATION);
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
