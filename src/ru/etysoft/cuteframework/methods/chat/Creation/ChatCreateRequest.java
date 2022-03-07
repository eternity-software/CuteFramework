package ru.etysoft.cuteframework.methods.chat.Creation;

import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class ChatCreateRequest extends RequestHolder {
  private String token;
  
  private String name;
  
  private String description;
  
  private String type;
  
  public ChatCreateRequest(String token, String name, String description, String type) {
    super("chat/create");
    this.token = token;
    this.name = name;
    this.description = description;
    this.type = type;
    setParams(new Pair[] { Pair.make("token", token), 
          Pair.make("name", name), 
          Pair.make("description", description), 
          Pair.make("type", type) });
  }
  
  public ChatCreateResponse execute() throws ResponseException {
    Request request = makeRequest();
    return new ChatCreateResponse(request.processAPI(), request.getFormattedURL());
  }
  
  public String getToken() {
    return this.token;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getType() {
    return this.type;
  }
}
