package ru.etysoft.cuteframework.methods.chat.GetHistory;

import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class GetMessageListRequest extends RequestHolder {
  public GetMessageListRequest(String token, String chatId) {
    super("chat/getHistory");
    setParams(new Pair[] { Pair.make("token", token), 
          Pair.make("chatId", chatId) });
  }
  
  public GetMessageListRequest(String token, String chatId, String messageId) {
    super("chat/getHistory");
    setParams(new Pair[] { Pair.make("token", token), 
          Pair.make("messageId", messageId), 
          Pair.make("chatId", chatId) });
  }
  
  public GetMessageListResponse execute() throws ResponseException {
    Request request = makeRequest();
    return new GetMessageListResponse(request.processAPI(), request.getFormattedURL());
  }
}
