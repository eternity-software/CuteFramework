package ru.etysoft.cuteframework.methods.chat.Remove;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.Response;

public class RemoveMessageResponse extends Response {
  public RemoveMessageResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {}
}
