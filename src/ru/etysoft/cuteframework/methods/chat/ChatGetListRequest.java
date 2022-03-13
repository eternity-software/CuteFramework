package ru.etysoft.cuteframework.methods.chat;

import org.json.JSONArray;
import org.json.JSONException;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.consts.APIMethods;
import ru.etysoft.cuteframework.exceptions.NoSuchValueException;
import ru.etysoft.cuteframework.exceptions.NotCachedException;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.models.ChatSnippet;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.responses.Response;
import ru.etysoft.cuteframework.storage.Cache;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChatGetListRequest extends RequestHolder {
    public ChatGetListRequest() {
        super(APIMethods.Chat.GET_LIST);
        setParams();
    }

    public ChatGetListRequest(String lastId) {
        super(APIMethods.Chat.GET_LIST);
        setParams(Pair.make(APIKeys.Chat.LAST_CHAT_ID, lastId));
    }

    public ChatGetListResponse execute() throws NotCachedException, SQLException, ResponseException {
        Request request = makeRequest();
        return new ChatGetListResponse(request.executeAPIWithToken(), request.getFormattedURL());
    }

    public static class ChatGetListResponse extends Response
    {

        private List<ChatSnippet> chatSnippets;

        public ChatGetListResponse(String jsonResponse, String url) throws JSONException {
            super(jsonResponse, url);
        }

        @Override
        public void onSuccess() {
           chatSnippets = new ArrayList<>();

            JSONArray jsonArray = getJsonResponse()
                    .getJSONObject(APIKeys.Response.DATA)
                    .getJSONArray(APIKeys.Chat.CHATS);

            for(int i = 0; i < jsonArray.length(); i++)
            {
                ChatSnippet chatSnippet = new ChatSnippet(jsonArray.getJSONObject(i));
                try {
                    Cache.getChatSnippetsTable().addChat(chatSnippet);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                chatSnippets.add(chatSnippet);
            }
        }

        public List<ChatSnippet> getChatSnippets() throws NoSuchValueException {
            checkNotNull(chatSnippets);
            return chatSnippets;
        }
    }
}
