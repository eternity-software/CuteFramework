package ru.etysoft.cuteframework.methods.friend.SendRequest;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.Response;

public class AddFriendRequestResponse extends Response {
  public AddFriendRequestResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {}
}
