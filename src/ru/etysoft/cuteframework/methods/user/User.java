package ru.etysoft.cuteframework.methods.user;

import org.json.JSONObject;
import ru.etysoft.cuteframework.CuteFramework;

public class User {
  private String onlineTime;
  
  private String bioText;
  
  private String statusText;
  
  private String displayName;
  
  private String id;
  
  private String login;
  
  private String avatar;
  
  private String cover;
  
  private boolean isFriend;
  
  public User(String onlineTime, String bioText, String statusText, String displayName, String id, String login, String avatar, String cover, boolean isFriend) {
    this.onlineTime = onlineTime;
    this.bioText = bioText;
    this.statusText = statusText;
    this.displayName = displayName;
    this.id = id;
    this.login = login;
    this.avatar = avatar;
    this.cover = cover;
    this.isFriend = isFriend;
  }
  
  public User(JSONObject jsonObject) {
    if (jsonObject.has("bioText"))
      this.bioText = jsonObject.getString("bioText"); 
    if (jsonObject.has("statusText"))
      this.statusText = jsonObject.getString("statusText"); 
    if (jsonObject.has("login"))
      this.login = jsonObject.getString("login"); 
    if (jsonObject.has("avatar"))
      this.avatar = String.valueOf(jsonObject.getString("avatar")); 
    if (jsonObject.has("cover"))
      this.cover = String.valueOf(jsonObject.getString("cover")); 
    if (jsonObject.has("isFriend"))
      this.isFriend = jsonObject.getBoolean("isFriend"); 
    this.displayName = jsonObject.getString("displayName");
    this.id = String.valueOf(jsonObject.getInt("id"));
    this.onlineTime = String.valueOf(jsonObject.getInt("onlineTime"));
  }
  
  public String getCover() {
    return CuteFramework.MEDIA_DOMAIN + this.cover;
  }
  
  public String getLogin() {
    return this.login;
  }
  
  public String getAvatar() {
    return CuteFramework.MEDIA_DOMAIN + this.avatar;
  }
  
  public String getBioText() {
    return this.bioText;
  }
  
  public String getDisplayName() {
    return this.displayName;
  }
  
  public long getId() {
    return Long.parseLong(this.id);
  }
  
  public String getOnlineTime() {
    return this.onlineTime;
  }
  
  public String getStatusText() {
    return this.statusText;
  }
  
  public boolean isFriend() {
    return this.isFriend;
  }
}
