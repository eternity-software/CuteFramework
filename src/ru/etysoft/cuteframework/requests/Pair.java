package ru.etysoft.cuteframework.requests;

import java.util.HashMap;

/**
 * Easy to use data holder for making a server request
 */
public class Pair {
    private String key;
    private Object value;

    public Pair(String key, Object value)
    {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public static Pair make(String key, Object value)
    {
       return new Pair(key, value);
    }

}
