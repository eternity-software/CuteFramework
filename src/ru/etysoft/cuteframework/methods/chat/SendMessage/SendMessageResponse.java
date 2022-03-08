package ru.etysoft.cuteframework.methods.chat.SendMessage;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.methods.messages.Message;
import ru.etysoft.cuteframework.responses.Response;

public class SendMessageResponse extends Response {
  private Message message;
  
  public SendMessageResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
    System.out.println(jsonResponse);
  }
  
  public Message getMessage() {
    return this.message;
  }
  
  public void onSuccess() {
    JSONObject respObj = getJsonResponse().getJSONObject("data").getJSONObject("message");
    this.message = new Message(respObj);
  }
}
