package ru.etysoft.cuteframework.methods.user.Get;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.methods.user.User;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class GetUserResponse extends ResponseHandler {
  private User user;
  
  private User coverPath;
  
  private int friendId;
  
  private boolean isFriend;
  
  public GetUserResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {
    JSONObject jsonObject = getJsonResponse().getJSONObject("data").getJSONObject("user");
    this.user = new User(jsonObject);
  }
  
  public int getFriendId() {
    return this.friendId;
  }
  
  public User getUser() {
    return this.user;
  }
}
