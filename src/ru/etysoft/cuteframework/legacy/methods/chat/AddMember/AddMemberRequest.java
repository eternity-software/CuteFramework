package ru.etysoft.cuteframework.legacy.methods.chat.AddMember;

import ru.etysoft.cuteframework.legacy.data.APIKeys;
import ru.etysoft.cuteframework.legacy.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class AddMemberRequest extends RequestHolder {

    public AddMemberRequest(String token, String chatId, String accountId) {
        super(APIMethods.Chat.ADD_MEMBER);
        setParams(Pair.make(APIKeys.TOKEN, token),
                Pair.make(APIKeys.CHAT_ID, chatId),
                Pair.make(APIKeys.ACCOUNT_ID, accountId));
    }

    public AddMemberResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new AddMemberResponse(request.processAPI(), request.getFormattedURL());
    }
}
