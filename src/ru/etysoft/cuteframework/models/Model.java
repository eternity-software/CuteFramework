package ru.etysoft.cuteframework.models;

import org.json.JSONObject;

public abstract class Model {

    private JSONObject jsonModel;

    public Model(JSONObject jsonObject)
    {
        this.jsonModel = jsonObject;
    }

    public JSONObject getJsonModel() {
        return jsonModel;
    }

    public void setJsonModel(JSONObject jsonModel) {
        this.jsonModel = jsonModel;
    }
}
