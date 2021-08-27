package ru.etysoft.cuteframework.methods.chat.ChangeAvatar;

import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class ChangeAvatarRequest extends RequestHolder {
    private String mediaId, token;
    public ChangeAvatarRequest(String token, String mediaId, String chatId) {
        super(APIMethods.Chat.CHANGE_AVATAR);
        this.mediaId = mediaId;
        this.token = token;
        setParams(Pair.make(APIKeys.TOKEN, token), Pair.make(APIKeys.MEDIA_ID, mediaId),
                Pair.make(APIKeys.CHAT_ID, chatId));
    }
    public ChangeAvatarResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new ChangeAvatarResponse(request.processAPI(), request.getURL());
    }

}
