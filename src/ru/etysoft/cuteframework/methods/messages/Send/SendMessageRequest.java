package ru.etysoft.cuteframework.methods.messages.Send;

import ru.etysoft.cuteframework.Methods;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.account.Registration.RegistrationResponse;
import ru.etysoft.cuteframework.requests.POST;
import ru.etysoft.cuteframework.requests.RequestHolder;

import java.util.HashMap;

public class SendMessageRequest extends RequestHolder {

    private String token, chatId, text;

    public SendMessageRequest(String token, String chatId, String text) {
        super(APIMethods.Message.SEND);
        this.chatId = chatId;
        this.text = text;
        this.token = token;
    }

    public RegistrationResponse execute() throws ResponseException {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put(APIKeys.TOKEN, token);
        hashMap.put(APIKeys.CHAT_ID, chatId);
        hashMap.put(APIKeys.TEXT, text);

        String response = POST.execute(getUrl(), hashMap, getMethod());
        return new RegistrationResponse(response, getUrl());
    }
}
