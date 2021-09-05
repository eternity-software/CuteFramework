package ru.etysoft.cuteframework.methods.chat.SendMessage;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.messages.AttachmentData;
import ru.etysoft.cuteframework.methods.messages.Message;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class SendMessageResponse extends ResponseHandler {


    private Message message;


    public SendMessageResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
        System.out.println(jsonResponse);
    }

    public Message getMessage() {
        return message;
    }

    @Override
    public void onSuccess() {

        JSONObject respObj = getJsonResponse().getJSONObject(APIKeys.DATA).getJSONObject(APIKeys.Message.MESSAGE);

        message = new Message(respObj);

    }
}
