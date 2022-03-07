package ru.etysoft.cuteframework.methods.friend.GetRequests;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.user.User;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class FriendRequestsResponse extends ResponseHandler {
  private List<User> requests;
  
  public FriendRequestsResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {
    JSONObject jsonObject = getJsonResponse().getJSONObject("data");
    JSONArray jsonArray = jsonObject.getJSONArray("requests");
    this.requests = new ArrayList<>();
    for (int i = 0; i < jsonArray.length(); i++) {
      JSONObject friendObj = jsonArray.getJSONObject(i);
      this.requests.add(new User(friendObj));
    } 
  }
  
  public List<User> getRequests() throws ResponseException {
    if (this.requests == null)
      throw new ResponseException("Friends is null! (isn't success!)"); 
    return this.requests;
  }
}
