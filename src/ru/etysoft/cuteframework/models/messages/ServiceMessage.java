package ru.etysoft.cuteframework.models.messages;

import org.json.JSONObject;
import ru.etysoft.cuteframework.consts.APIKeys;

public class ServiceMessage extends Message{

    private ServiceData serviceData;

    public ServiceMessage(JSONObject jsonObject) {
        super(jsonObject);

        JSONObject serviceData = jsonObject.getJSONObject(APIKeys.Message.SERVICE_DATA);
        if(serviceData.getString(APIKeys.Message.TYPE).equals(ServiceData.TYPE_CHAT_CREATED))
        {
            this.serviceData = new ChatCreatedData(serviceData);
        }
    }

    public ServiceData getServiceData() {
        return serviceData;
    }
}
