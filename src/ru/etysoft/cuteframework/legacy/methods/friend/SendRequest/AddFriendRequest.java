package ru.etysoft.cuteframework.legacy.methods.friend.SendRequest;

import ru.etysoft.cuteframework.legacy.data.APIKeys;
import ru.etysoft.cuteframework.legacy.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class AddFriendRequest extends RequestHolder {

    public AddFriendRequest(String token, String accountId) {
        super(APIMethods.Friend.ADD);
        setParams(Pair.make(APIKeys.TOKEN, token),
                Pair.make(APIKeys.ACCOUNT_ID, accountId));
    }

    public AddFriendRequestResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new AddFriendRequestResponse(request.processAPI(), request.getFormattedURL());
    }
}
