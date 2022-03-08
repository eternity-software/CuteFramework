package ru.etysoft.cuteframework.methods.chat.UnblockMember;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.Response;

public class UnblockMemberResponse extends Response {
  public UnblockMemberResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {}
}
