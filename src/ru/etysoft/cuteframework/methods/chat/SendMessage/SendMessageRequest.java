package ru.etysoft.cuteframework.methods.chat.SendMessage;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.requests.Pair;
import ru.etysoft.cuteframework.requests.Request;
import ru.etysoft.cuteframework.requests.RequestHolder;

public class SendMessageRequest extends RequestHolder {
  private String token;
  
  private String chatId;
  
  private String text;
  
  private String mediaId;
  
  private String forwardedId;
  
  public SendMessageRequest(String token, String chatId, String text, String forwardedId) throws UnsupportedEncodingException {
    super("chat/sendMessage");
    this.chatId = chatId;
    text = URLEncoder.encode(text, "UTF-8");
    this.text = text;
    this.token = token;
    this.forwardedId = forwardedId;
    setParams(new Pair[] { Pair.make("token", token), 
          Pair.make("chatId", chatId), 
          Pair.make("forwardedId", String.valueOf(forwardedId)), 
          Pair.make("text", text) });
  }
  
  public SendMessageRequest(String token, String chatId, String text, String mediaId, String forwardedId) throws UnsupportedEncodingException {
    super("chat/sendMessage");
    this.chatId = chatId;
    text = URLEncoder.encode(text, "UTF-8");
    this.text = text;
    this.token = token;
    this.mediaId = mediaId;
    this.forwardedId = forwardedId;
    setParams(new Pair[] { Pair.make("token", token), 
          Pair.make("chatId", chatId), 
          Pair.make("text", text), 
          Pair.make("forwardedId", String.valueOf(forwardedId)), 
          Pair.make("mediaId", mediaId) });
  }
  
  public SendMessageResponse execute() throws ResponseException {
    Request request = makeRequest();
    return new SendMessageResponse(request.processAPI(), request.getFormattedURL());
  }
}
