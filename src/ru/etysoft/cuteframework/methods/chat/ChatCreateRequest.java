package ru.etysoft.cuteframework.methods.chat;

import org.json.JSONException;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.consts.APIMethods;
import ru.etysoft.cuteframework.exceptions.NoSuchValueException;
import ru.etysoft.cuteframework.exceptions.NotCachedException;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.responses.Response;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;

public class ChatCreateRequest extends RequestHolder {



    public ChatCreateRequest(String type, String name, String description) throws UnsupportedEncodingException {
        super(APIMethods.Chat.CREATE);

        setParams(Pair.make(APIKeys.Chat.TYPE, type),
                Pair.make(APIKeys.Chat.NAME, URLEncoder.encode(name, "UTF-8")),
                Pair.make(APIKeys.Chat.DESCRIPTION, description));
    }


    public ChatCreateResponse execute() throws ResponseException, SQLException, NotCachedException {
        Request request = makeRequest();
        return new ChatCreateResponse(request.executeAPIPOSTWithToken(), request.getFormattedURL());
    }

    public static class ChatCreateResponse extends Response {

        private String chatId;

        public ChatCreateResponse(String jsonResponse, String url) throws JSONException {
            super(jsonResponse, url);
        }

        @Override
        public void onSuccess() {
            chatId = getJsonResponse().getJSONObject(APIKeys.Response.DATA).getString(APIKeys.Chat.CHAT_ID);
        }

        public String getChatId() throws NoSuchValueException {
            checkNotNull(chatId);
            return chatId;
        }
    }

}
