package ru.etysoft.cuteframework.methods.chat.SendMessage;

import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.chat.Remove.RemoveMessageResponse;
import ru.etysoft.cuteframework.requests.POST;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public class SendMessageRequest extends RequestHolder {

    private String token, chatId, text, mediaId;

    public SendMessageRequest(String token, String chatId, String text) throws UnsupportedEncodingException {
        super(APIMethods.Chat.SEND_MESSAGE);
        this.chatId = chatId;
        text = URLEncoder.encode(text, "UTF-8");
        this.text = text;
        this.token = token;
        setParams(Pair.make(APIKeys.TOKEN, token),
                Pair.make(APIKeys.CHAT_ID, chatId),
                Pair.make(APIKeys.TEXT, text));
    }

    public SendMessageRequest(String token, String chatId, String text, String mediaId) throws UnsupportedEncodingException {
        super(APIMethods.Chat.SEND_MESSAGE);
        this.chatId = chatId;
        text = URLEncoder.encode(text, "UTF-8");
        this.text = text;
        this.token = token;
        this.mediaId = mediaId;
        setParams(Pair.make(APIKeys.TOKEN, token),
                Pair.make(APIKeys.CHAT_ID, chatId),
                Pair.make(APIKeys.TEXT, text),
                Pair.make(APIKeys.Media.MEDIA_ID, mediaId));
    }

    public SendMessageResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new SendMessageResponse(request.processAPI(), request.getFormattedURL());

    }
}
