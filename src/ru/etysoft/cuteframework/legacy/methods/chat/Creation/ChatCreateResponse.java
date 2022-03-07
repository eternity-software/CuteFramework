package ru.etysoft.cuteframework.legacy.methods.chat.Creation;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.legacy.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class ChatCreateResponse extends ResponseHandler {

    private String chatId, name;

    public ChatCreateResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
        JSONObject jsonObject = getJsonResponse().getJSONObject(APIKeys.DATA);
        chatId = String.valueOf(jsonObject.getInt(APIKeys.ID));
        name = String.valueOf(jsonObject.getInt(APIKeys.NAME));
    }

    public String getName() throws ResponseException {
        if(name == null) throw new ResponseException("Name is null");
        return name;
    }

    public String getChatId() throws ResponseException {
        if(chatId == null) throw new ResponseException("ChatId is null");
        return chatId;
    }
}
