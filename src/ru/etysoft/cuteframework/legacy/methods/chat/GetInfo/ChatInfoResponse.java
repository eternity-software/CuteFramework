package ru.etysoft.cuteframework.legacy.methods.chat.GetInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.legacy.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.legacy.methods.chat.Chat;
import ru.etysoft.cuteframework.legacy.methods.chat.ChatMember;
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

        int id = chatObj.getInt(APIKeys.ID);
        int membersCount = getJsonResponse().getJSONObject(APIKeys.DATA).getInt(APIKeys.Chat.MEMBERS_COUNT);
        String type = chatObj.getString(APIKeys.TYPE);
        String state = chatObj.getString(APIKeys.STATE);

        String chatAvatarPath = null;

        if(!chatObj.isNull(APIKeys.AVATAR))
        {
            chatAvatarPath = CuteFramework.MEDIA_DOMAIN + chatObj.getString(APIKeys.AVATAR);
        }


        chat = new Chat(name, id,  type, description, state, chatAvatarPath, membersCount);

        JSONArray jsonArray = getJsonResponse().getJSONObject(APIKeys.DATA).getJSONArray(APIKeys.Chat.MEMBERS);

        memberList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject memberObj = jsonArray.getJSONObject(i);
            String displayName = memberObj.getString(APIKeys.DISPLAY_NAME);
            String typeMember = memberObj.getString(APIKeys.TYPE);
            long memberId = memberObj.getLong(APIKeys.ID);
            String avatar = memberObj.getString(APIKeys.AVATAR);
            ChatMember chatMember = new ChatMember(memberId, displayName, typeMember,
                    CuteFramework.API_DOMAIN.substring(0, CuteFramework.API_DOMAIN.length() - 1) + avatar);
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
