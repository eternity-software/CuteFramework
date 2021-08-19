package ru.etysoft.cuteframework.methods.chat.UnblockMember;

import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.chat.MakeAdmin.MakeAdminResponse;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class UnblockMemberRequest extends RequestHolder {
    public UnblockMemberRequest(String token, String chatId, String accountId) {
        super(APIMethods.Chat.UNBLOCK_MEMBER);
        setParams(Pair.make(APIKeys.TOKEN, token),
                Pair.make(APIKeys.CHAT_ID, chatId),
                Pair.make(APIKeys.ACCOUNT_ID, accountId));
    }

    public UnblockMemberResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new UnblockMemberResponse(request.processAPI(), request.getFormattedURL());
    }
}
