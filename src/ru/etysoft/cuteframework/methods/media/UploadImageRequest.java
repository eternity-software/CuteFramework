package ru.etysoft.cuteframework.methods.media;

import ru.etysoft.cuteframework.Logger;
import ru.etysoft.cuteframework.Methods;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.POST;
import ru.etysoft.cuteframework.requests.RequestHolder;

import java.util.HashMap;

public class UploadImageRequest extends RequestHolder {
    private Object file;
    public UploadImageRequest(Object file) {
        super(APIMethods.Media.UP_LOAD_IMAGE);
        this.file = file;
    }
    public UploadImageResponse execute() throws ResponseException {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put(APIKeys.FILE, file);

        String url = Methods.domain + APIMethods.Media.UP_LOAD_IMAGE;

        String response = POST.execute(url, hashMap, APIMethods.Media.UP_LOAD_IMAGE);
        Logger.logResponse(response, getMethod());
        return new UploadImageResponse(response, url);
    }

}
