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

public class ChatSetPermissionGroup extends RequestHolder {
    public ChatSetPermissionGroup(String chatId, String accountId, String group) {
        super(APIMethods.Chat.SET_PERMISSION_GROUP);
        setParams(Pair.make(APIKeys.Account.ACCOUNT_ID, accountId),
                Pair.make(APIKeys.Chat.CHAT_ID, chatId),
                Pair.make(APIKeys.Account.GROUP, group));
    }

    public BlankResponse execute() throws ResponseException, SQLException, NotCachedException {
        Request request = makeRequest();
        return new BlankResponse(request.executeAPIWithToken(), request.getFormattedURL());
    }
}
