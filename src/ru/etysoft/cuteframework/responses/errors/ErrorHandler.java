package ru.etysoft.cuteframework.responses.errors;

import org.json.JSONException;
import ru.etysoft.cuteframework.json.JSONArrayList;

/**
 * Simple error handler with error-checks and information about response error
 * @author Mikhail Karlov
 */
public class ErrorHandler {

    String jsonResponse;
    JSONArrayList errorCodes;

    public ErrorHandler(String jsonResponse) throws JSONException {
        this.jsonResponse = jsonResponse;

        //TODO: Обработка не работает. Переписать под новое API
        errorCodes = new JSONArrayList(jsonResponse);
    }

    public boolean isSessionExpired() {
        return errorCodes.has("Authorization unsuccessful");
    }

    public String getErrorCode() {
        return null;
    }

}
