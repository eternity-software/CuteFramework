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
        confirm = data.getString(APIKeys.CONFIRM);
        id = data.getInt(APIKeys.ID);
        login = data.getString(APIKeys.LOGIN);
        email = data.getString(APIKeys.EMAIL);
        password = data.getString(APIKeys.PASSWORD);
        display_name = data.getString(APIKeys.DISPLAY_NAME);

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
