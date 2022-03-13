package ru.etysoft.cuteframework.consts;

public class APIMethods {

    public static class Account
    {

        private static final String ACCOUNT_PREFIX = "account/";

        public static final String REGISTER_DEVICE = ACCOUNT_PREFIX + "registerDevice";
        public static final String REGISTER = ACCOUNT_PREFIX + "register";
        public static final String LOGIN = ACCOUNT_PREFIX + "login";
        public static final String TERMINATE_OTHER_SESSIONS = ACCOUNT_PREFIX + "terminateOtherSessions";
        public static final String TERMINATE_SESSION = ACCOUNT_PREFIX + "terminateSession";
        public static final String CHANGE_PASSWORD = ACCOUNT_PREFIX + "changePassword";
        public static final String RESEND_CODE  = ACCOUNT_PREFIX + "resendConfirmCode";
        public static final String CONFIRM  = ACCOUNT_PREFIX + "confirm";
        public static final String GET_ALL_SESSIONS  = ACCOUNT_PREFIX + "getAllSessions";
        public static final String GET  = ACCOUNT_PREFIX + "get";
        public static final String EDIT  = ACCOUNT_PREFIX + "edit";
    }

    public static class Chat
    {
        private static final String CHAT_PREFIX = "chat/";

        public static final String CREATE  = CHAT_PREFIX + "create";
        public static final String GET_INFO  = CHAT_PREFIX + "getInfo";
        public static final String GET_LIST  = CHAT_PREFIX + "getList";
        public static final String GET_HISTORY  = CHAT_PREFIX + "getHistory";
        public static final String SEND_MESSAGE  = CHAT_PREFIX + "sendMessage";
        public static final String REMOVE_MESSAGE  = CHAT_PREFIX + "removeMessage";
        public static final String SET_PERMISSION_GROUP  = CHAT_PREFIX + "setPermissionsGroup";
        public static final String ADD_MEMBER  = CHAT_PREFIX + "addMember";
        public static final String BAN_MEMBER  = CHAT_PREFIX + "banMember";
        public static final String UNBAN_MEMBER  = CHAT_PREFIX + "unbanMember";
    }

}
