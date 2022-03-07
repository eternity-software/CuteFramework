package ru.etysoft.cuteframework.legacy.methods.chat.ChatList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.legacy.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.legacy.methods.chat.ChatSnippet;
import ru.etysoft.cuteframework.responses.ResponseHandler;

import java.util.ArrayList;
import java.util.List;

public class ChatListResponse extends ResponseHandler {


    private List<ChatSnippet> chats;


    public ChatListResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
        JSONObject jsonObject = getJsonResponse().getJSONObject(APIKeys.DATA);
        JSONArray jsonArray = jsonObject.getJSONArray(APIKeys.CHATS);

        chats = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++)
        {
            ChatSnippet chat = new ChatSnippet(jsonArray.getJSONObject(i));

            chats.add(chat);
        }
    }

    public List<ChatSnippet> getChats() throws ResponseException {
        if(chats == null) throw new ResponseException("Chats is null! (isn't success!)");
        return chats;
    }
}
