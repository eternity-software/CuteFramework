package ru.etysoft.cuteframework.models;

import org.json.JSONObject;
import ru.etysoft.cuteframework.consts.APIKeys;

public class Device extends Model
{

    private String name, type, macAddress;

    public Device(JSONObject jsonObject) {
        super(jsonObject);

        name = jsonObject.getString(APIKeys.Device.NAME);
        type = jsonObject.getString(APIKeys.Device.TYPE);
        macAddress = jsonObject.getString(APIKeys.Device.ADDRESS);
    }

    public Device(String name, String type, String macAddress) {
        super(new JSONObject());
        this.name = name;
        this.type = type;
        this.macAddress = macAddress;

        JSONObject jsonObject = new JSONObject();

        jsonObject.put(APIKeys.Device.NAME, name);
        jsonObject.put(APIKeys.Device.TYPE, type);
        jsonObject.put(APIKeys.Device.ADDRESS, macAddress);

        setJsonModel(jsonObject);




    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getMacAddress() {
        return macAddress;
    }

    @Deprecated
    public String getId() {
        return "0";
    }

    @Deprecated
    public boolean isBlocked() {
        return false;
    }
}
