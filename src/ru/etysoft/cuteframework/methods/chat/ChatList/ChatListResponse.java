package ru.etysoft.cuteframework.methods.chat.ChatList;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.chat.ChatSnippet;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class ChatListResponse extends ResponseHandler {
  private List<ChatSnippet> chats;
  
  public ChatListResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {
    JSONObject jsonObject = getJsonResponse().getJSONObject("data");
    JSONArray jsonArray = jsonObject.getJSONArray("chats");
    this.chats = new ArrayList<>();
    for (int i = 0; i < jsonArray.length(); i++) {
      ChatSnippet chat = new ChatSnippet(jsonArray.getJSONObject(i));
      this.chats.add(chat);
    } 
  }
  
  public List<ChatSnippet> getChats() throws ResponseException {
    if (this.chats == null)
      throw new ResponseException("Chats is null! (isn't success!)"); 
    return this.chats;
  }
}
