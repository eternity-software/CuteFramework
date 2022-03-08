package ru.etysoft.cuteframework.methods.friend.Remove;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.Response;

public class RemoveFriendResponse extends Response {
  public RemoveFriendResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {}
}
