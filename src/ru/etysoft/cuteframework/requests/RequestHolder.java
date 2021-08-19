package ru.etysoft.cuteframework.requests;

import ru.etysoft.cuteframework.Methods;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Hold the method name and params
 *
 * @author Mikhail Karlov
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

    public String getUrl() { return Methods.domain + getMethod(); }

    public Request makeRequest() {
        return new Request(method, params);
    }

    public String getMethod() {
        return method;
    }
}
