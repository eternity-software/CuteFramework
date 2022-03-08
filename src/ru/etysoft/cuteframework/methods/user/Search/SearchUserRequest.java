package ru.etysoft.cuteframework.methods.user.Search;

import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class SearchUserRequest extends RequestHolder {
  private String token;
  
  private String query;
  
  public SearchUserRequest(String token, String query) {
    super("users/search");
    this.token = token;
    this.query = query;
    setParams(new Pair[] { Pair.make("token", token), Pair.make("name", query) });
  }
  
  public SearchUserResponse execute() throws ResponseException {
    Request request = makeRequest();
    return new SearchUserResponse(request.executeAPI(), request.getURL());
  }
}
