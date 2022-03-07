package ru.etysoft.cuteframework.methods.chat.DemoteAdmin;

import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class DemoteAdminRequest extends RequestHolder {
  public DemoteAdminRequest(String token, String chatId, String accountId) {
    super("chat/demoteAdmin");
    setParams(new Pair[] { Pair.make("token", token), 
          Pair.make("chatId", chatId), 
          Pair.make("accountId", accountId) });
  }
  
  public DemoteAdminResponse execute() throws ResponseException {
    Request request = makeRequest();
    return new DemoteAdminResponse(request.processAPI(), request.getFormattedURL());
  }
}
