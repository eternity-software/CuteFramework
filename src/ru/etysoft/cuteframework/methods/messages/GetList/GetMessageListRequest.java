package ru.etysoft.cuteframework.methods.messages.GetList;

import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.account.Authentication.AuthenticationResponse;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class GetMessageListRequest extends RequestHolder {
    public GetMessageListRequest(String token, String chatId) {
        super(APIMethods.Message.GET_LIST);
        setParams(Pair.make(APIKeys.TOKEN, token),
                Pair.make(APIKeys.CHAT_ID, chatId));
    }

    public GetMessageListResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new GetMessageListResponse(request.processAPI(), request.getFormattedURL());
    }
}
