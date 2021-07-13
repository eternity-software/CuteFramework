package ru.etysoft.cuteframework.api.request.methods;

import ru.etysoft.cuteframework.api.request.APIMethods;
import ru.etysoft.cuteframework.api.request.Pair;
import ru.etysoft.cuteframework.api.request.RequestHolder;
import ru.etysoft.cuteframework.api.response.APIKeys;
import ru.etysoft.cuteframework.api.response.methods.AuthorizationResponseHandler;
import ru.etysoft.cuteframework.api.response.methods.RegistrationResponseHandler;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Request;

public class RegistrationRequest extends RequestHolder {

    private String login;
    private String email;
    private String password;

    public RegistrationRequest(String login, String email, String password) {
        super(APIMethods.REGISTRATION);
        this.login = login;
        this.email = email;
        this.password = password;
        setParams(Pair.make(APIKeys.LOGIN, login),
                Pair.make(APIKeys.EMAIL, email),
                Pair.make(APIKeys.PASSWORD, password));
    }

    public RegistrationResponseHandler execute() throws ResponseException {
        Request request = makeRequest();
        return new RegistrationResponseHandler(request.processAPI(), request.getFormattedURL());
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


}
