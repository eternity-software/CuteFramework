package ru.etysoft.cuteframework.methods.account.ChangeCover;

import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class ChangeCoverRequest extends RequestHolder {
    private final String mediaId, token;
    public ChangeCoverRequest(String token, String mediaId) {
        super(APIMethods.Account.CHANGE_COVER);
        this.mediaId = mediaId;
        this.token = token;
        setParams(Pair.make(APIKeys.TOKEN, token), Pair.make(APIKeys.Media.MEDIA_ID, mediaId));
    }

    public String getToken() {
        return token;
    }

    public String getMediaId() {
        return mediaId;
    }

    public ChangeCoverResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new ChangeCoverResponse(request.processAPI(), request.getURL());
    }

}
