package ru.etysoft.cuteframework.consts;

public class APIMethods {

    public static class Account
    {

        private static final String ACCOUNT_PREFIX = "account/";

        public static final String REGISTER_DEVICE = ACCOUNT_PREFIX + "registerDevice";
        public static final String REGISTER = ACCOUNT_PREFIX + "register";
        public static final String LOGIN = ACCOUNT_PREFIX + "login";
        public static final String CHANGE_PASSWORD = ACCOUNT_PREFIX + "changePassword";
        public static final String RESEND_CODE  = ACCOUNT_PREFIX + "resendConfirmCode";
        public static final String CONFIRM  = ACCOUNT_PREFIX + "confirm";
        public static final String GET  = ACCOUNT_PREFIX + "get";
    }

}
