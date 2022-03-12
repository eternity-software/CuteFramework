package ru.etysoft.cuteframework.models;

import org.json.JSONObject;
import ru.etysoft.cuteframework.consts.APIKeys;

public class Device  extends Model{

    private String name, type, address, id;
    private boolean isBlocked;

    public Device(JSONObject jsonObject) {
        super(jsonObject);

        name = jsonObject.getString(APIKeys.Device.NAME);
        type = jsonObject.getString(APIKeys.Device.TYPE);
        address = jsonObject.getString(APIKeys.Device.ADDRESS);
        id = jsonObject.getString(APIKeys.Device.ID);
        isBlocked = jsonObject.getBoolean(APIKeys.Device.IS_BLOCKED);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    public String getId() {
        return id;
    }

    public boolean isBlocked() {
        return isBlocked;
    }
}
