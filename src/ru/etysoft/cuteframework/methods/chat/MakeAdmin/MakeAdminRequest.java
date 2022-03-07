package ru.etysoft.cuteframework.methods.chat.MakeAdmin;

import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class MakeAdminRequest extends RequestHolder {
  public MakeAdminRequest(String token, String chatId, String accountId) {
    super("chat/makeAdmin");
    setParams(new Pair[] { Pair.make("token", token), 
          Pair.make("chatId", chatId), 
          Pair.make("accountId", accountId) });
  }
  
  public MakeAdminResponse execute() throws ResponseException {
    Request request = makeRequest();
    return new MakeAdminResponse(request.processAPI(), request.getFormattedURL());
  }
}
