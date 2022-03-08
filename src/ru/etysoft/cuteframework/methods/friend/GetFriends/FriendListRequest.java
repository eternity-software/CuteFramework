package ru.etysoft.cuteframework.methods.friend.GetFriends;

import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class FriendListRequest extends RequestHolder {
  private String token;
  
  public FriendListRequest(String token) {
    super("friend/getList");
    setParams(new Pair[] { Pair.make("token", token) });
    this.token = token;
  }
  
  public String getToken() {
    return this.token;
  }
  
  public FriendListResponse execute() throws ResponseException {
    Request request = makeRequest();
    return new FriendListResponse(request.executeAPI(), request.getFormattedURL());
  }
}
