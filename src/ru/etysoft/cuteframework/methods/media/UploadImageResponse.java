package ru.etysoft.cuteframework.methods.media;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class UploadImageResponse extends ResponseHandler {
    private String mediaId;
    public UploadImageResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
        JSONObject jsonObject = getJsonResponse().getJSONObject(APIKeys.DATA);
        mediaId = jsonObject.getString(APIKeys.MEDIA_ID);
    }

    public String getMediaId() throws ResponseException {
        if (mediaId==null) throw new ResponseException("mediaId is null");
        return mediaId;
    }
}