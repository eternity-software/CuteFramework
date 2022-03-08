package ru.etysoft.cuteframework.methods.user.Get;

import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class GetUserRequest extends RequestHolder {
  private String token;
  
  private String userId;
  
  public GetUserRequest(String token, String userId) {
    super("users/get");
    this.token = token;
    this.userId = userId;
    setParams(new Pair[] { Pair.make("token", token), Pair.make("accountId", userId) });
  }
  
  public GetUserResponse execute() throws ResponseException {
    Request request = makeRequest();
    return new GetUserResponse(request.executeAPI(), request.getURL());
  }
}
