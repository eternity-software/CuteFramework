package ru.etysoft.cuteframework.methods.friend.SendRequest;

import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class AddFriendRequest extends RequestHolder {
  public AddFriendRequest(String token, String accountId) {
    super("friend/add");
    setParams(new Pair[] { Pair.make("token", token), 
          Pair.make("accountId", accountId) });
  }
  
  public AddFriendRequestResponse execute() throws ResponseException {
    Request request = makeRequest();
    return new AddFriendRequestResponse(request.executeAPI(), request.getFormattedURL());
  }
}
