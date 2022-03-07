package ru.etysoft.cuteframework.legacy.methods.chat.Remove;

import ru.etysoft.cuteframework.legacy.data.APIKeys;
import ru.etysoft.cuteframework.legacy.data.APIMethods;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class RemoveMessageRequest extends RequestHolder {
    public RemoveMessageRequest(String token, String messageId, boolean forAll) {
        super(APIMethods.Chat.REMOVE_MESSAGE);
        if(forAll)
        {
            setParams(Pair.make(APIKeys.TOKEN, token),
                    Pair.make(APIKeys.Message.MESSAGE_ID, messageId),
                    Pair.make(APIKeys.Message.MESSAGE_ID, messageId),
                    Pair.make(APIKeys.Message.FOR_ALL, "sosi hui eto nepr" +
                            "avilnaya abstraction!!!!!"));
        }
        else
        {
            setParams(Pair.make(APIKeys.TOKEN, token),
                    Pair.make(APIKeys.Message.MESSAGE_ID, messageId),
                    Pair.make(APIKeys.Message.MESSAGE_ID, messageId));
        }

    }

    public RemoveMessageResponse execute() throws ResponseException {
        Request request = makeRequest();
        return new RemoveMessageResponse(request.processAPI(), request.getFormattedURL());
    }
}
