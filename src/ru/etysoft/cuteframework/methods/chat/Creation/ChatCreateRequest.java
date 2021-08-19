package ru.etysoft.cuteframework.methods.chat.Creation;

import ru.etysoft.cuteframework.Methods;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.account.Login.LoginResponse;
import ru.etysoft.cuteframework.methods.account.Registration.RegistrationResponse;
import ru.etysoft.cuteframework.requests.POST;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

import java.util.HashMap;

public class ChatCreateRequest extends RequestHolder {


    private String token, name, description, type;

    public ChatCreateRequest(String token, String name, String description, String type) {
        super(APIMethods.Chat.CREATE);
        this.token = token;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public ChatCreateResponse execute() throws ResponseException {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put(APIKeys.TOKEN, token);
        hashMap.put(APIKeys.NAME, name);
        hashMap.put(APIKeys.DESCRIPTION, description);
        hashMap.put(APIKeys.TYPE, type);

        String url = Methods.domain + APIMethods.Chat.CREATE;

        String response = POST.execute(url, hashMap, APIMethods.Chat.CREATE);
        System.out.println(response);
        return new ChatCreateResponse(response, url);
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
