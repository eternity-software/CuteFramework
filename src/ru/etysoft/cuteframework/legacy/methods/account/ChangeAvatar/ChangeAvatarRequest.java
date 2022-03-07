package ru.etysoft.cuteframework.legacy.methods.account.ChangeAvatar;

import ru.etysoft.cuteframework.legacy.data.APIKeys;
import ru.etysoft.cuteframework.legacy.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class ChangeAvatarRequest extends RequestHolder {
    private String mediaId, token;
    public ChangeAvatarRequest(String token, String mediaId) {
        super(APIMethods.Account.CHANGE_AVATAR);
        this.mediaId = mediaId;
        this.token = token;
        setParams(Pair.make(APIKeys.TOKEN, token), Pair.make(APIKeys.Media.MEDIA_ID, mediaId));
    }
    public ChangeAvatarResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new ChangeAvatarResponse(request.processAPI(), request.getURL());
    }

}
