package ru.etysoft.cuteframework.methods.friend.SendRequest;

import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class SendFriendRequest extends RequestHolder {

    public SendFriendRequest(String token, String accountId) {
        super(APIMethods.Friend.SEND_REQUEST);
        setParams(Pair.make(APIKeys.TOKEN, token),
                Pair.make(APIKeys.RECIPIENT_ACCOUNT_ID, accountId));
    }

    public SendFriendRequestResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new SendFriendRequestResponse(request.processAPI(), request.getFormattedURL());
    }
}
