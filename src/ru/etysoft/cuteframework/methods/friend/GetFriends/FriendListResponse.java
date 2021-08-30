package ru.etysoft.cuteframework.methods.friend.GetFriends;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.Methods;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.chat.ChatSnippet;
import ru.etysoft.cuteframework.methods.chat.ServiceData;
import ru.etysoft.cuteframework.methods.friend.Friend;
import ru.etysoft.cuteframework.responses.ResponseHandler;

import java.util.ArrayList;
import java.util.List;

public class FriendListResponse extends ResponseHandler {


    private List<Friend> friends;


    public FriendListResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
        JSONObject jsonObject = getJsonResponse().getJSONObject(APIKeys.DATA);
        JSONArray jsonArray = jsonObject.getJSONArray(APIKeys.FRIENDS);

        friends = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++)
        {
            JSONObject friendObj = jsonArray.getJSONObject(i);
            friends.add(Friend.fromJSON(friendObj, false));
        }
    }

    public List<Friend> getFriends() throws ResponseException {
        if(friends == null) throw new ResponseException("Friends is null! (isn't success!)");
        return friends;
    }
}
