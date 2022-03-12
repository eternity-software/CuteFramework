package ru.etysoft.cuteframework.methods.chat.Edit;

import java.util.HashMap;
import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.Logger;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.POST;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class EditChatRequest extends RequestHolder {
  private String token;
  
  private String name;
  
  private String description;
  
  public EditChatRequest(String token, String name, String description) {
    super("chat/edit");
    this.token = token;
    this.name = name;
    this.description = description;
  }
  
  public EditChatResponse execute() throws ResponseException {
    HashMap<String, Object> hashMap = new HashMap<>();
    hashMap.put("token", this.token);
    hashMap.put("name", this.name);
    hashMap.put("description", this.description);
    String url = CuteFramework.API_DOMAIN + "chat/create";
    String response = POST.execute(url, hashMap, getMethod(), null);
    Logger.logResponse(response, getMethod());
    return new EditChatResponse(response, url);
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
}
