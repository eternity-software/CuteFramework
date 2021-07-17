package ru.etysoft.cuteframework.api.request.methods;

import ru.etysoft.cuteframework.api.request.APIMethods;
import ru.etysoft.cuteframework.api.request.Pair;
import ru.etysoft.cuteframework.api.request.RequestHolder;
import ru.etysoft.cuteframework.api.response.APIKeys;
import ru.etysoft.cuteframework.api.response.methods.InformationResponseHandler;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Request;

public class InformationRequest extends RequestHolder {
    private String sessionKey;

    public InformationRequest(String sessionKey){
        super(APIMethods.GETINFORNATION);
        this.sessionKey = sessionKey;
        setParams(Pair.make(APIKeys.SESSION, sessionKey));
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public InformationResponseHandler execute() throws ResponseException {
        Request request = makeRequest();
        return new InformationResponseHandler(request.processAPI(), request.getFormattedURL());
    }


}
