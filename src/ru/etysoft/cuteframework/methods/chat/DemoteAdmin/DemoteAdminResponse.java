package ru.etysoft.cuteframework.methods.chat.DemoteAdmin;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class DemoteAdminResponse extends ResponseHandler {
  public DemoteAdminResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {}
}
