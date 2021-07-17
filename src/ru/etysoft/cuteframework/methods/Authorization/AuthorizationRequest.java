package ru.etysoft.cuteframework.methods.Authorization;

import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.methods.Authorization.AuthorizationResponse;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Request;

public class AuthorizationRequest extends RequestHolder {

    private String login;
    private String password;

    public AuthorizationRequest(String login, String password) {
        super(APIMethods.AUTHORIZATION);
        this.login = login;
        this.password = password;
        setParams(Pair.make(APIKeys.LOGIN, login),
                Pair.make(APIKeys.PASSWORD, password));
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


    public AuthorizationResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new AuthorizationResponse(request.processAPI(), request.getFormattedURL());
    }



}
