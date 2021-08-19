package ru.etysoft.cuteframework.methods.messages.Send;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class SendMessageResponse extends ResponseHandler {

    private String messageId, text, time;

    public SendMessageResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    public String getMessageId() throws ResponseException {
        if(messageId == null) throw new ResponseException("Message id is null");
        return messageId;
    }

    public String getText() throws ResponseException {
        if(text == null) throw new ResponseException("Text is null");
        return text;
    }

    public String getTime() throws ResponseException {
        if(time == null) throw new ResponseException("Time is null");
        return time;
    }

    @Override
    public void onSuccess() {
        JSONObject respObj = getJsonResponse();
        time = respObj.getString(APIKeys.TIME);
        text = respObj.getString(APIKeys.TEXT);
        messageId = respObj.getString(APIKeys.MESSAGE_ID);
    }
}
