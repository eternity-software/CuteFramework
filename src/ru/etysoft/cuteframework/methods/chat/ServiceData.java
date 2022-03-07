package ru.etysoft.cuteframework.methods.chat;

import org.json.JSONObject;
import ru.etysoft.cuteframework.exceptions.ResponseException;

public class ServiceData {
  private JSONObject messageServiceData;
  
  public ServiceData(String messageServiceData) {
    if (!messageServiceData.equals("0"))
      this.messageServiceData = new JSONObject(messageServiceData); 
  }
  
  public ServiceData(JSONObject jsonObject) {
    if (jsonObject.length() != 0)
      this.messageServiceData = jsonObject; 
  }
  
  public String getDisplayName() throws ResponseException {
    if (this.messageServiceData == null)
      throw new ResponseException("No service data"); 
    return this.messageServiceData.getString("displayName");
  }
  
  public int getAccountId() throws ResponseException {
    if (this.messageServiceData == null)
      throw new ResponseException("No service data"); 
    return this.messageServiceData.getInt("accountId");
  }
  
  public String getChatName() throws ResponseException {
    if (this.messageServiceData == null)
      throw new ResponseException("No service data"); 
    return this.messageServiceData.getString("chatName");
  }
  
  public String getType() {
    return this.messageServiceData.getString("type");
  }
  
  public static class Types {
    public static final String CHAT_CREATED = "chatCreated";
    
    public static final String ADD_MEMBER = "addMember";
  }
}
