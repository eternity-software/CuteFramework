package ru.etysoft.cuteframework.methods.friend.GetFriends;

import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class FriendListRequest extends RequestHolder {
    private String token;
    public FriendListRequest(String token) {
        super(APIMethods.Friend.GET_FRIENDS);
        setParams(Pair.make(APIKeys.TOKEN, token));
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public FriendListResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new FriendListResponse(request.processAPI(), request.getFormattedURL());
    }
}
