package ru.etysoft.cuteframework.legacy.methods.chat.MakeAdmin;

import ru.etysoft.cuteframework.legacy.data.APIKeys;
import ru.etysoft.cuteframework.legacy.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class MakeAdminRequest extends RequestHolder {
    public MakeAdminRequest(String token, String chatId, String accountId) {
        super(APIMethods.Chat.MAKE_ADMIN);
        setParams(Pair.make(APIKeys.TOKEN, token),
                Pair.make(APIKeys.CHAT_ID, chatId),
                Pair.make(APIKeys.ACCOUNT_ID, accountId));
    }

    public MakeAdminResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new MakeAdminResponse(request.processAPI(), request.getFormattedURL());
    }
}
