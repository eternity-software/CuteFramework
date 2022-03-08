package ru.etysoft.cuteframework.methods.friend.GetRequests;

import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class GetIncomingFriendRequests extends RequestHolder {
  private String token;
  
  public GetIncomingFriendRequests(String token) {
    super("friend/getIncomingRequests");
    setParams(new Pair[] { Pair.make("token", token) });
    this.token = token;
  }
  
  public String getToken() {
    return this.token;
  }
  
  public FriendRequestsResponse execute() throws ResponseException {
    Request request = makeRequest();
    return new FriendRequestsResponse(request.executeAPI(), request.getFormattedURL());
  }
}
