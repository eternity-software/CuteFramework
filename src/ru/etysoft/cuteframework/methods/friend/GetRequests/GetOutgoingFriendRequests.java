package ru.etysoft.cuteframework.methods.friend.GetRequests;

import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class GetOutgoingFriendRequests extends RequestHolder {
    private String token;
    public GetOutgoingFriendRequests(String token) {
        super(APIMethods.Friend.GET_OUTGOING_REQUESTS);
        setParams(Pair.make(APIKeys.TOKEN, token));
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public FriendRequestsResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new FriendRequestsResponse(request.processAPI(), request.getFormattedURL());
    }
}
