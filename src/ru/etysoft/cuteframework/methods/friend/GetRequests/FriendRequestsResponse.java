package ru.etysoft.cuteframework.methods.friend.GetRequests;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.friend.Friend;
import ru.etysoft.cuteframework.methods.user.User;
import ru.etysoft.cuteframework.responses.ResponseHandler;

import java.util.ArrayList;
import java.util.List;

public class FriendRequestsResponse extends ResponseHandler {


    private List<User> requests;


    public FriendRequestsResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
        JSONObject jsonObject = getJsonResponse().getJSONObject(APIKeys.DATA);
        JSONArray jsonArray = jsonObject.getJSONArray(APIKeys.REQUESTS);

        requests = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject friendObj = jsonArray.getJSONObject(i);
            requests.add(new User(friendObj));
        }
    }

    public List<User> getRequests() throws ResponseException {
        if (requests == null) throw new ResponseException("Friends is null! (isn't success!)");
        return requests;
    }
}
