package ru.etysoft.cuteframework.legacy.methods.chat.GetInfo;

import ru.etysoft.cuteframework.legacy.data.APIKeys;
import ru.etysoft.cuteframework.legacy.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class ChatInfoRequest extends RequestHolder {
    public ChatInfoRequest(String token, String chatId) {
        super(APIMethods.Chat.GET);
        setParams(Pair.make(APIKeys.TOKEN, token),
                Pair.make(APIKeys.CHAT_ID, chatId));
    }

    public ChatInfoResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new ChatInfoResponse(request.processAPI(), request.getFormattedURL());
    }
}
