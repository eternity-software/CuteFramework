package ru.etysoft.cuteframework.data;

/**
 * List of all model/method keys
 */
public class APIMethods {

    public static class Account
    {
        public final static String LOGIN = "account/login";
        public final static String SEND_CONFIRMATION_CODE = "account/sendConfirmCode";
        public final static String CONFIRMATION = "account/confirm";
        public final static String AUTHENTICATION = "account/auth";
        public final static String GET = "account/get";
        public final static String REGISTRATION = "account/create";
        public final static String EDIT = "account/edit";
        public final static String CHANGE_AVATAR = "account/changeAvatar";
        public final static String CHANGE_COVER = "account/changeCover";
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
        public final static String EDIT = "chat/edit";
        public final static String LEAVE = "chat/leave";
        public final static String CHANGE_AVATAR = "chat/changeAvatar";
        public final static String CLEAR_HISTORY = "chat/clearHistory";
        public final static String GET_HISTORY = "chat/getHistory";
        public final static String SEND_MESSAGE = "chat/sendMessage";
        public final static String REMOVE_MESSAGE = "chat/removeMessage";
    }


    public static class Users{
        public final static String GET_USER = "users/get";
        public final static String SEARCH_USER = "users/search";
    }

    public static class Media{
        public final static String UPLOAD_IMAGE = "media/uploadImage";
    }

    public static class Friend {
        public final static String GET_FRIENDS = "friend/getList";
        public final static String ADD  = "friend/add";
        public final static String GET_INCOMING_REQUESTS = "friend/getIncomingRequests";
        public final static String GET_OUTGOING_REQUESTS = "friend/getOutgoingRequests";
        public final static String REMOVE = "friend/remove";
    }

}

