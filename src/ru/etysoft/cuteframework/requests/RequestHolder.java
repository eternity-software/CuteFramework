package ru.etysoft.cuteframework.requests;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import ru.etysoft.cuteframework.CuteFramework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Hold the method name and params
 *
 * @author Mikhail Karlov
 */
public abstract class RequestHolder {

    private String method;
    private Set<Pair> deprecatedParams = new HashSet<>();

    private HashMap<String, Object> headers = new HashMap<>();
    private JSONObject body = new JSONObject();

    public RequestHolder(String method) {
        this.method = method;
    }

    public void addBody(String key, Object value)
    {
        body.put(key, value);
    }

    public void addBody(Pair... pairs)
    {
        for(Pair pair : pairs)
        {
            body.put(pair.getKey(), pair.getValue());
        }
    }

    public String getBody()
    {
        return body.toString();
    }

    public void addHeaders(Pair... pairs) {
        for(Pair pair : pairs)
        {
            headers.put(pair.getKey(), pair.getValue());
        }
    }


    public HashMap<String, Object> getHeaders() {
        return headers;
    }

    public Set<Pair> getParams() {
        return deprecatedParams;
    }

    public String getUrl() { return CuteFramework.API_DOMAIN + getMethod(); }


    /**
     * Transform HashMap to URL-looking Stirng
     * @param params HashMap with request args
     * @return String
     */
    public static String getArgsAsString(@NotNull Set<Pair> params) {
        String args = "?";

        Set<Pair> finalParams = new HashSet<>();

        for (Pair pair : params) {
            if(pair.getValue() != null)
            {
                finalParams.add(pair);
            }
        }

        int i = 0;
        for (Pair pair : finalParams) {
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
        return CuteFramework.API_DOMAIN + method ;
    }

    public String getFormattedURL()
    {
        //return getURL() + getArgsAsString();
        return getURL();
    }

    public Request makeRequest() {
        return new Request(method, deprecatedParams);
    }

    public String getMethod() {
        return method;
    }
}
