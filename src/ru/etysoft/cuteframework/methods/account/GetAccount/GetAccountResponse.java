package ru.etysoft.cuteframework.methods.account.GetAccount;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.data.APIKeys;
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
        confirm = data.getString(APIKeys.CONFIRM);
        id = data.getInt(APIKeys.ID);
        login = data.getString(APIKeys.LOGIN);
        email = data.getString(APIKeys.EMAIL);
        password = data.getString(APIKeys.PASSWORD);
        display_name = data.getString(APIKeys.DISPLAY_NAME);
        status = data.getString(APIKeys.STATUS);
        bio = data.getString(APIKeys.BIO);
        if (data.isNull("avatarPath")){
            avatarPath = data.getString("avatarPath");
        }
    }

    public String getAvatarPath() {
        return avatarPath;
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
