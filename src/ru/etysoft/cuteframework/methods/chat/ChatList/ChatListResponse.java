package ru.etysoft.cuteframework.methods.chat.ChatList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.chat.Chat;
import ru.etysoft.cuteframework.responses.ResponseHandler;

import java.util.ArrayList;
import java.util.List;

public class ChatListResponse extends ResponseHandler {


    private List<Chat> chats;


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

            JSONObject chatObj = jsonArray.getJSONObject(i);
            String name = chatObj.getString(APIKeys.NAME);
            String description = chatObj.getString(APIKeys.DESCRIPTION);
            int accountId = chatObj.getInt(APIKeys.ACCOUNT_ID);
            int id = chatObj.getInt(APIKeys.ID);
            String lastMessageTime = chatObj.getString(APIKeys.MESSAGE_TIME);
            String lastMessageText = chatObj.getString(APIKeys.MESSAGE_TEXT);
            String lastMessageSenderName = chatObj.getString(APIKeys.MESSAGE_SENDER_DISPLAY_NAME);
            boolean isRead = chatObj.getInt(APIKeys.MESSAGE_READ) != 0;
            String type = chatObj.getString(APIKeys.TYPE);
            String selfStatus = chatObj.getString(APIKeys.SELF_STATUS);

            Chat chat = new Chat(name, id, accountId, type, description, selfStatus,
                    lastMessageText, lastMessageSenderName, lastMessageTime, isRead);
            chats.add(chat);
        }
    }

    public List<Chat> getChats() throws ResponseException {
        if(chats == null) throw new ResponseException("Chats is null! (isn't success!)");
        return chats;
    }
}
