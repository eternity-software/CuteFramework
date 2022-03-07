package ru.etysoft.cuteframework.methods.chat.ClearHistory;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class ClearHistoryResponse extends ResponseHandler {
  public ClearHistoryResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {}
}
