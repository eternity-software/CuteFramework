package ru.etysoft.cuteframework.methods.friend;

import org.json.JSONObject;
import ru.etysoft.cuteframework.CuteFramework;

public class Friend {
  private String displayName;
  
  private String avatarPath;
  
  private String onlineTime;
  
  private int accountId;
  
  private int friendId;
  
  private int requestId;
  
  private boolean isRequest = false;
  
  public Friend(String displayName, String avatarPath, String onlineTime, int accountId, int friendId, int requestId, boolean isRequest) {
    this.displayName = displayName;
    this.avatarPath = avatarPath;
    this.onlineTime = onlineTime;
    this.accountId = accountId;
    this.friendId = friendId;
    this.isRequest = isRequest;
    this.requestId = requestId;
  }
  
  public static Friend fromJSON(JSONObject jsonObject, boolean isRequest) {
    String avatarPath = null;
    if (!jsonObject.isNull("avatar"))
      avatarPath = jsonObject.getString("avatar"); 
    String displayName = jsonObject.getString("displayName");
    String onlineTime = jsonObject.getString("onlineTime");
    int accountId = jsonObject.getInt("accountId");
    int friendId = 0, requestId = 0;
    if (!isRequest) {
      friendId = jsonObject.getInt("friendId");
    } else {
      requestId = jsonObject.getInt("requestId");
    } 
    return new Friend(displayName, avatarPath, onlineTime, accountId, friendId, requestId, isRequest);
  }
  
  public boolean isRequest() {
    return this.isRequest;
  }
  
  public int getRequestId() {
    return this.requestId;
  }
  
  public String getDisplayName() {
    return this.displayName;
  }
  
  public String getAvatarPath() {
    return CuteFramework.MEDIA_DOMAIN + this.avatarPath;
  }
  
  public String getOnlineTime() {
    return this.onlineTime;
  }
  
  public int getAccountId() {
    return this.accountId;
  }
  
  public int getFriendId() {
    return this.friendId;
  }
}
