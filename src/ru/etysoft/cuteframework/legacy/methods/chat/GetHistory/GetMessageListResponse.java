package ru.etysoft.cuteframework.legacy.methods.chat.GetHistory;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.legacy.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.legacy.methods.messages.Message;
import ru.etysoft.cuteframework.responses.ResponseHandler;

import java.util.ArrayList;
import java.util.List;

public class GetMessageListResponse extends ResponseHandler {

    private List<Message> messages;

    public GetMessageListResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
        JSONArray jsonArray = getJsonResponse().getJSONObject(APIKeys.DATA).getJSONArray(APIKeys.Message.MESSAGES);

        messages = new ArrayList<>();

        for(int i = 0; i < jsonArray.length(); i++)
        {
            JSONObject messageObj = jsonArray.getJSONObject(i);

            Message message = new Message(messageObj);
            messages.add(message);
        }
    }

    public List<Message> getMessages() throws ResponseException {
        if(messages == null) throw new ResponseException("Messages is null! (isn't success!)");
        return messages;
    }
}
