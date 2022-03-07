package ru.etysoft.cuteframework.legacy.methods.chat.AddAdmin;

import ru.etysoft.cuteframework.legacy.data.APIKeys;
import ru.etysoft.cuteframework.legacy.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class AddAdminRequest extends RequestHolder {

    private String token, chatId, accountId;

    public AddAdminRequest(String token, String chatId, String accountId) {
        super(APIMethods.Chat.ADD_ADMIN);
        this.accountId = accountId;
        this.chatId = chatId;
        this.token = token;
        setParams(Pair.make(APIKeys.TOKEN, token),
                Pair.make(APIKeys.CHAT_ID, chatId),
                Pair.make(APIKeys.TOKEN, token));
    }

    public String getAccountId() {
        return accountId;
    }

    public String getChatId() {
        return chatId;
    }

    public String getToken() {
        return token;
    }

    public AddAdminResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new AddAdminResponse(request.processAPI(), request.getFormattedURL());
    }
}
