package ru.etysoft.cuteframework.methods.chat.ClearHistory;

import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class ClearHistoryRequest extends RequestHolder {
  public ClearHistoryRequest(String token, String chatId) {
    super("chat/clearHistory");
    setParams(new Pair[] { Pair.make("token", token), 
          Pair.make("chatId", chatId) });
  }
  
  public ClearHistoryResponse execute() throws ResponseException {
    Request request = makeRequest();
    return new ClearHistoryResponse(request.processAPI(), request.getFormattedURL());
  }
}
