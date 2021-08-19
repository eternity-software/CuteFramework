package ru.etysoft.cuteframework.methods.chat.Leave;

import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class ChatLeaveRequest extends RequestHolder {
    public ChatLeaveRequest(String token, String chatId) {
        super(APIMethods.Chat.LEAVE);
        setParams(Pair.make(APIKeys.TOKEN, token),
                Pair.make(APIKeys.CHAT_ID, chatId));
    }

    public ChatLeaveResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new ChatLeaveResponse(request.processAPI(), request.getFormattedURL());
    }
}
