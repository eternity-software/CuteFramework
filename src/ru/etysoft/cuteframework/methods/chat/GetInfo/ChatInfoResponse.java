package ru.etysoft.cuteframework.methods.chat.GetInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.Methods;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.chat.Chat;
import ru.etysoft.cuteframework.methods.chat.ChatMember;
import ru.etysoft.cuteframework.responses.ResponseHandler;

import java.util.ArrayList;
import java.util.List;

public class ChatInfoResponse extends ResponseHandler {

    private Chat chat;
    private List<ChatMember> memberList;

    public ChatInfoResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
        JSONObject chatObj = getJsonResponse().getJSONObject(APIKeys.DATA).getJSONObject(APIKeys.CHAT);
        String name = chatObj.getString(APIKeys.NAME);
        String description = chatObj.getString(APIKeys.DESCRIPTION);
        int accountId = chatObj.getInt(APIKeys.ACCOUNT_ID);
        int id = chatObj.getInt(APIKeys.ID);
        String type = chatObj.getString(APIKeys.TYPE);
        String selfStatus = chatObj.getString(APIKeys.SELF_STATUS);


        chat = new Chat(name, id, accountId, type, description, selfStatus);

        JSONArray jsonArray = chatObj.getJSONArray("members");

        memberList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject memberObj = jsonArray.getJSONObject(i);
            String displayName = memberObj.getString(APIKeys.DISPLAY_NAME);
            String typeMember = memberObj.getString(APIKeys.TYPE);
            String selfStatusMember = memberObj.getString(APIKeys.SELF_STATUS);
            int memberId = memberObj.getInt(APIKeys.ID);
            String avatarPath = memberObj.getString(APIKeys.AVATAR_PATH);
            ChatMember chatMember = new ChatMember(memberId, displayName, typeMember, selfStatusMember,
                    Methods.domain.substring(0, Methods.domain.length() - 1) + avatarPath);
            memberList.add(chatMember);
        }
    }

    public List<ChatMember> getMembers() throws ResponseException {
        if(memberList == null) throw new ResponseException("Members is null! (isn't success!)");
        return memberList;
    }

    public Chat getChat() throws ResponseException {
        if(chat == null) throw new ResponseException("Chat is null!");
        return chat;
    }
}
