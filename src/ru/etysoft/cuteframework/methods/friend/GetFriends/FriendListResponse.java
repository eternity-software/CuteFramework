package ru.etysoft.cuteframework.methods.friend.GetFriends;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.user.User;
import ru.etysoft.cuteframework.responses.Response;

public class FriendListResponse extends Response {
  private List<User> friends;
  
  public FriendListResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {
    JSONObject jsonObject = getJsonResponse().getJSONObject("data");
    JSONArray jsonArray = jsonObject.getJSONArray("friends");
    this.friends = new ArrayList<>();
    for (int i = 0; i < jsonArray.length(); i++) {
      JSONObject friendObj = jsonArray.getJSONObject(i);
      this.friends.add(new User(friendObj));
    } 
  }
  
  public List<User> getFriends() throws ResponseException {
    if (this.friends == null)
      throw new ResponseException("Friends is null! (isn't success!)"); 
    return this.friends;
  }
}
