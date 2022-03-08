package ru.etysoft.cuteframework.requests;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Set;

import org.jetbrains.annotations.NotNull;
import ru.etysoft.cuteframework.Logger;
import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.exceptions.NotCachedException;
import ru.etysoft.cuteframework.exceptions.OneRowOperationException;
import ru.etysoft.cuteframework.exceptions.ResponseException;
import ru.etysoft.cuteframework.storage.Cache;

/**
 * Making a server-request
 * @author Mikahil Karlov
 */
public class Request {

    private String method;
    private Set<Pair> params;


    public Request(String method, Set<Pair> params) {
        this.method = method;
        this.params = params;
    }

    /**
     * Transform HashMap to URL-looking Stirng
     * @param params HashMap with request args
     * @return String
     */
    public static String getArgsAsString(@NotNull Set<Pair> params) {
        String args = "?";

        int i = 0;
        for (Pair pair : params) {
            String key = pair.getKey();
            String arg = key + "=" + pair.getValue();
            args += arg;

            if (i != params.size() - 1) {
                args += "&";
            }
            i++;
        }

        if(args.equals("?")) {
            args = "";
        }

        return args;
    }


    public String getURL()
    {
        return CuteFramework.API_DOMAIN + method + getArgsAsString(params);
    }

    public String getFormattedURL()
    {
       return getURL();
    }


    public String executeAPIWithToken() throws ResponseException, SQLException, NotCachedException {
        HashMap<String, String> headers = new HashMap<>();
        headers.put(APIKeys.Headers.TOKEN, Cache.getUserAccount().getToken());
        return executeAPI(headers);
    }

    public String executeAPI() throws ResponseException {
        return executeAPI(new HashMap<>());
    }

    public String executeAPI(HashMap<String, String> headers) throws ResponseException {
        String response = GET.execute(getFormattedURL(), headers);
        Logger.logResponse(response, method);
        return response;
    }

    public String execute() throws ResponseException {
        return GET.execute(getURL());
    }


}
