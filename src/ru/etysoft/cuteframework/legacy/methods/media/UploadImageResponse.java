package ru.etysoft.cuteframework.legacy.methods.media;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.legacy.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class UploadImageResponse extends ResponseHandler {
    private String mediaId, path, type;
    public UploadImageResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
        JSONObject jsonObject = getJsonResponse().getJSONObject(APIKeys.DATA);
        mediaId = jsonObject.getString(APIKeys.ID);
        path = jsonObject.getString(APIKeys.Attachment.PATH);
        type = jsonObject.getString(APIKeys.TYPE);
    }

    public String getPath() {
        return path;
    }

    public String getType() {
        return type;
    }

    public String getMediaId() throws ResponseException {
        if (mediaId==null) throw new ResponseException("mediaId is null");
        return mediaId;
    }
}
