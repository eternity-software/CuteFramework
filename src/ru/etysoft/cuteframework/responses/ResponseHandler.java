package ru.etysoft.cuteframework.responses;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.responses.errors.ErrorHandler;
import ru.etysoft.cuteframework.data.APIKeys;

/**
 * Abstract class for JSON response handling
 *
 * @author Mikhail Karlov
 */
public abstract class ResponseHandler {

    private String stringResponse;
    private JSONObject jsonResponse;
    private String url;

    public ResponseHandler(String jsonResponse, String url) throws JSONException {
        this.stringResponse = jsonResponse;
        this.url = url;
        this.jsonResponse = new JSONObject(jsonResponse);
        if(isSuccess())
        {
            onSuccess();
        }
    }

    /**
     * Checking "type" string in JSONResponse
     *
     * @return Returns a boolean (if "type" equals "success")
     */
    public boolean isSuccess()  {
        try
        {
            return jsonResponse.getString(APIKeys.TYPE).equals("success");
        }
       catch (JSONException e)
       {
           return false;
       }
    }

    public abstract void onSuccess();

    /**
     * Information about response and request
     *
     * @return Returns a JSONObject String with "response" and "request"
     */
    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("response", stringResponse);
        jsonObject.put("request", url);
        return jsonObject.toString();
    }

    public String getUrl() {
        return url;
    }

    public JSONObject getJsonResponse() {
        return jsonResponse;
    }

    public ErrorHandler getErrorHandler() throws JSONException {
        return new ErrorHandler(stringResponse);
    }

}
