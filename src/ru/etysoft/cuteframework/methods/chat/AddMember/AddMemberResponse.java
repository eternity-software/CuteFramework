package ru.etysoft.cuteframework.methods.chat.AddMember;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.Response;

public class AddMemberResponse extends Response {
  public AddMemberResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {}
}
