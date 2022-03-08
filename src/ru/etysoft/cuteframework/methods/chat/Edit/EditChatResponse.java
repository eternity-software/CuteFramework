package ru.etysoft.cuteframework.methods.chat.Edit;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.Response;

public class EditChatResponse extends Response {
  public EditChatResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {}
}
