package ru.etysoft.cuteframework.methods.chat.Creation;

import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class DialogCreateRequest extends RequestHolder {
  private String token;
  
  private String accountId;
  
  public DialogCreateRequest(String token, String accountId) {
    super("chat/getPrivate");
    this.token = token;
    this.accountId = accountId;
    setParams(new Pair[] { Pair.make("token", token), 
          Pair.make("accountId", accountId) });
  }
  
  public ChatCreateResponse execute() throws ResponseException {
    Request request = makeRequest();
    return new ChatCreateResponse(request.processAPI(), request.getFormattedURL());
  }
  
  public String getToken() {
    return this.token;
  }
  
  public String getAccountId() {
    return this.accountId;
  }
}
