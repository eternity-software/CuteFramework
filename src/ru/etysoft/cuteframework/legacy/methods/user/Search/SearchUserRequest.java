package ru.etysoft.cuteframework.legacy.methods.user.Search;

import ru.etysoft.cuteframework.legacy.data.APIKeys;
import ru.etysoft.cuteframework.legacy.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class SearchUserRequest extends RequestHolder {
    private String token, query;
    public SearchUserRequest(String token, String query) {
        super(APIMethods.Users.SEARCH_USER);
        this.token = token;
        this.query = query;
        setParams(Pair.make(APIKeys.TOKEN, token), Pair.make(APIKeys.NAME, query));

    }
    public SearchUserResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new SearchUserResponse(request.processAPI(), request.getURL());
    }

}
