package ru.etysoft.cuteframework.methods.chat;

public class ChatMember {
  private long id;
  
  private String displayName;
  
  private String type;
  
  private String avatar;
  
  public ChatMember(long id, String displayName, String type, String avatar) {
    this.id = id;
    this.displayName = displayName;
    this.type = type;
    this.avatar = avatar;
  }
  
  public String getAvatar() {
    return this.avatar;
  }
  
  public long getId() {
    return this.id;
  }
  
  public String getDisplayName() {
    return this.displayName;
  }
  
  public String getType() {
    return this.type;
  }
  
  public static class Types {
    public static final String CREATOR = "C";
    
    public static final String ADMIN = "A";
    
    public static final String USER = "U";
  }
}
