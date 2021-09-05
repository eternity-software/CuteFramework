package ru.etysoft.cuteframework.methods.chat.Edit;

import ru.etysoft.cuteframework.Logger;
import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.POST;
import ru.etysoft.cuteframework.requests.RequestHolder;

import java.util.HashMap;

public class EditChatRequest extends RequestHolder {


    private String token, name, description;

    public EditChatRequest(String token, String name, String description) {
        super(APIMethods.Chat.EDIT);
        this.token = token;
        this.name = name;
        this.description = description;
    }

    public EditChatResponse execute() throws ResponseException {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put(APIKeys.TOKEN, token);
        hashMap.put(APIKeys.NAME, name);
        hashMap.put(APIKeys.DESCRIPTION, description);
        String url = CuteFramework.domain + APIMethods.Chat.CREATE;
        String response = POST.execute(url, hashMap, getMethod());
        Logger.logResponse(response, getMethod());
        return new EditChatResponse(response, url);
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

}
