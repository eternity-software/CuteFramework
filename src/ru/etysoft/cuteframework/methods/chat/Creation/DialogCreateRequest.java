package ru.etysoft.cuteframework.methods.chat.Creation;

import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class DialogCreateRequest extends RequestHolder {


    private String token, accountId;

    public DialogCreateRequest(String token, String accountId) {
        super(APIMethods.Chat.GET_PRIVATE_CHAT);
        this.token = token;
        this.accountId = accountId;
        setParams(Pair.make(APIKeys.TOKEN, token),
                Pair.make(APIKeys.ACCOUNT_ID, accountId));
    }

    public ChatCreateResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new ChatCreateResponse(request.processAPI(), request.getFormattedURL());
    }

    public String getToken() {
        return token;
    }

    public String getAccountId() {
        return accountId;
    }
}

