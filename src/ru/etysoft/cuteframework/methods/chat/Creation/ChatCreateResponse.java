package ru.etysoft.cuteframework.methods.chat.Creation;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class ChatCreateResponse extends ResponseHandler {
  private String chatId;
  
  private String name;
  
  public ChatCreateResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {
    JSONObject jsonObject = getJsonResponse().getJSONObject("data");
    this.chatId = String.valueOf(jsonObject.getLong("id"));
    if (jsonObject.has("name"))
      this.name = jsonObject.getString("name"); 
  }
  
  public String getName() throws ResponseException {
    if (this.name == null)
      throw new ResponseException("Name is null"); 
    return this.name;
  }
  
  public String getChatId() throws ResponseException {
    if (this.chatId == null)
      throw new ResponseException("ChatId is null"); 
    return this.chatId;
  }
}
