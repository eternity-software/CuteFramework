package ru.etysoft.cuteframework.methods.chat;

import org.json.JSONArray;
import org.json.JSONException;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.consts.APIMethods;
import ru.etysoft.cuteframework.exceptions.NoSuchValueException;
import ru.etysoft.cuteframework.models.ChatMember;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.responses.Response;

import java.util.ArrayList;
import java.util.List;

public class ChatGetMembersRequest extends RequestHolder {
    public ChatGetMembersRequest(String chatId) {
        super(APIMethods.Chat.GET_MEMBERS);
        setParams(Pair.make(APIKeys.Chat.CHAT_ID, chatId));
    }

    public static class ChatGetMembersResponse extends Response
    {

        private List<ChatMember> chatMembers;

        public ChatGetMembersResponse(String jsonResponse, String url) throws JSONException {
            super(jsonResponse, url);
        }

        @Override
        public void onSuccess() {
            chatMembers = new ArrayList<>();
            JSONArray jsonArray = getJsonResponse().getJSONArray(APIKeys.Response.DATA);

            for(int i = 0; i < jsonArray.length(); i++)
            {
                chatMembers.add(new ChatMember(jsonArray.getJSONObject(i)));
            }
        }

        public List<ChatMember> getChatMembers() throws NoSuchValueException {
            if(chatMembers == null) throw new NoSuchValueException();
            return chatMembers;
        }
    }
}
