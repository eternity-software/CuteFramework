package ru.etysoft.cuteframework.methods.chat.Creation;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class ChatCreateResponse extends ResponseHandler {

    private String chatId;

    public ChatCreateResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
        JSONObject jsonObject = getJsonResponse().getJSONObject(APIKeys.DATA);
        chatId = String.valueOf(jsonObject.getInt(APIKeys.CHAT_ID));

    }

    public String getChatId() throws ResponseException {
        if(chatId == null) throw new ResponseException("ChatId is null");
        return chatId;
    }
}
