package ru.etysoft.cuteframework.methods.messages;

import ru.etysoft.cuteframework.Methods;
import ru.etysoft.cuteframework.methods.chat.ServiceData;

public class Message {
    private int id;
    private int accountId;
    private int chatId;
    private String text;
    private String selfStatus;
    private String time;
    private String displayName;
    private String type;
    private String avatarPath;
    private ServiceData serviceData;
    private String attachmentPath;
    private String attachmentType;
    private AttachmentData attachmentData;

    public Message(int id, int accountId, int chatId, String text, String selfStatus, String time, String displayName, String type, ServiceData serviceData,
                   String avatarPath, String attachmentPath, String attachmentType, AttachmentData attachmentData) {
        this.id = id;
        this.type = type;
        this.serviceData = serviceData;
        this.accountId = accountId;
        this.chatId = chatId;
        this.text = text;
        this.selfStatus = selfStatus;
        this.time = time;
        this.displayName = displayName;
        this.avatarPath = avatarPath;
        this.attachmentPath = attachmentPath;
        this.attachmentType = attachmentType;
        this.attachmentData = attachmentData;
    }

    public AttachmentData getAttachmentData() {
        return attachmentData;
    }

    public String getAttachmentPath() {
        return Methods.mediaDomain + attachmentPath;
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

    public String getAvatarPath() {
        if(avatarPath != null)
        {
            return Methods.mediaDomain + avatarPath;
        }
        return null;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getId() {
        return id;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getChatId() {
        return chatId;
    }

    public String getText() {
        return text;
    }

    public String getSelfStatus() {
        return selfStatus;
    }

    public String getTime() {
        return time;
    }

    public static class Type
    {
        public static final String SERVICE = "service";
        public static final String USER = "user";
    }


    public static class Status
    {
        public static final String AVAILABLE = "Y";
        public static final String DELETED = "N";
    }

}
