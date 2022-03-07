package ru.etysoft.cuteframework.legacy.methods.chat.DemoteAdmin;

import ru.etysoft.cuteframework.legacy.data.APIKeys;
import ru.etysoft.cuteframework.legacy.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class DemoteAdminRequest extends RequestHolder {
    public DemoteAdminRequest(String token, String chatId, String accountId) {
        super(APIMethods.Chat.DEMOTE_ADMIN);
        setParams(Pair.make(APIKeys.TOKEN, token),
                Pair.make(APIKeys.CHAT_ID, chatId),
                Pair.make(APIKeys.ACCOUNT_ID, accountId));
    }

    public DemoteAdminResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new DemoteAdminResponse(request.processAPI(), request.getFormattedURL());
    }
}
