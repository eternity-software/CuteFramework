package ru.etysoft.cuteframework.methods.chat.GetHistory;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.messages.Message;
import ru.etysoft.cuteframework.responses.ResponseHandler;

public class GetMessageListResponse extends ResponseHandler {
  private List<Message> messages;
  
  private long firstMessageId;
  
  public GetMessageListResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {
    JSONArray jsonArray = getJsonResponse().getJSONObject("data").getJSONArray("messages");
    this.firstMessageId = getJsonResponse().getJSONObject("data").getLong("firstMessageId");
    this.messages = new ArrayList<>();
    for (int i = 0; i < jsonArray.length(); i++) {
      JSONObject messageObj = jsonArray.getJSONObject(i);
      Message message = new Message(messageObj);
      this.messages.add(message);
    } 
  }
  
  public long getFirstMessageId() {
    return this.firstMessageId;
  }
  
  public List<Message> getMessages() throws ResponseException {
    if (this.messages == null)
      throw new ResponseException("Messages is null! (isn't success!)"); 
    return this.messages;
  }
}
