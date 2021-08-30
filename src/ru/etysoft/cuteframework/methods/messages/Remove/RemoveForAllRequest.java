package ru.etysoft.cuteframework.methods.messages.Remove;

import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class RemoveForAllRequest extends RequestHolder {
    public RemoveForAllRequest(String token, String messageId) {
        super(APIMethods.Message.REMOVE_FOR_ALL);
        setParams(Pair.make(APIKeys.TOKEN, token),
                Pair.make(APIKeys.Message.MESSAGE_ID, messageId));
    }

    public RemoveMessageResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new RemoveMessageResponse(request.processAPI(), request.getFormattedURL());
    }
}
