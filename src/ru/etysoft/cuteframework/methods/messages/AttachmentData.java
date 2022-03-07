package ru.etysoft.cuteframework.methods.messages;

import org.json.JSONObject;

public class AttachmentData {
  private int height;
  
  private int width;
  
  public AttachmentData(int height, int width) {
    this.height = height;
    this.width = width;
  }
  
  public int getHeight() {
    return this.height;
  }
  
  public int getWidth() {
    return this.width;
  }
  
  public static AttachmentData fromJSON(JSONObject attachmentData) {
    int height = attachmentData.getInt("height");
    int width = attachmentData.getInt("width");
    return new AttachmentData(height, width);
  }
}
