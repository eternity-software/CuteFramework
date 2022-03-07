package ru.etysoft.cuteframework.methods.chat.GetInfo;

import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class ChatInfoRequest extends RequestHolder {
  public ChatInfoRequest(String token, String chatId) {
    super("chat/get");
    setParams(new Pair[] { Pair.make("token", token), 
          Pair.make("chatId", chatId) });
  }
  
  public ChatInfoResponse execute() throws ResponseException {
    Request request = makeRequest();
    return new ChatInfoResponse(request.processAPI(), request.getFormattedURL());
  }
}
