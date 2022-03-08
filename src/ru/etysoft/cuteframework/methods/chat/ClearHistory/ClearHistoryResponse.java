package ru.etysoft.cuteframework.methods.chat.ClearHistory;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.Response;

public class ClearHistoryResponse extends Response {
  public ClearHistoryResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {}
}
