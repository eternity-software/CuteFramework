package ru.etysoft.cuteframework.methods.messages.GetList;

import com.sun.corba.se.impl.oa.poa.AOMEntry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.methods.chat.Chat;
import ru.etysoft.cuteframework.methods.chat.ServiceData;
import ru.etysoft.cuteframework.methods.messages.AttachmentData;
import ru.etysoft.cuteframework.methods.messages.Message;
import ru.etysoft.cuteframework.responses.ResponseHandler;

import java.util.ArrayList;
import java.util.List;

public class GetMessageListResponse extends ResponseHandler {

    private List<Message> messages;

    public GetMessageListResponse(String jsonResponse, String url) throws JSONException {
        super(jsonResponse, url);
    }

    @Override
    public void onSuccess() {
        JSONArray jsonArray = getJsonResponse().getJSONObject(APIKeys.DATA).getJSONArray(APIKeys.MESSAGES);

        messages = new ArrayList<>();

        for(int i = 0; i < jsonArray.length(); i++)
        {
            JSONObject messageObj = jsonArray.getJSONObject(i);
            int id = messageObj.getInt(APIKeys.ID);
            int accountId = messageObj.getInt(APIKeys.ACCOUNT_ID);
            int chatId = messageObj.getInt(APIKeys.CHAT_ID);
            String text = messageObj.getString(APIKeys.TEXT);
            String selfStatus = messageObj.getString(APIKeys.SELF_STATUS);
            String displayName = messageObj.getString(APIKeys.DISPLAY_NAME);
            String time = messageObj.getString(APIKeys.TIME);
            String type = messageObj.getString(APIKeys.TYPE);
            String avatarPath = messageObj.getString(APIKeys.AVATAR_PATH);

            String attachmentType = null;
            String attachmentPath = null;
            AttachmentData attachmentData = null;

            if(!messageObj.isNull(APIKeys.ATTACHMENT_PATH))
            {
                attachmentPath = messageObj.getString(APIKeys.ATTACHMENT_PATH);
                JSONObject attachmentDataObj = messageObj.getJSONObject(APIKeys.ATTACHMENT_DATA);
                attachmentData = AttachmentData.fromJSON(attachmentDataObj);
            }

            if(!messageObj.isNull(APIKeys.ATTACHMENT_TYPE))
            {
                attachmentType = messageObj.getString(APIKeys.ATTACHMENT_TYPE);
            }

            JSONObject jsonObject = messageObj.getJSONObject(APIKeys.SERVICE_DATA);





            ServiceData serviceData = new ServiceData(jsonObject);
            Message message = new Message(id, accountId, chatId, text, selfStatus, time, displayName, type, serviceData,
                    avatarPath, attachmentPath, attachmentType, attachmentData);
            messages.add(message);
        }
    }

    public List<Message> getMessages() throws ResponseException {
        if(messages == null) throw new ResponseException("Messages is null! (isn't success!)");
        return messages;
    }
}
