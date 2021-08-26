package ru.etysoft.cuteframework.methods.media;

import ru.etysoft.cuteframework.Logger;
import ru.etysoft.cuteframework.Methods;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.POST;
import ru.etysoft.cuteframework.requests.RequestHolder;

import java.util.HashMap;

public class UpLoadImageRequest extends RequestHolder {
    private Object file;
    public UpLoadImageRequest(Object file) {
        super(APIMethods.Media.UP_LOAD_IMAGE);
        this.file = file;
    }
    public UpLoadImageResponse execute() throws ResponseException {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put(APIKeys.FILE, file);

        String url = Methods.domain + APIMethods.Media.UP_LOAD_IMAGE;

        String response = POST.execute(url, hashMap, APIMethods.Media.UP_LOAD_IMAGE);
        Logger.logResponse(response, getMethod());
        return new UpLoadImageResponse(response, url);
    }

}
