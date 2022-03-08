package ru.etysoft.cuteframework.methods.media;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.responses.Response;

public class UploadImageResponse extends Response {
  private String mediaId;
  
  private String path;
  
  private String type;
  
  public UploadImageResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {
    JSONObject jsonObject = getJsonResponse().getJSONObject("data");
    this.mediaId = jsonObject.getString("id");
    this.path = jsonObject.getString("path");
    this.type = jsonObject.getString("type");
  }
  
  public String getPath() {
    return this.path;
  }
  
  public String getType() {
    return this.type;
  }
  
  public String getMediaId() throws ResponseException {
    if (this.mediaId == null)
      throw new ResponseException("mediaId is null"); 
    return this.mediaId;
  }
}
