package ru.etysoft.cuteframework.models.messages;

import org.json.JSONObject;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.models.Model;

public class ServiceData extends Model {

    private String type;
    public final static String TYPE_CHAT_CREATED = "chatCreated";

    public ServiceData(JSONObject jsonObject) {
        super(jsonObject);
        type = jsonObject.getString(APIKeys.Message.TYPE);
    }




}
