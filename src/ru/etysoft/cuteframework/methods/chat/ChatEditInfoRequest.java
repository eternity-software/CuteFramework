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

public class ChatEditInfoRequest extends RequestHolder {
    public ChatEditInfoRequest(String chatId, String name, String description) {
        super(APIMethods.Chat.EDIT);
        setParams(Pair.make(APIKeys.Chat.NAME, name),
                Pair.make(APIKeys.Chat.CHAT_ID, chatId),
                Pair.make(APIKeys.Chat.DESCRIPTION, description));
    }

    public BlankResponse execute() throws ResponseException, SQLException, NotCachedException {
        Request request = makeRequest();
        return new BlankResponse(request.executeAPIWithToken(), request.getFormattedURL());
    }
}
