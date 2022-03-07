package ru.etysoft.cuteframework.methods.chat.AddMember;

import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class AddMemberRequest extends RequestHolder {
  public AddMemberRequest(String token, String chatId, String accountId) {
    super("chat/addMember");
    setParams(new Pair[] { Pair.make("token", token), 
          Pair.make("chatId", chatId), 
          Pair.make("accountId", accountId) });
  }
  
  public AddMemberResponse execute() throws ResponseException {
    Request request = makeRequest();
    return new AddMemberResponse(request.processAPI(), request.getFormattedURL());
  }
}
