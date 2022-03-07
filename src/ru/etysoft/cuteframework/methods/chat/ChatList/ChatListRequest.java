package ru.etysoft.cuteframework.methods.chat.ChatList;

import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class ChatListRequest extends RequestHolder {
  private String token;
  
  public ChatListRequest(String token) {
    super("chat/getList");
    setParams(new Pair[] { Pair.make("token", token) });
    this.token = token;
  }
  
  public String getToken() {
    return this.token;
  }
  
  public ChatListResponse execute() throws ResponseException {
    Request request = makeRequest();
    return new ChatListResponse(request.processAPI(), request.getFormattedURL());
  }
}
