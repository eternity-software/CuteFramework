package ru.etysoft.cuteframework.api.response.methods;


import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.api.response.ResponseHandler;

public class InformationResponseHandler extends ResponseHandler {

    private String active, display_name, display_surname;
    private int id;

    public InformationResponseHandler(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);

    }

    @Override
    public void onSuccess() {
        JSONObject data = getJsonResponse().getJSONObject("data");
        JSONObject account = data.getJSONObject("account");
        active = account.getString("active");
        id = account.getInt("id");
        display_name = account.getString("display_name");

    }
    public String id(){
        return String.valueOf(id);
    }

    public String getActive() {
        return active;
    }

    public String getDisplay_name() {
        return display_name;
    }


}
