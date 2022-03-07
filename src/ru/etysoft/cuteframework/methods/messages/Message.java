package ru.etysoft.cuteframework.methods.messages;

import org.json.JSONObject;
import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.methods.chat.ServiceData;
import ru.etysoft.cuteframework.methods.user.User;

public class Message {

  private int id;
  private int accountId;
  private boolean read;
  private String text;
  private String time;
  private String displayName;
  private String type;
  private ServiceData serviceData;
  private String attachmentPath;
  private String attachmentType;
  private AttachmentData attachmentData;
  private User sender;
  private Message forwardedMessage;
  private MessageDataHandler messageDataHandler;
  
  public Message(int id, int accountId, boolean read, String text, String time, String displayName, String type, ServiceData serviceData, String attachmentPath, String attachmentType, AttachmentData attachmentData, User sender) {
    this.id = id;
    this.accountId = accountId;
    this.read = read;
    this.text = text;
    this.time = time;
    this.displayName = displayName;
    this.type = type;
    this.serviceData = serviceData;
    this.attachmentPath = attachmentPath;
    this.attachmentType = attachmentType;
    this.attachmentData = attachmentData;
    this.sender = sender;
  }
  
  public Message(JSONObject messageObj) {
    this.id = messageObj.getInt("id");
    this.accountId = messageObj.getInt("id");
    this.time = messageObj.getString("time");
    this.type = messageObj.getString("type");
    this.read = messageObj.getBoolean("read");
    if (messageObj.has("attachment")) {
      JSONObject attachmentObj = messageObj.getJSONObject("attachment");
      this.attachmentPath = attachmentObj.getString("path");
      this.attachmentType = attachmentObj.getString("type");
      JSONObject attachmentDataObj = attachmentObj.getJSONObject("data");
      this.attachmentData = AttachmentData.fromJSON(attachmentDataObj);
    } 
    if (this.type.equals("service")) {
      JSONObject jsonObject = messageObj.getJSONObject("data");
      this.serviceData = new ServiceData(jsonObject);
    } else {
      this.sender = new User(messageObj.getJSONObject("from"));
      if (!messageObj.isNull("text"))
        this.text = messageObj.getString("text"); 
      if (!messageObj.isNull("forwarded"))
        this.forwardedMessage = new Message(messageObj.getJSONObject("forwarded")); 
    } 
  }
  
  public void setForwardedMessage(Message forwardedMessage) {
    this.forwardedMessage = forwardedMessage;
  }
  
  public Message getForwardedMessage() {
    return this.forwardedMessage;
  }
  
  public void setMessageDataHandler(MessageDataHandler messageDataHandler) {
    this.messageDataHandler = messageDataHandler;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public void setAccountId(int accountId) {
    this.accountId = accountId;
  }
  
  public void setRead(boolean read) {
    this.read = read;
  }
  
  public void setText(String text) {
    this.text = text;
  }
  
  public void setTime(String time) {
    this.time = time;
  }
  
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }
  
  public void setType(String type) {
    this.type = type;
  }
  
  public void setServiceData(ServiceData serviceData) {
    this.serviceData = serviceData;
  }
  
  public void setAttachmentPath(String attachmentPath) {
    this.attachmentPath = attachmentPath;
  }
  
  public void setAttachmentType(String attachmentType) {
    this.attachmentType = attachmentType;
  }
  
  public void setAttachmentData(AttachmentData attachmentData) {
    this.attachmentData = attachmentData;
  }
  
  public void setSender(User sender) {
    this.sender = sender;
  }
  
  public User getSender() {
    return this.sender;
  }
  
  public boolean isRead() {
    return this.read;
  }
  
  public AttachmentData getAttachmentData() {
    return this.attachmentData;
  }
  
  public String getAttachmentPath() {
    return CuteFramework.MEDIA_DOMAIN + this.attachmentPath;
  }
  
  public String getCleanAttachmentPath() {
    return this.attachmentPath;
  }
  
  public String getAttachmentType() {
    return this.attachmentType;
  }
  
  public ServiceData getServiceData() {
    return this.serviceData;
  }
  
  public String getType() {
    return this.type;
  }
  
  public int getId() {
    return this.id;
  }
  
  public int getAccountId() {
    return this.accountId;
  }
  
  public String getText() {
    return this.text;
  }
  
  public String getTime() {
    return this.time;
  }
  
  public void notifyDataChanged() {
    this.messageDataHandler.onDataUpdated(this);
  }
  
  public static class Type {
    public static final String SERVICE = "service";
    
    public static final String USER = "user";
  }
  
  public static class Status {
    public static final String AVAILABLE = "Y";
    
    public static final String DELETED = "N";
  }
  
  public static interface MessageDataHandler {
    void onDataUpdated(Message param1Message);
  }
}
