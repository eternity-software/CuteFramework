package ru.etysoft.cuteframework.legacy.methods.account.Edit;

import ru.etysoft.cuteframework.legacy.data.APIKeys;
import ru.etysoft.cuteframework.legacy.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class EditRequest extends RequestHolder {
    private String token;
    private String displayName;
    private String statusText;


    public EditRequest(String token, String displayName){
        super(APIMethods.Account.EDIT);
        this.token = token;
        this.displayName = displayName;
        setParams(Pair.make(APIKeys.TOKEN, token),
                Pair.make(APIKeys.DISPLAY_NAME, displayName));
    }

    public EditRequest(String token, String displayName,
                       String statusText, String bioText, String login){
        super(APIMethods.Account.EDIT);
        this.token = token;
        this.displayName = displayName;
        try {
            setParams(Pair.make(APIKeys.TOKEN, token),
                    Pair.make(APIKeys.DISPLAY_NAME, URLEncoder.encode(displayName, "UTF-8")),
                    Pair.make(APIKeys.STATUS, URLEncoder.encode(statusText, "UTF-8")),
                    Pair.make(APIKeys.BIO, URLEncoder.encode(bioText, "UTF-8")),
                    Pair.make(APIKeys.LOGIN, URLEncoder.encode(login, "UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public EditResponse execute() throws ResponseException {
        Request request = makeRequest();
        return (new EditResponse(request.processAPI(), request.getFormattedURL()));
    }
}
