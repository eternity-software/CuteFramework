package ru.etysoft.cuteframework.methods.friend.Remove;

import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class RemoveFriendRequest extends RequestHolder {

    public RemoveFriendRequest(String token, String friendId) {
        super(APIMethods.Friend.REMOVE);
        setParams(Pair.make(APIKeys.TOKEN, token),
                Pair.make(APIKeys.FRIEND_ID, friendId));
    }

    public RemoveFriendResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new RemoveFriendResponse(request.processAPI(), request.getFormattedURL());
    }
}
