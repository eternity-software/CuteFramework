package ru.etysoft.cuteframework.methods.media;

import ru.etysoft.cuteframework.Logger;
import ru.etysoft.cuteframework.Methods;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.POST;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.requests.attachements.ImageFile;

import java.util.HashMap;

public class UploadImageRequest extends RequestHolder {
    private final String token;
    private final ImageFile file;
    public UploadImageRequest(ImageFile file, String token) {
        super(APIMethods.Media.UP_LOAD_IMAGE);
        this.file = file;
        this.token = token;
    }
    public UploadImageResponse execute() throws ResponseException {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put(APIKeys.TOKEN, token);
        hashMap.put(APIKeys.FILE, file);

        String url = Methods.domain + APIMethods.Media.UP_LOAD_IMAGE;

        String response = POST.execute(url, hashMap, APIMethods.Media.UP_LOAD_IMAGE);
        Logger.logResponse(response, getMethod());
        return new UploadImageResponse(response, url);
    }

}
