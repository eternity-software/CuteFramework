package ru.etysoft.cuteframework.methods.user.Search;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.user.User;
import ru.etysoft.cuteframework.responses.ResponseHandler;

import java.util.ArrayList;

public class SearchUserResponse extends ResponseHandler {
    private ArrayList<User> users;
    public SearchUserResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
        users = new ArrayList<>();
        JSONArray js_users = getJsonResponse().getJSONObject(APIKeys.DATA).getJSONArray(APIKeys.USERS);
        for (int i = 0; i< js_users.length(); i++){
            JSONObject js_user = js_users.getJSONObject(i);
            User user = new User(js_user);
            users.add(user);
        }
    }

    public ArrayList<User> getUsers() throws ResponseException {
        if (users==null) throw new ResponseException("users in null");
        return users;
    }
}
