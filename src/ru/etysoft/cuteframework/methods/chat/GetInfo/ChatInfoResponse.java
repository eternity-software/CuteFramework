package ru.etysoft.cuteframework.methods.chat.GetInfo;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.chat.Chat;
import ru.etysoft.cuteframework.methods.chat.ChatMember;
import ru.etysoft.cuteframework.responses.Response;

public class ChatInfoResponse extends Response {
  private Chat chat;
  
  private List<ChatMember> memberList;
  
  public ChatInfoResponse(String jsonResponse, String url) throws JSONException {
    super(jsonResponse, url);
  }
  
  public void onSuccess() {
    JSONObject chatObj = getJsonResponse().getJSONObject("data").getJSONObject("chat");
    String name = chatObj.getString("name");
    String description = chatObj.getString("description");
    int id = chatObj.getInt("id");
    int membersCount = getJsonResponse().getJSONObject("data").getInt("membersCount");
    String type = chatObj.getString("type");
    String state = chatObj.getString("state");
    String chatAvatarPath = null;
    if (!chatObj.isNull("avatar"))
      chatAvatarPath = CuteFramework.MEDIA_DOMAIN + chatObj.getString("avatar");
    this.chat = new Chat(name, id, type, description, state, chatAvatarPath, membersCount);
    JSONArray jsonArray = getJsonResponse().getJSONObject("data").getJSONArray("members");
    this.memberList = new ArrayList<>();
    for (int i = 0; i < jsonArray.length(); i++) {
      JSONObject memberObj = jsonArray.getJSONObject(i);
      String displayName = memberObj.getString("displayName");
      String typeMember = memberObj.getString("type");
      long memberId = memberObj.getLong("id");
      String avatar = memberObj.getString("avatar");
      ChatMember chatMember = new ChatMember(memberId, displayName, typeMember, CuteFramework.MAIN_DOMAIN.substring(0, CuteFramework.MAIN_DOMAIN.length() - 1) + avatar);
      this.memberList.add(chatMember);
    } 
  }
  
  public List<ChatMember> getMembers() throws ResponseException {
    if (this.memberList == null)
      throw new ResponseException("Members is null! (isn't success!)"); 
    return this.memberList;
  }
  
  public Chat getChat() throws ResponseException {
    if (this.chat == null)
      throw new ResponseException("Chat is null!"); 
    return this.chat;
  }
}
