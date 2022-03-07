package ru.etysoft.cuteframework.requests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.consts.APIKeys;
import ru.etysoft.cuteframework.exceptions.ResponseException;

/**
 * Simple GET-request to server with String response
 */
public class GET {

    public static String execute(String url) throws ResponseException {
        return execute(url, new HashMap<>());
    }


    public static String execute(String url, HashMap<String, String> headers) throws ResponseException {
        try {

            System.out.println("CuFr GET >> " + url);
            OkHttpClient client = new OkHttpClient();

            Request.Builder builder = new Request.Builder();
            builder.url(url);

            for(String key : headers.keySet())
            {
                String value = headers.get(key);
                builder.addHeader(key, value);
            }
            builder.addHeader(APIKeys.Headers.VERSION, CuteFramework.API_VERSION);


            Request request = new Request.Builder()

                    .url(url)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String stringResponse = response.body().string();
                return stringResponse;
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseException("GET-request exception has been occurred");
        }
    }


    public static String executeForTimeout(String url, int secondsTimeout) throws ResponseException {
        try {
            OkHttpClient client = new OkHttpClient.Builder().connectTimeout(secondsTimeout, TimeUnit.SECONDS)
                    .writeTimeout(secondsTimeout, TimeUnit.SECONDS)
                    .readTimeout(secondsTimeout, TimeUnit.SECONDS).build();

            Request request = new Request.Builder()
                    .url(url)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String resp = response.body().string();
                return resp;
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseException("GET-request exception has been occurred");
        }
    }

}
