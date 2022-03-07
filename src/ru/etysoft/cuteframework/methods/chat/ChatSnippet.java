package ru.etysoft.cuteframework.methods.chat;

import org.json.JSONObject;
import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.methods.messages.Message;

public class ChatSnippet {
  private long id;
  
  private long accountId;
  
  private boolean isDialog;
  
  private String type;
  
  private String name;
  
  private String state;
  
  private String avatarPath;
  
  private Message message;
  
  public ChatSnippet(JSONObject snippetObj) {
    JSONObject chatObj = snippetObj.getJSONObject("chat");
    this.name = chatObj.getString("name");
    this.id = chatObj.getLong("id");
    this.type = chatObj.getString("type");
    this.state = chatObj.getString("state");
    this.isDialog = chatObj.getBoolean("isDialog");
    if (this.isDialog)
      this.accountId = chatObj.getJSONObject("private").getLong("id"); 
    if (snippetObj.has("message")) {
      JSONObject messageObj = snippetObj.getJSONObject("message");
      this.message = new Message(messageObj);
    } 
    if (!chatObj.isNull("avatar"))
      this.avatarPath = CuteFramework.MEDIA_DOMAIN + chatObj.getString("avatar");
  }
  
  public long getAccountId() {
    return this.accountId;
  }
  
  public boolean isDialog() {
    return this.isDialog;
  }
  
  public Message getMessage() {
    return this.message;
  }
  
  public String getAvatarPath() {
    return this.avatarPath;
  }
  
  public String getType() {
    return this.type;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getState() {
    return this.state;
  }
  
  public long getId() {
    return this.id;
  }
  
  public static class Types {
    public static final String THREAD = "T";
    
    public static final String CONVERSATION = "C";
    
    public static final String PRIVATE = "P";
  }
  
  public static class Status {
    public static final String JOINED = "Y";
    
    public static final String LEAVED = "N";
    
    public static final String BLOCKED = "B";
  }
}
