package ru.etysoft.cuteframework.api;


import ru.etysoft.cuteframework.api.request.methods.AuthorizationRequest;
import ru.etysoft.cuteframework.api.request.methods.RegistrationRequest;
import ru.etysoft.cuteframework.api.response.ResponseHandler;
import ru.etysoft.cuteframework.api.response.methods.AuthorizationResponseHandler;
import ru.etysoft.cuteframework.api.response.methods.RegistrationResponseHandler;
import ru.etysoft.cuteframework.exceptions.ResponseException;

public class Methods {

    public static String domain = "https://api.mcute.ru/";
    public static String mainDomain = "https://mcute.ru/";
    public static String options = "&v=b001";

    public static AuthorizationResponseHandler authorize(String login, String password) throws ResponseException {
        return (new AuthorizationRequest(login, password)).execute();
    }

    public static RegistrationResponseHandler register(String login, String email, String password) throws ResponseException {
        return (new RegistrationRequest(login, email, password)).execute();
    }


    public static void setApiVersion(String apiVersion) {
        options = "&v=" + apiVersion;
    }


}
