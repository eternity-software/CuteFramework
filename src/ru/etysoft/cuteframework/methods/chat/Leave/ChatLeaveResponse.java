package ru.etysoft.cuteframework.methods.chat.Leave;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.Response;

public class ChatLeaveResponse extends Response {
  public ChatLeaveResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {}
}
