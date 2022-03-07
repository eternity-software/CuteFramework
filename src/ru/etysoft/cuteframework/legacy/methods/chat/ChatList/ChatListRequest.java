package ru.etysoft.cuteframework.legacy.methods.chat.ChatList;

import ru.etysoft.cuteframework.legacy.data.APIKeys;
import ru.etysoft.cuteframework.legacy.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class ChatListRequest extends RequestHolder {
    private String token;
    public ChatListRequest(String token) {
        super(APIMethods.Chat.GET_LIST);
        setParams(Pair.make(APIKeys.TOKEN, token));
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public ChatListResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new ChatListResponse(request.processAPI(), request.getFormattedURL());
    }
}
