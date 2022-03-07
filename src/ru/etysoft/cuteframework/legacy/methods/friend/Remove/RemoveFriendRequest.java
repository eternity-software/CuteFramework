package ru.etysoft.cuteframework.legacy.methods.friend.Remove;

import ru.etysoft.cuteframework.legacy.data.APIKeys;
import ru.etysoft.cuteframework.legacy.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class RemoveFriendRequest extends RequestHolder {

    public RemoveFriendRequest(String token, String accountId) {
        super(APIMethods.Friend.REMOVE);
        setParams(Pair.make(APIKeys.TOKEN, token),
                Pair.make(APIKeys.ACCOUNT_ID, accountId));
    }

    public RemoveFriendResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new RemoveFriendResponse(request.processAPI(), request.getFormattedURL());
    }
}
