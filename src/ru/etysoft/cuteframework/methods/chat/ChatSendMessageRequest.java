package ru.etysoft.cuteframework.methods.chat;

import org.json.JSONException;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.consts.APIMethods;
import ru.etysoft.cuteframework.exceptions.NoSuchValueException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.RequestHolder;
import ru.etysoft.cuteframework.responses.Response;

public class ChatSendMessageRequest extends RequestHolder
{

    public ChatSendMessageRequest(String chatId, String text) {
        super(APIMethods.Chat.SEND_MESSAGE);
        setParams(Pair.make(APIKeys.Message.TEXT, text),
                Pair.make(APIKeys.Chat.CHAT_ID, chatId));
    }

    public static class ChatSendMessageResponse extends Response
    {

        private String messageId;

        public ChatSendMessageResponse(String jsonResponse, String url) throws JSONException {
            super(jsonResponse, url);
        }

        @Override
        public void onSuccess() {
            messageId = getJsonResponse().getJSONObject(APIKeys.Response.DATA).getString(APIKeys.Message.MESSAGE_ID);
        }

        public String getMessageId() throws NoSuchValueException {
            checkNotNull(messageId);
            return messageId;
        }
    }
}
