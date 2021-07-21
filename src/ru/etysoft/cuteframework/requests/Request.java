package ru.etysoft.cuteframework.requests;

import java.util.Set;

import org.jetbrains.annotations.NotNull;
import ru.etysoft.cuteframework.Methods;
import ru.etysoft.cuteframework.exceptions.ResponseException;

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
        return Methods.domain + method  + getArgsAsString(params);
    }

    public String getFormattedURL()
    {
       return getURL() + Methods.options;
    }

    public String processAPI() throws ResponseException {
        String response = GET.execute(getFormattedURL());
        System.out.println(method + " >> " + response);
        return response;
    }

    public String process() throws ResponseException {
        return GET.execute(getURL());
    }


}
