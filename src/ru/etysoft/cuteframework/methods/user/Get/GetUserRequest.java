package ru.etysoft.cuteframework.methods.user.Get;

import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class GetUserRequest extends RequestHolder {
    private String token, userId;
    public GetUserRequest(String token, String userId){
        super(APIMethods.Users.GET_USER);
        this.token = token;
        this.userId = userId;
        setParams(Pair.make(APIKeys.TOKEN, token), Pair.make(APIKeys.USER_ID, userId));
    }

    public GetUserResponse execute() throws ResponseException {
        Request request = makeRequest();
        return (new GetUserResponse(request.processAPI(), request.getURL()));
    }



}
