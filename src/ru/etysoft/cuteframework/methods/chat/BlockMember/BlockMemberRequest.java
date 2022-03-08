package ru.etysoft.cuteframework.methods.chat.BlockMember;

import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class BlockMemberRequest extends RequestHolder {
  public BlockMemberRequest(String token, String chatId, String accountId) {
    super("chat/blockMember");
    setParams(new Pair[] { Pair.make("token", token), 
          Pair.make("chatId", chatId), 
          Pair.make("accountId", accountId) });
  }
  
  public BlockMemberResponse execute() throws ResponseException {
    Request request = makeRequest();
    return new BlockMemberResponse(request.executeAPI(), request.getFormattedURL());
  }
}
