package ru.etysoft.cuteframework;



public class Logger {

    private static final boolean isDebug = true;

    public static void logSocket(String data, String name)
    {
        System.out.println("WebSocket " + name +" >> " + data);
    }
    public static void logResponse(String response, String method)
    {
        System.out.println(method + " >> " + response);
    }
    public static void logRequest(String request, String method)
    {
        System.out.println(method + " << " + request);
    }
    public static void logDebug(String string)
    {
        if(isDebug) {
            System.out.println("DEBUG >> " + string);
        }
    }
}
