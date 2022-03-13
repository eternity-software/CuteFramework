package ru.etysoft.cuteframework.methods.chat;

import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.consts.APIMethods;
import ru.etysoft.cuteframework.exceptions.NotCachedException;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.BlankResponse;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

import java.sql.SQLException;

public class ChatRemoveMessageRequest extends RequestHolder {
    public ChatRemoveMessageRequest(String messageId) {
        super(APIMethods.Chat.REMOVE_MESSAGE);
        setParams(Pair.make(APIKeys.Message.MESSAGE_ID, messageId));
    }

    public BlankResponse execute() throws ResponseException, SQLException, NotCachedException {
        Request request = makeRequest();
        return new BlankResponse(request.executeAPIWithToken(), request.getFormattedURL());
    }

}
