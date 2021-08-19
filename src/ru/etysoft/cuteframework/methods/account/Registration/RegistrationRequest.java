package ru.etysoft.cuteframework.methods.account.Registration;

import ru.etysoft.cuteframework.Methods;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.requests.POST;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;

import java.util.HashMap;

public class RegistrationRequest extends RequestHolder {

    private String login;
    private String email;
    private String password;
    private String displayName;

    public RegistrationRequest(String login, String email, String password, String displayName) {
        super(APIMethods.Account.REGISTRATION);
        this.login = login;
        this.email = email;
        this.password = password;
        this.displayName = displayName;
    }

    public RegistrationResponse execute() throws ResponseException {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put(APIKeys.LOGIN, login);
        hashMap.put(APIKeys.EMAIL, email);
        hashMap.put(APIKeys.PASSWORD, password);
        hashMap.put(APIKeys.DISPLAY_NAME, displayName);

        String url = Methods.domain + APIMethods.Account.REGISTRATION;

        String response = POST.execute(url, hashMap, APIMethods.Account.REGISTRATION);
        System.out.println(response);
        return new RegistrationResponse(response, url);
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getDisplayName() { return displayName;
    }
}

