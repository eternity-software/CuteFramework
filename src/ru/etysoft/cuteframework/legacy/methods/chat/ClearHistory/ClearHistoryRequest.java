package ru.etysoft.cuteframework.legacy.methods.chat.ClearHistory;

import ru.etysoft.cuteframework.legacy.data.APIKeys;
import ru.etysoft.cuteframework.legacy.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class ClearHistoryRequest extends RequestHolder {
    public ClearHistoryRequest(String token, String chatId) {
        super(APIMethods.Chat.CLEAR_HISTORY);
        setParams(Pair.make(APIKeys.TOKEN, token),
                Pair.make(APIKeys.CHAT_ID, chatId));
    }

    public ClearHistoryResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new ClearHistoryResponse(request.processAPI(), request.getFormattedURL());
    }
}
