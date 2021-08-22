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

    private List<Message> messages;

    public GetMessageListResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
        JSONArray jsonArray = getJsonResponse().getJSONObject(APIKeys.DATA).getJSONArray(APIKeys.MESSAGES);

        messages = new ArrayList<>();

        for(int i = 0; i < jsonArray.length(); i++)
        {
            JSONObject messageObj = jsonArray.getJSONObject(i);
            int id = messageObj.getInt(APIKeys.ID);
            int accountId = messageObj.getInt(APIKeys.ACCOUNT_ID);
            int chatId = messageObj.getInt(APIKeys.CHAT_ID);
            String text = messageObj.getString(APIKeys.TEXT);
            String selfStatus = messageObj.getString(APIKeys.SELF_STATUS);
            String displayName = messageObj.getString(APIKeys.DISPLAY_NAME);
            String time = messageObj.getString(APIKeys.TIME);

            Message message = new Message(id, accountId, chatId, text, selfStatus, time, displayName);
            messages.add(message);
        }
    }

    public List<Message> getMessages() throws ResponseException {
        if(messages == null) throw new ResponseException("Messages is null! (isn't success!)");
        return messages;
    }
}
