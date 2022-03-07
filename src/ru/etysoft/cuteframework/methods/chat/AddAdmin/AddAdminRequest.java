package ru.etysoft.cuteframework.methods.chat.AddAdmin;

import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class AddAdminRequest extends RequestHolder {
  private String token;
  
  private String chatId;
  
  private String accountId;
  
  public AddAdminRequest(String token, String chatId, String accountId) {
    super("chat/addAdmin");
    this.accountId = accountId;
    this.chatId = chatId;
    this.token = token;
    setParams(new Pair[] { Pair.make("token", token), 
          Pair.make("chatId", chatId), 
          Pair.make("token", token) });
  }
  
  public String getAccountId() {
    return this.accountId;
  }
  
  public String getChatId() {
    return this.chatId;
  }
  
  public String getToken() {
    return this.token;
  }
  
  public AddAdminResponse execute() throws ResponseException {
    Request request = makeRequest();
    return new AddAdminResponse(request.processAPI(), request.getFormattedURL());
  }
}
