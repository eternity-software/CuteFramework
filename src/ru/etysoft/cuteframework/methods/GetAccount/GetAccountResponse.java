package ru.etysoft.cuteframework.methods.GetAccount;


import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class GetAccountResponse extends ResponseHandler {

    private String confirm, display_name, login, email, password;
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

    }
    public String id(){
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

    public String getDisplay_name() {
        return display_name;
    }


}
