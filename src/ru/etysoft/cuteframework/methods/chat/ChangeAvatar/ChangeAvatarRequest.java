package ru.etysoft.cuteframework.methods.chat.ChangeAvatar;

import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class ChangeAvatarRequest extends RequestHolder {
  private String mediaId;
  
  private String token;
  
  public ChangeAvatarRequest(String token, String mediaId, String chatId) {
    super("chat/changeAvatar");
    this.mediaId = mediaId;
    this.token = token;
    setParams(new Pair[] { Pair.make("token", token), Pair.make("mediaId", mediaId), 
          Pair.make("chatId", chatId) });
  }
  
  public ChangeAvatarResponse execute() throws ResponseException {
    Request request = makeRequest();
    return new ChangeAvatarResponse(request.processAPI(), request.getURL());
  }
}
