package ru.etysoft.cuteframework.models;

import org.json.JSONObject;
import ru.etysoft.cuteframework.consts.APIKeys;

public class Session extends Model{

    private boolean isActive, isBlocked;
    private String id;
    private Device device;

    public Session(JSONObject jsonObject) {
        super(jsonObject);
        device = new Device(jsonObject.getJSONObject(APIKeys.Session.DEVICE));
        id = jsonObject.getString(APIKeys.Session.ID);
        isActive = jsonObject.getBoolean(APIKeys.Session.IS_ACTIVE);
        isBlocked = jsonObject.getBoolean(APIKeys.Session.IS_BLOCKED);
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public String getId() {
        return id;
    }

    public Device getDevice() {
        return device;
    }
}
