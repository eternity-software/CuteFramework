package ru.etysoft.cuteframework.methods.chat;

import org.json.JSONException;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.consts.APIMethods;
import ru.etysoft.cuteframework.exceptions.NoSuchValueException;
import ru.etysoft.cuteframework.exceptions.NotCachedException;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.BlankResponse;
import ru.etysoft.cuteframework.models.messages.Message;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.responses.Response;

import java.sql.SQLException;

public class ChatRemoveMessageRequest extends RequestHolder {
    public ChatRemoveMessageRequest(String messageId) {
        super(APIMethods.Chat.REMOVE_MESSAGE);
        setParams(Pair.make(APIKeys.Message.MESSAGE_ID, messageId));
    }

    public ChatRemoveMessageResponse execute() throws ResponseException, SQLException, NotCachedException {
        Request request = makeRequest();
        return new ChatRemoveMessageResponse(request.executeAPIWithToken(), request.getFormattedURL());
    }

    public static class ChatRemoveMessageResponse extends Response {

        private Message message;

        public ChatRemoveMessageResponse(String jsonResponse, String url) throws JSONException {
            super(jsonResponse, url);
        }

        @Override
        public void onSuccess() {
            message = new Message(getJsonResponse().getJSONObject(APIKeys.Response.DATA));
        }

        public Message getMessage() throws NoSuchValueException {
            if(message == null) throw new NoSuchValueException();
            return message;
        }
    }

}
