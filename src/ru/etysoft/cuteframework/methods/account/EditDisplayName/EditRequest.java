package ru.etysoft.cuteframework.methods.account.EditDisplayName;

import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

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
                       String statusText, String bioText){
        super(APIMethods.Account.EDIT);
        this.token = token;
        this.displayName = displayName;
        setParams(Pair.make(APIKeys.TOKEN, token),
                Pair.make(APIKeys.DISPLAY_NAME, displayName),
                Pair.make(APIKeys.STATUS, statusText),
                Pair.make(APIKeys.BIO, bioText));
    }

    public EditResponse execute() throws ResponseException {
        Request request = makeRequest();
        return (new EditResponse(request.processAPI(), request.getFormattedURL()));
    }
}
