package ru.etysoft.cuteframework.methods.account.EditDisplayName;

import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class EditRequest extends RequestHolder {
    private String token;
    private String display_name;

    public EditRequest(String token, String display_name){
        super(APIMethods.Account.EDIT);
        this.token = token;
        this.display_name = display_name;
        setParams(Pair.make(APIKeys.TOKEN, token),
                Pair.make(APIKeys.DISPLAY_NAME, display_name));
    }

    public EditResponse execute() throws ResponseException {
        Request request = makeRequest();
        return (new EditResponse(request.processAPI(), request.getFormattedURL()));
    }
}
