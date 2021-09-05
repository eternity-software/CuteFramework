package ru.etysoft.cuteframework.methods.account.GetAccount;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.responses.ResponseHandler;
import ru.etysoft.cuteframework.responses.errors.ErrorHandler;

public class GetAccountResponse extends ResponseHandler {

    private String confirm, displayName, login, email, status, bio, avatar, cover;
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
        displayName = account.getString(APIKeys.DISPLAY_NAME);
        status = account.getString(APIKeys.STATUS);
        bio = account.getString(APIKeys.BIO);
        if (!account.isNull(APIKeys.COVER)){
            cover = String.valueOf(account.getString(APIKeys.COVER));
        }

        if (!account.isNull(APIKeys.AVATAR)){
            avatar = account.getString(APIKeys.AVATAR);
        }
    }

    public String getCover() {
        if(cover == null) {
            return null;
        }
        return CuteFramework.mediaDomain + cover;
    }

    public String getAvatar() {
        if(avatar == null) {
           return null;
        }
        return CuteFramework.mediaDomain + avatar;
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

    public String getLogin() {
        return login;
    }

    public String getDisplayName() {
        return displayName;
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
