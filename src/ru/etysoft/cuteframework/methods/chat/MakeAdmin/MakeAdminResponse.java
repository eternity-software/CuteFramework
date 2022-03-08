package ru.etysoft.cuteframework.methods.chat.MakeAdmin;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.Response;

public class MakeAdminResponse extends Response {
  public MakeAdminResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {}
}
