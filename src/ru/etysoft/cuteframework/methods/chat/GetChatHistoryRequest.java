package ru.etysoft.cuteframework.methods.chat;

import org.json.JSONArray;
import org.json.JSONException;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.consts.APIMethods;
import ru.etysoft.cuteframework.exceptions.NoSuchValueException;
import ru.etysoft.cuteframework.exceptions.NotCachedException;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.models.messages.Message;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.responses.Response;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetChatHistoryRequest extends RequestHolder {
    public GetChatHistoryRequest(String chatId, String lastMessageId) {
        super(APIMethods.Chat.GET_HISTORY);
        setParams(Pair.make(APIKeys.Chat.CHAT_ID, chatId),
                Pair.make(APIKeys.Chat.LAST_MESSAGE_ID, lastMessageId));
    }
    public GetChatHistoryRequest(String chatId) {
        super(APIMethods.Chat.GET_HISTORY);
        setParams(Pair.make(APIKeys.Chat.CHAT_ID, chatId));
    }

    public GetChatHistoryResponse execute() throws ResponseException, SQLException, NotCachedException {
        Request request = makeRequest();
        return new GetChatHistoryResponse(request.executeAPIWithToken(), request.getFormattedURL());
    }


    public static class GetChatHistoryResponse extends Response
    {

        private List<Message> messages;

        public GetChatHistoryResponse(String jsonResponse, String url) throws JSONException {
            super(jsonResponse, url);
        }

        @Override
        public void onSuccess() {
            JSONArray jsonArray = getJsonResponse().getJSONObject(APIKeys.Response.DATA).getJSONArray(APIKeys.Message.MESSAGES);
            messages = new ArrayList<>();
            for(int i = 0; i < jsonArray.length(); i++)
            {
                Message message = Message.createMessage(jsonArray.getJSONObject(i));
                messages.add(message);
            }

        }

        public List<Message> getMessages() throws NoSuchValueException {
            checkNotNull(messages);
            return messages;
        }
    }
}
