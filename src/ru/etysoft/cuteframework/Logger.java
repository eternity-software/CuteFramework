package ru.etysoft.cuteframework;

import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;

public class Logger {
    public static void logResponse(String response, String method)
    {
        System.out.println(method + " >> " + response);
    }
    public static void logRequest(String request, String method)
    {
        System.out.println(method + " << " + request);
    }
}
