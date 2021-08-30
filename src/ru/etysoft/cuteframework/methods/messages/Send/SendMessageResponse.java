package ru.etysoft.cuteframework.methods.messages.Send;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.Methods;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.messages.AttachmentData;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class SendMessageResponse extends ResponseHandler {

    private String id, text, time, attachmentType, attachmentPath;
    private AttachmentData attachmentData;

    public SendMessageResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
        System.out.println(jsonResponse);
    }

    public AttachmentData getAttachmentData() {
        return attachmentData;
    }

    public String getId() throws ResponseException {
        if(id == null) throw new ResponseException("Message id is null");
        return id;
    }

    public String getText() throws ResponseException {
        if(text == null) throw new ResponseException("Text is null");
        return text;
    }

    public String getTime() throws ResponseException {
        if(time == null) throw new ResponseException("Attachment is null");
        return time;
    }

    public String getAttachmentPath() {
        return Methods.mediaDomain + attachmentPath;
    }

    public String getAttachmentType() throws ResponseException {
        if(time == null) throw new ResponseException("Attachment is null");
        return attachmentType;
    }

    @Override
    public void onSuccess() {

        JSONObject respObj = getJsonResponse().getJSONObject(APIKeys.DATA);
        time = respObj.getString(APIKeys.TIME);
        text = respObj.getString(APIKeys.TEXT);
        id = respObj.getString(APIKeys.ID);
        if(respObj.has(APIKeys.Attachment.ATTACHMENT_TYPE))
        {
            attachmentType = respObj.getString(APIKeys.Attachment.ATTACHMENT_TYPE);
            attachmentPath = respObj.getString(APIKeys.Attachment.ATTACHMENT_PATH);
            attachmentData = AttachmentData.fromJSON(
                    respObj.getJSONObject(APIKeys.Attachment.ATTACHMENT_DATA));
        }

    }
}
