package ru.etysoft.cuteframework.methods.account;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.consts.APIMethods;
import ru.etysoft.cuteframework.exceptions.NoSuchValueException;
import ru.etysoft.cuteframework.exceptions.NotCachedException;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.models.Device;
import ru.etysoft.cuteframework.requests.POST;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.storage.Cache;

import java.sql.SQLException;

public class SignInRequest extends RequestHolder {
    public SignInRequest(String login, String password, Device device) throws SQLException, NotCachedException {
        super(APIMethods.Authorization.SIGN_IN);


        addBody(Pair.make(APIKeys.Account.LOGIN, login),
                Pair.make(APIKeys.Token.DEVICE, device.getJsonModel()),
                Pair.make(APIKeys.Account.PASSWORD, password));
    }

    public Response execute() throws ResponseException {
        return new Response(POST.execute(this), getUrl());
    }

    public static class Response extends ru.etysoft.cuteframework.responses.Response {

        private String accessToken, refreshToken;
        private static LoginCallback loginCallback;

        public static void setLoginCallback(LoginCallback loginCallback) {
            if(Response.loginCallback != null) return;
            Response.loginCallback = loginCallback;
        }

        public Response(String jsonResponse, String url) throws JSONException {
            super(jsonResponse, url);
        }

        @Override
        public void onSuccess() {

            accessToken = getJsonResponse().getString(APIKeys.Token.ACCESS);
            refreshToken = getJsonResponse().getString(APIKeys.Token.REFRESH);

            try {
                Cache.getUserAccount().setAccessToken(accessToken);
                Cache.getUserAccount().setSessionId(refreshToken);
            } catch (Exception e) {
                e.printStackTrace();
            }

            loginCallback.onLogin(accessToken, refreshToken);
        }

        public String getAccessToken() {
            return accessToken;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public interface LoginCallback
        {
            void onLogin(String accessToken, String refreshToken);
        }
    }

}
