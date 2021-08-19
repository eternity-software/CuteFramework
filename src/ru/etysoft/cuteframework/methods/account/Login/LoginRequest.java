package ru.etysoft.cuteframework.methods.account.Login;

import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Request;

public class LoginRequest extends RequestHolder {

    private String login;
    private String password;

    public LoginRequest(String login, String password) {
        super(APIMethods.Account.LOGIN);
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


    public LoginResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new LoginResponse(request.processAPI(), request.getFormattedURL());
    }



}
