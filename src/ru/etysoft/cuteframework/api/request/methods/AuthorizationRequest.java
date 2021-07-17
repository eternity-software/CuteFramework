package ru.etysoft.cuteframework.api.request.methods;

import ru.etysoft.cuteframework.api.request.APIMethods;
import ru.etysoft.cuteframework.api.request.Pair;
import ru.etysoft.cuteframework.api.request.RequestHolder;
import ru.etysoft.cuteframework.api.response.APIKeys;
import ru.etysoft.cuteframework.api.response.methods.AuthorizationResponseHandler;
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


    public AuthorizationResponseHandler execute() throws ResponseException {
        Request request = makeRequest();
        return new AuthorizationResponseHandler(request.processAPI(), request.getFormattedURL());
    }



}
