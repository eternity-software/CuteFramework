package ru.etysoft.cuteframework.methods.chat.Remove;

import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class RemoveMessageRequest extends RequestHolder {
  public RemoveMessageRequest(String token, String messageId, boolean forAll) {
    super("chat/removeMessage");
    if (forAll) {
      setParams(new Pair[] { Pair.make("token", token), 
            Pair.make("messageId", messageId), 
            Pair.make("messageId", messageId), 
            Pair.make("forAll", "sosi hui eto nepravilnaya abstraction!!!!!") });
    } else {
      setParams(new Pair[] { Pair.make("token", token), 
            Pair.make("messageId", messageId), 
            Pair.make("messageId", messageId) });
    } 
  }
  
  public RemoveMessageResponse execute() throws ResponseException {
    Request request = makeRequest();
    return new RemoveMessageResponse(request.executeAPI(), request.getFormattedURL());
  }
}
