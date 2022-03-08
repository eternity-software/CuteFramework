package ru.etysoft.cuteframework.methods.friend.Remove;

import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class RemoveFriendRequest extends RequestHolder {
  public RemoveFriendRequest(String token, String accountId) {
    super("friend/remove");
    setParams(new Pair[] { Pair.make("token", token), 
          Pair.make("accountId", accountId) });
  }
  
  public RemoveFriendResponse execute() throws ResponseException {
    Request request = makeRequest();
    return new RemoveFriendResponse(request.executeAPI(), request.getFormattedURL());
  }
}
