package ru.etysoft.cuteframework.methods.chat.Remove;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class RemoveMessageResponse extends ResponseHandler {
  public RemoveMessageResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {}
}
