package ru.etysoft.cuteframework.legacy.methods.chat.ChangeAvatar;

import org.json.JSONException;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class ChangeAvatarResponse extends ResponseHandler {
    public ChangeAvatarResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }
    @Override
    public void onSuccess() {
    }
}
