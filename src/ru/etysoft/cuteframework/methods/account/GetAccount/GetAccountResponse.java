package ru.etysoft.cuteframework.methods.account.GetAccount;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.Methods;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.responses.ResponseHandler;
import ru.etysoft.cuteframework.responses.errors.ErrorHandler;

public class GetAccountResponse extends ResponseHandler {

    private String confirm, displayName, login, email, password, status, bio, avatarPath, coverPath;
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
        displayName = account.getString(APIKeys.DISPLAY_NAME);
        if(!account.isNull(APIKeys.STATUS))
        {
            status = account.getString(APIKeys.STATUS);
        }
        else
        {
            status = "";
        }

        if(!account.isNull(APIKeys.BIO))
        {
            bio = account.getString(APIKeys.BIO);
        }
        else
        {
            bio = "";
        }
        if (!account.isNull(APIKeys.COVER_PATH)){
            coverPath = String.valueOf(account.getString(APIKeys.COVER_PATH));
        }

        if (!account.isNull("avatarPath")){
            avatarPath = account.getString("avatarPath");
        }
    }

    public String getCoverPath() {
        if(coverPath == null) {
            return null;
        }
        return Methods.mediaDomain + coverPath;
    }

    public String getAvatarPath() {
        if(avatarPath == null) {
           return null;
        }
        return Methods.mediaDomain + avatarPath;
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
        return displayName;
    }

    public String getBio() {
        if(bio == null)
        {
            bio = "";
        }
        return bio;
    }

    public String getStatus() {
        if(status == null)
        {
            status = "";
        }
        return status;
    }

    @Override
    public ErrorHandler getErrorHandler() throws JSONException {
        return super.getErrorHandler();
    }
}
