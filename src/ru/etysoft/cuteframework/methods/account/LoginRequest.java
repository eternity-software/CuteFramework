package ru.etysoft.cuteframework.methods.account;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.consts.APIMethods;
import ru.etysoft.cuteframework.exceptions.NoSuchValueException;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.responses.ResponseHandler;

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

    public static class LoginResponse extends ResponseHandler {

        private String id, expiresIn, token;
        private static LoginCallback loginCallback;

        public static void setLoginCallback(LoginCallback loginCallback) {
            if(LoginResponse.loginCallback != null) return;
            LoginResponse.loginCallback = loginCallback;
        }

        public LoginResponse(String jsonResponse, String url) throws JSONException {
            super(jsonResponse, url);
        }

        @Override
        public void onSuccess() {
            JSONObject jsonObject = getJsonResponse().getJSONObject(ru.etysoft.cuteframework.consts.APIKeys.Response.DATA);
            token = jsonObject.getString(ru.etysoft.cuteframework.consts.APIKeys.Account.TOKEN);
            id = jsonObject.getString(ru.etysoft.cuteframework.consts.APIKeys.Account.ID);
            expiresIn = jsonObject.getString(APIKeys.Account.EXPIRES_IN);
            loginCallback.onLogin(token, id, expiresIn);
        }

        public String getId() throws NoSuchValueException {
            checkNotNull(id);
            return id;
        }

        public String getExpiresIn() throws NoSuchValueException {
            checkNotNull(expiresIn);
            return expiresIn;
        }

        public String getToken() throws NoSuchValueException {
            checkNotNull(token);
            return token;
        }

        public interface LoginCallback
        {
            void onLogin(String token, String id, String expiresIn);
        }
    }

}
