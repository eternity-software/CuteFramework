package ru.etysoft.cuteframework.responses.errors;

import org.json.JSONException;
import org.json.JSONObject;
import ru.etysoft.cuteframework.json.JSONArrayList;

/**
 * Simple error handler with error-checks and information about response error
 * @author Mikhail Karlov
 */
public class ErrorHandler {

    String jsonResponse;
    JSONObject errorCodes;
    String message;
    int code;

    public ErrorHandler(String jsonResponse) throws JSONException {
        this.jsonResponse = jsonResponse;

        //TODO: Обработка не работает. Переписать под новое API
        errorCodes = new JSONObject(jsonResponse);
        message = errorCodes.getJSONObject("data").getString("message");
        code = errorCodes.getJSONObject("data").getInt("code");
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
