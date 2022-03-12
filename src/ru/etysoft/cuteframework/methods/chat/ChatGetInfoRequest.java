package ru.etysoft.cuteframework.methods.chat;

import org.json.JSONException;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.consts.APIMethods;
import ru.etysoft.cuteframework.exceptions.NoSuchValueException;
import ru.etysoft.cuteframework.exceptions.NotCachedException;
import ru.etysoft.cuteframework.models.Chat;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.responses.Response;

import java.sql.SQLException;

public class ChatGetInfoRequest extends RequestHolder {
    public ChatGetInfoRequest(String chatId) {
        super(APIMethods.Chat.GET_INFO);
        setParams(Pair.make(APIKeys.Chat.CHAT_ID, chatId));
    }

    public ChatGetInfoResponse execute() throws SQLException, NotCachedException {
        Request request = makeRequest();
        return new ChatGetInfoResponse(request.executeAPIPOSTWithToken(), request.getFormattedURL());
    }

    public static class ChatGetInfoResponse extends Response
    {

        private Chat chat;

        public ChatGetInfoResponse(String jsonResponse, String url) throws JSONException {
            super(jsonResponse, url);
        }

        @Override
        public void onSuccess() {
           chat = new ru.etysoft.cuteframework.models.Chat(getJsonResponse().getJSONObject(APIKeys.Response.DATA));
        }

        public Chat getChat() throws NoSuchValueException {
            checkNotNull(chat);
            return chat;
        }
    }


}
