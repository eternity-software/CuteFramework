package ru.etysoft.cuteframework.legacy.methods.media;

import ru.etysoft.cuteframework.Logger;
import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.legacy.data.APIKeys;
import ru.etysoft.cuteframework.legacy.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.POST;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.requests.attachements.ImageFile;

import java.util.HashMap;

public class UploadImageRequest extends RequestHolder {
    private final String token;
    private final ImageFile image;

    public UploadImageRequest(ImageFile image, String token) {
        super(APIMethods.Media.UPLOAD_IMAGE);
        this.image = image;
        this.token = token;
    }

    public UploadImageResponse execute() throws ResponseException {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put(APIKeys.TOKEN, token);

        hashMap.put(APIKeys.Media.Types.IMAGE, image);


        String url = CuteFramework.API_DOMAIN + APIMethods.Media.UPLOAD_IMAGE;

        String response = POST.execute(url, hashMap, APIMethods.Media.UPLOAD_IMAGE);
        Logger.logResponse(response, getMethod());
        return new UploadImageResponse(response, url);
    }

}
