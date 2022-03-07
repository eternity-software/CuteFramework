package ru.etysoft.cuteframework.sockets.events;

import org.json.JSONObject;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.sockets.Event;

public class MemberStateChangedEvent extends Event {

    private String state;
    private long accountId;

    public MemberStateChangedEvent( String eventJson) {
        super(eventJson);
    }

    @Override
    public void processEvent(String eventJson) {
        JSONObject jsonObject = new JSONObject(eventJson).getJSONObject(APIKeys.DATA);
        state = jsonObject.getString(APIKeys.STATE);
        accountId = jsonObject.getLong(APIKeys.ACCOUNT_ID);

    }


    public long getAccountId() {
        return accountId;
    }

    public String getState() {
        return state;
    }

    public static class States
    {
        public static final String ONLINE = "online";
        public static final String OFFLINE = "offline";
        public static final String TYPING = "typing";
    }
}
