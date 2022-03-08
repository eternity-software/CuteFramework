package ru.etysoft.cuteframework.methods.chat.BlockMember;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.Response;

public class BlockMemberResponse extends Response {
  public BlockMemberResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {}
}
