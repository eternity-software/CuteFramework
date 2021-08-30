package ru.etysoft.cuteframework.methods.friend.AcceptRequest;

import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class AcceptFriendRequest extends RequestHolder {

    public AcceptFriendRequest(String token, String requestId) {
        super(APIMethods.Friend.ACCEPT_REQUEST);
        setParams(Pair.make(APIKeys.TOKEN, token),
                Pair.make(APIKeys.REQUEST_ID, requestId));
    }

    public AcceptFriendResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new AcceptFriendResponse(request.processAPI(), request.getFormattedURL());
    }
}
