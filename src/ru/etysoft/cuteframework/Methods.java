package ru.etysoft.cuteframework;


import ru.etysoft.cuteframework.methods.account.Confirmation.ConfirmCodeRequest;
import ru.etysoft.cuteframework.methods.account.Confirmation.ConfirmCodeResponse;
import ru.etysoft.cuteframework.methods.account.Confirmation.ConfirmationRequest;
import ru.etysoft.cuteframework.methods.account.Confirmation.ConfirmationResponse;
import ru.etysoft.cuteframework.methods.account.EditDisplayName.EditRequest;
import ru.etysoft.cuteframework.methods.account.EditDisplayName.EditResponse;
import ru.etysoft.cuteframework.methods.account.Login.LoginRequest;
import ru.etysoft.cuteframework.methods.account.GetAccount.GetAccountRequest;
import ru.etysoft.cuteframework.methods.account.Registration.RegistrationRequest;
import ru.etysoft.cuteframework.methods.account.Login.LoginResponse;
import ru.etysoft.cuteframework.methods.account.GetAccount.GetAccountResponse;
import ru.etysoft.cuteframework.methods.account.Registration.RegistrationResponse;
import ru.etysoft.cuteframework.exceptions.ResponseException;

public class Methods {

    public static String domain = "https://api.mcute.ru/";
    public static String mainDomain = "https://mcute.ru/";
    public static String options = "&v=b001";

    public static LoginResponse authorize(String login, String password) throws ResponseException {
        return (new LoginRequest(login, password)).execute();
    }

    public static RegistrationResponse register(String login, String email, String password, String display_name) throws ResponseException {
        return (new RegistrationRequest(login, email, password, display_name)).execute();
    }

    public static GetAccountResponse getInfo(String sessionKey) throws ResponseException {
        return (new GetAccountRequest(sessionKey).execute());
    }
    public static EditResponse editDisplayName(String token, String newName) throws ResponseException{
        return (new EditRequest(token,newName).execute());
    }
    public static ConfirmCodeResponse sendConfirmCode(String token) throws ResponseException{
        return (new ConfirmCodeRequest(token).execute());
    }
    public static ConfirmationResponse confirmation(String token, int code) throws ResponseException{
        return (new ConfirmationRequest(token, code).execute());
    }



    public static void setApiVersion(String apiVersion) {

        options = "&v=" + apiVersion;
    }


}
