package ru.etysoft.cuteframework.api.request;

import ru.etysoft.cuteframework.api.response.methods.AuthorizationResponseHandler;
import ru.etysoft.cuteframework.requests.Request;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Hold the method name and params
 *
 * @autor Mikhail Karlov
 */
public abstract class RequestHolder {

    private String method;
    private Set<Pair> params = null;

    public RequestHolder(String method) {
        this.method = method;
    }

    public void setParams(Pair... pairs) {
        this.params = new HashSet<>(Arrays.asList(pairs));
    }

    public Set<Pair> getParams() {
        return params;
    }

    public Request makeRequest() {
        return new Request(method, params);
    }


    public String getMethod() {
        return method;
    }
}
