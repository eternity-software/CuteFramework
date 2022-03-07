package ru.etysoft.cuteframework.methods.media;

import java.util.HashMap;
import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.Logger;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.POST;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.requests.attachements.ImageFile;

public class UploadImageRequest extends RequestHolder {
  private final String token;
  
  private final ImageFile image;
  
  public UploadImageRequest(ImageFile image, String token) {
    super("media/uploadImage");
    this.image = image;
    this.token = token;
  }
  
  public UploadImageResponse execute() throws ResponseException {
    HashMap<String, Object> hashMap = new HashMap<>();
    hashMap.put("token", this.token);
    hashMap.put("image", this.image);
    String url = CuteFramework.MAIN_DOMAIN + "media/uploadImage";
    String response = POST.execute(url, hashMap, "media/uploadImage");
    Logger.logResponse(response, getMethod());
    return new UploadImageResponse(response, url);
  }
}
