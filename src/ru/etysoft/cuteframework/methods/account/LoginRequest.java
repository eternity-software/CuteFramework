package ru.etysoft.cuteframework.methods.account;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.consts.APIMethods;
import ru.etysoft.cuteframework.exceptions.NoSuchValueException;
import ru.etysoft.cuteframework.exceptions.NotCachedException;
import ru.etysoft.cuteframework.exceptions.OneRowOperationException;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.responses.Response;
import ru.etysoft.cuteframework.storage.Cache;

import java.sql.SQLException;

public class LoginRequest extends RequestHolder {
    public LoginRequest(String login, String password) throws SQLException, NotCachedException {
        super(APIMethods.Account.LOGIN);
        setParams(Pair.make(APIKeys.Account.LOGIN, login),
                Pair.make(APIKeys.Account.DEVICE_ID, Cache.getUserAccount().getDeviceId()),
                Pair.make(APIKeys.Account.PASSWORD, password));
    }

    public LoginResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new LoginResponse(request.executeAPI(), request.getFormattedURL());
    }

    public static class LoginResponse extends Response {

        private String id, token;
        private long expiresIn;
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
            id = jsonObject.getString(APIKeys.Account.ACCOUNT_ID);
            expiresIn = jsonObject.getLong(APIKeys.Account.EXPIRES_IN);

            try {
                Cache.getUserAccount().setToken(token);
            } catch (Exception e) {
                e.printStackTrace();
            }

            loginCallback.onLogin(token, id, expiresIn);
        }

        public String getId() throws NoSuchValueException {
            checkNotNull(id);
            return id;
        }

        public long getExpiresIn() throws NoSuchValueException {
            checkNotNull(expiresIn);
            return expiresIn;
        }

        public String getToken() throws NoSuchValueException {
            checkNotNull(token);
            return token;
        }

        public interface LoginCallback
        {
            void onLogin(String token, String id, long expiresIn);
        }
    }

}
