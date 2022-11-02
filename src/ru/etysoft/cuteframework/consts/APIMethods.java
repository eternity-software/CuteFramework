package ru.etysoft.cuteframework.consts;

public class APIMethods {

    public static class Authorization
    {

        private static final String AUTHORIZATION_PREFIX = "auth/";
        public static final String SIGN_UP = AUTHORIZATION_PREFIX + "signUp";
        public static final String SIGN_IN = AUTHORIZATION_PREFIX + "signIn";

        public static final String REGISTER_DEVICE = AUTHORIZATION_PREFIX + "registerDevice";
        public static final String TERMINATE_OTHER_SESSIONS = AUTHORIZATION_PREFIX + "terminateOtherSessions";
        public static final String TERMINATE_SESSION = AUTHORIZATION_PREFIX + "terminateSession";
        public static final String CHANGE_PASSWORD = AUTHORIZATION_PREFIX + "changePassword";
        public static final String RESEND_CODE  = AUTHORIZATION_PREFIX + "resendConfirmCode";
        public static final String CONFIRM  = AUTHORIZATION_PREFIX + "confirm";
        public static final String GET_ALL_SESSIONS  = AUTHORIZATION_PREFIX + "getAllSessions";
        public static final String GET  = AUTHORIZATION_PREFIX + "get";
        public static final String EDIT  = AUTHORIZATION_PREFIX + "edit";
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
        public static final String CLEAR_HISTORY  = CHAT_PREFIX + "clearHistory";
        public static final String EDIT_MESSAGE  = CHAT_PREFIX + "editMessage";
        public static final String EDIT  = CHAT_PREFIX + "edit";
        public static final String LEAVE  = CHAT_PREFIX + "leave";
        public static final String GET_MEMBERS  = CHAT_PREFIX + "getMembers";
    }

    public static class Music
    {
        private static final String MUSIC_PREFIX = "music/";

        public static final String SEARCH  = MUSIC_PREFIX + "search";
        public static final String GET_TRACK  = MUSIC_PREFIX + "getTrack";

    }

}
