package ru.etysoft.cuteframework.legacy.methods.account.Login;

import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.Logger;
import ru.etysoft.cuteframework.legacy.data.APIMethods;
import ru.etysoft.cuteframework.requests.POST;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.legacy.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;

import java.util.HashMap;

public class LoginRequest extends RequestHolder {

    private String login;
    private String password;

    public LoginRequest(String login, String password) {
        super(APIMethods.Account.LOGIN);
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


    public LoginResponse execute() throws ResponseException {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put(APIKeys.LOGIN, login);
        hashMap.put(APIKeys.PASSWORD, password);

        String url = CuteFramework.API_DOMAIN + APIMethods.Account.LOGIN;

        String response = POST.execute(url, hashMap, getMethod());
        Logger.logResponse(response, getMethod());
        return new LoginResponse(response, url);
    }



}
