package ru.etysoft.cuteframework.methods.chat.ChangeAvatar;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.Response;

public class ChangeAvatarResponse extends Response {
  public ChangeAvatarResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {}
}
