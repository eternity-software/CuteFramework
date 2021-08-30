package ru.etysoft.cuteframework.methods.friend.DeclineRequest;

import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class DeclineFriendRequest extends RequestHolder {

    public DeclineFriendRequest(String token, String friendId) {
        super(APIMethods.Friend.DECLINE_REQUEST);
        setParams(Pair.make(APIKeys.TOKEN, token),
                Pair.make(APIKeys.REQUEST_ID, friendId));
    }

    public DeclineFriendResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new DeclineFriendResponse(request.processAPI(), request.getFormattedURL());
    }
}
