package ru.etysoft.cuteframework.data;

public class APIMethods {

    public static class Account
    {
        public final static String LOGIN = "account/login";
        public final static String CONFIRMATION_CODE = "account/sendConfirmCode";
        public final static String CONFIRMATION = "account/confirm";
        public final static String AUTHENTICATION = "account/auth";
        public final static String REGISTRATION = "account/create";
        public final static String EDIT = "account/edit";
        public final static String GET_INFORMATION = "account/get";

    }

    public static class Chat
    {
        public final static String CREATE = "chat/create";
        public final static String ADD_ADMIN = "chat/addAdmin";
        public final static String ADD_MEMBER = "chat/addMember";
        public final static String BLOCK_MEMBER = "chat/blockMember";
        public final static String UNBLOCK_MEMBER = "chat/unblockMember";
        public final static String MAKE_ADMIN = "chat/makeAdmin";
        public final static String DEMOTE_ADMIN = "chat/demoteAdmin";
        public final static String GET_LIST = "chat/getList";
        public final static String GET = "chat/get";
        public final static String LEAVE = "chat/leave";
        public final static String CLEAR_HISTORY = "chat/clearHistory";
    }

    public static class Message
    {
        public final static String GET_LIST = "message/getList";
        public final static String SEND = "message/send";
        public final static String REMOVE_FOR_SELF = "message/removeForSelf";
        public final static String REMOVE_FOR_ALL = "message/removeForAll";
    }



}

