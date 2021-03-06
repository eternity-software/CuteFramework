package ru.etysoft.cuteframework.requests;

/**
 * Easy to use data holder for making a server request
 */
public class Pair {
    private String key;
    private Object value;

    public Pair(String key, String value)
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

    public static Pair make(String key, String value)
    {
       return new Pair(key, value);
    }

}
