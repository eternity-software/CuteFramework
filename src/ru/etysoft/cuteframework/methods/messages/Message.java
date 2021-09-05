package ru.etysoft.cuteframework.methods.messages;

import org.json.JSONObject;
import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.methods.chat.ServiceData;
import ru.etysoft.cuteframework.methods.user.User;

public class Message {
    private int id;
    private int accountId;
    private boolean read;
    private String text;
    private String time;
    private String displayName;
    private String type;
    private ServiceData serviceData;
    private String attachmentPath;
    private String attachmentType;
    private AttachmentData attachmentData;
    private User sender;

    public Message(int id, int accountId, boolean read, String text, String time, String displayName, String type, ServiceData serviceData, String attachmentPath, String attachmentType, AttachmentData attachmentData, User sender) {
        this.id = id;
        this.accountId = accountId;
        this.read = read;
        this.text = text;
        this.time = time;
        this.displayName = displayName;
        this.type = type;
        this.serviceData = serviceData;
        this.attachmentPath = attachmentPath;
        this.attachmentType = attachmentType;
        this.attachmentData = attachmentData;
        this.sender = sender;
    }

    public Message(JSONObject messageObj) {
        id = messageObj.getInt(APIKeys.ID);
        accountId = messageObj.getInt(APIKeys.ID);


        time = messageObj.getString(APIKeys.TIME);
        type = messageObj.getString(APIKeys.TYPE);
        read = messageObj.getBoolean(APIKeys.Message.READ);


        if (messageObj.has(APIKeys.Attachment.ATTACHMENT)) {
            JSONObject attachmentObj = messageObj.getJSONObject(APIKeys.Attachment.ATTACHMENT);
            attachmentPath = attachmentObj.getString(APIKeys.Attachment.PATH);
            attachmentType = attachmentObj.getString(APIKeys.TYPE);
            JSONObject attachmentDataObj = attachmentObj.getJSONObject(APIKeys.DATA);
            attachmentData = AttachmentData.fromJSON(attachmentDataObj);
        }

        if (type.equals(Type.SERVICE)) {
            JSONObject jsonObject = messageObj.getJSONObject(APIKeys.DATA);
            serviceData = new ServiceData(jsonObject);
        }
        else
        {
            sender = new User(messageObj.getJSONObject(APIKeys.Message.FROM));
            text = messageObj.getString(APIKeys.TEXT);
        }
    }

    public User getSender() {
        return sender;
    }

    public boolean isRead() {
        return read;
    }

    public AttachmentData getAttachmentData() {
        return attachmentData;
    }

    public String getAttachmentPath() {
        return CuteFramework.mediaDomain + attachmentPath;
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public ServiceData getServiceData() {
        return serviceData;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public int getAccountId() {
        return accountId;
    }


    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }

    public static class Type {
        public static final String SERVICE = "service";
        public static final String USER = "user";
    }


    public static class Status {
        public static final String AVAILABLE = "Y";
        public static final String DELETED = "N";
    }

}
