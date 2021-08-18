package ru.etysoft.cuteframework.methods.Registration;

import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.requests.POST;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Request;

import java.util.HashMap;

public class RegistrationRequest extends RequestHolder {

    private String login;
    private String email;
    private String password;
    private String display_name;

    public RegistrationRequest(String login, String email, String password, String display_name) {
        super(APIMethods.REGISTRATION);
        this.login = login;
        this.email = email;
        this.password = password;
        this.display_name = display_name;
    }

    public RegistrationResponse execute() throws ResponseException {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put(APIKeys.LOGIN, login);
        hashMap.put(APIKeys.EMAIL, email);
        hashMap.put(APIKeys.PASSWORD, password);
        hashMap.put(APIKeys.DISPLAY_NAME, display_name);
        String response = POST.execute("https://api.mcute.ru/account/create", hashMap, "create");
        System.out.println(response);
        return new RegistrationResponse(response, response);
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

    public String getDisplay_name() { return display_name;
    }
}

