package ru.etysoft.cuteframework.methods.chat.AddAdmin;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.Response;

public class AddAdminResponse extends Response {
  public AddAdminResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {}
}
