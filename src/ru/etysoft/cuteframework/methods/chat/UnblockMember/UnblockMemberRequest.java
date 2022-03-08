package ru.etysoft.cuteframework.methods.chat.UnblockMember;

import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class UnblockMemberRequest extends RequestHolder {
  public UnblockMemberRequest(String token, String chatId, String accountId) {
    super("chat/unblockMember");
    setParams(new Pair[] { Pair.make("token", token), 
          Pair.make("chatId", chatId), 
          Pair.make("accountId", accountId) });
  }
  
  public UnblockMemberResponse execute() throws ResponseException {
    Request request = makeRequest();
    return new UnblockMemberResponse(request.executeAPI(), request.getFormattedURL());
  }
}
