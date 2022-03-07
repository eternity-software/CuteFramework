package ru.etysoft.cuteframework.legacy.methods.chat.Creation;

import ru.etysoft.cuteframework.legacy.data.APIKeys;
import ru.etysoft.cuteframework.legacy.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class ChatCreateRequest extends RequestHolder {


    private String token, name, description, type;

    public ChatCreateRequest(String token, String name, String description, String type) {
        super(APIMethods.Chat.CREATE);
        this.token = token;
        this.name = name;
        this.description = description;
        this.type = type;
        setParams(Pair.make(APIKeys.TOKEN, token),
                Pair.make(APIKeys.NAME, name),
                Pair.make(APIKeys.DESCRIPTION, description),
                Pair.make(APIKeys.TYPE, type));
    }

    public ChatCreateResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new ChatCreateResponse(request.processAPI(), request.getFormattedURL());
    }

    public String getToken() {
        return token;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
