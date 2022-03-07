package ru.etysoft.cuteframework.methods.chat.AddMember;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class AddMemberResponse extends ResponseHandler {
  public AddMemberResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {}
}
