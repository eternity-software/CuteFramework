package ru.etysoft.cuteframework.methods.chat;

import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.consts.APIMethods;
import ru.etysoft.cuteframework.exceptions.NotCachedException;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.chat.SendMessage.SendMessageResponse;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

import java.sql.SQLException;

public class ChatEditMessageRequest extends RequestHolder {
    public ChatEditMessageRequest(String messageId, String text) {
        super(APIMethods.Chat.EDIT_MESSAGE);
        setParams(Pair.make(APIKeys.Message.MESSAGE_ID, messageId),
                Pair.make(APIKeys.Message.TEXT, text));
    }

    public SendMessageResponse execute() throws ResponseException, SQLException, NotCachedException {
        Request request = makeRequest();
        return new SendMessageResponse(request.executeAPIWithToken(), request.getFormattedURL());
    }
}
