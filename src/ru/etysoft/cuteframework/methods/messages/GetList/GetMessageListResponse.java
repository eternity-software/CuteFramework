package ru.etysoft.cuteframework.methods.messages.GetList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.chat.Chat;
import ru.etysoft.cuteframework.methods.messages.Message;
import ru.etysoft.cuteframework.responses.ResponseHandler;

import java.util.ArrayList;
import java.util.List;

public class GetMessageListResponse extends ResponseHandler {

    private List<Message> messages = new ArrayList<>();

    public GetMessageListResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
        JSONArray jsonArray = getJsonResponse().getJSONArray(APIKeys.MESSAGES);

        for(int i = 0; i < jsonArray.length(); i++)
        {
            JSONObject messageObj = jsonArray.getJSONObject(i);
            int id = messageObj.getInt(APIKeys.ID);
            int accountId = messageObj.getInt(APIKeys.ACCOUNT_ID);
            int chatId = messageObj.getInt(APIKeys.CHAT_ID);
            String text = messageObj.getString(APIKeys.TEXT);
            String activity = messageObj.getString(APIKeys.ACTIVITY);
            String time = messageObj.getString(APIKeys.TIME);

            Message message = new Message(id, accountId, chatId, text, activity, time);
            messages.add(message);
        }
    }

    public List<Message> getMessages() throws ResponseException {
        if(!isSuccess()) throw new ResponseException("Messages cannot be received! (isn't success!)");
        return messages;
    }
}
