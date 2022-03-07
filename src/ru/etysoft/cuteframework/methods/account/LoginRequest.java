package ru.etysoft.cuteframework.methods.account;

import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.consts.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class LoginRequest extends RequestHolder {
    public LoginRequest(String login, String password) {
        super(APIMethods.Account.LOGIN);
        setParams(Pair.make(APIKeys.Account.LOGIN, login),
                Pair.make(APIKeys.Account.PASSWORD, password));
    }

    public LoginResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new LoginResponse(request.processAPI(), request.getFormattedURL());
    }
}
