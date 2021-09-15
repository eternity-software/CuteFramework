package ru.etysoft.cuteframework.sockets.events;

import org.json.JSONObject;
import ru.etysoft.cuteframework.data.APIKeys;
import ru.etysoft.cuteframework.methods.messages.Message;
import ru.etysoft.cuteframework.sockets.Event;

public class NewMessageEvent extends Event {


    private Message message;

    public NewMessageEvent(String eventJson) {
        super(eventJson);
    }

    @Override
    public void processEvent(String eventJson) {
        JSONObject jsonObject = new JSONObject(eventJson).getJSONObject(APIKeys.DATA);
        message = new Message(jsonObject.getJSONObject(APIKeys.Message.MESSAGE));

    }

    public Message getMessage() {
        return message;
    }

}
