package ru.etysoft.cuteframework.methods.account.GetAccount;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.Methods;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.responses.ResponseHandler;
import ru.etysoft.cuteframework.responses.errors.ErrorHandler;

public class GetAccountResponse extends ResponseHandler {

    private String confirm, display_name, login, email, password, status, bio, avatarPath;
    private int id;

    public GetAccountResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);

    }

    @Override
    public void onSuccess() {
        JSONObject data = getJsonResponse().getJSONObject(APIKeys.DATA);
        JSONObject account = data.getJSONObject(APIKeys.ACCOUNT);
        confirm = account.getString(APIKeys.CONFIRM);
        id = account.getInt(APIKeys.ID);
        login = account.getString(APIKeys.LOGIN);
        email = account.getString(APIKeys.EMAIL);
        password = account.getString(APIKeys.PASSWORD);
        display_name = account.getString(APIKeys.DISPLAY_NAME);
        status = account.getString(APIKeys.STATUS);
        bio = account.getString(APIKeys.BIO);
        if (!account.isNull("avatarPath")){
            avatarPath = account.getString("avatarPath");
        }
    }

    public String getAvatarPath() throws ResponseException {
        if(avatarPath == null) {
            throw new ResponseException("Avatar path is null fuuu");
        }
        return Methods.domain.substring(-1) + avatarPath;
    }

    public String getId(){
        return String.valueOf(id);
    }

    public String getConfirm() {
        return confirm;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public String getDisplayName() {
        return display_name;
    }

    public String getBio() {
        return bio;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public ErrorHandler getErrorHandler() throws JSONException {
        return super.getErrorHandler();
    }
}
