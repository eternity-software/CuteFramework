package ru.etysoft.cuteframework.consts;

public class APIKeys {

    public static class Headers
    {
        public static final String VERSION = "Version";
        public static final String TOKEN = "Token";
    }

    public static class Response
    {
        public static final String DATA = "data";
        public static final String TYPE = "type";

    }

    public static class Session
    {
        public static final String IS_ACTIVE = "isActive";
        public static final String IS_BLOCKED = "isBlocked";
        public static final String ID = "id";
        public static final String DEVICE = "device";
    }

    public static class Device
    {
        public static final String NAME = "name";
        public static final String TYPE = "type";
        public static final String ADDRESS = "ip";
        public static final String IS_BLOCKED = "isBlocked";
        public static final String ID = "id";

    }

    public static class Account
    {
        public static final String DEVICE_ID = "deviceId";
        public static final String ACCOUNT = "account";
        public static final String LOGIN = "login";
        public static final String PASSWORD = "password";
        public static final String OLD_PASSWORD = "oldPassword";
        public static final String NEW_PASSWORD = "newPassword";
        public static final String TYPE = "type";
        public static final String EMAIL = "email";
        public static final String NAME = "name";
        public static final String STATUS = "status";
        public static final String BIO = "bio";
        public static final String IS_CONFIRMED = "isConfirmed";
        public static final String IS_BLOCKED = "isBlocked";
        public static final String ADDITIONAL_INFO = "additionalInfo";
        public static final String ID = "id";
        public static final String CODE = "code";
        public static final String ACCOUNT_ID = "accountId";
        public static final String TOKEN = "token";
        public static final String EXPIRES_IN = "expiresIn";
        public static final String SESSION_ID = "sessionId";
        public static final String GROUP = "group";
        public static final String PERMISSIONS_GROUP = "permissionsGroup";
    }

    public static class Chat
    {
        public static final String CHAT_ID = "chatId";
        public static final String TYPE = "type";
        public static final String NAME = "name";
        public static final String DESCRIPTION = "description";
        public static final String IS_BLOCKED = "isBlocked";
        public static final String ID = "id";
        public static final String CHATS = "chats";
        public static final String MESSAGE = "message";
        public static final String MEMBERS_COUNT = "membersCount";
        public static final String LAST_CHAT_ID = "lastChatId";
        public static final String LAST_MESSAGE_ID = "lastMessageId";

    }

    public static class Message
    {
        public static final String TEXT = "text";
        public static final String MESSAGE_ID = "messageId";
        public static final String MESSAGES = "messages";
        public static final String ID = "id";
        public static final String TYPE = "type";
        public static final String ACCOUNT_INFO = "accountInfo";
        public static final String CREATED_AT = "createdAt";
        public static final String UPDATED_AT = "updatedAt";
        public static final String SENDER = "sender";
        public static final String SERVICE_DATA = "serviceData";
    }
    public static class ServiceData
    {
        public static final String CHAT_NAME = "chatName";
    }




}
