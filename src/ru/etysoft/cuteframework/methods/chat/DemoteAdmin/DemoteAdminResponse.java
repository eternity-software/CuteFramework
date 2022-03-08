package ru.etysoft.cuteframework.methods.chat.DemoteAdmin;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.Response;

public class DemoteAdminResponse extends Response {
  public DemoteAdminResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {}
}
