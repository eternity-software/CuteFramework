package ru.etysoft.cuteframework.responses;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.exceptions.NoSuchValueException;
import ru.etysoft.cuteframework.responses.errors.ErrorHandler;


/**
 * Abstract class for JSON response handling
 *
 * @author Mikhail Karlov
 */
public abstract class Response {

    private String stringResponse;
    private JSONObject jsonResponse;
    private String url;

    public Response(String jsonResponse, String url) throws JSONException {
        this.stringResponse = jsonResponse;
        this.url = url;
        this.jsonResponse = new JSONObject(jsonResponse);
        if(isSuccess())
        {
            onSuccess();
        }
    }

    public void checkNotNull(Object value) throws NoSuchValueException {
        if(value == null) throw new NoSuchValueException();
    }

    /**
     * Success check
     *
     * @return Returns a boolean
     */
    public boolean isSuccess()  {
        try
        {
            return !jsonResponse.has(APIKeys.Response.ERROR);
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
