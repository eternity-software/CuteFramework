package ru.etysoft.cuteframework.requests;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ru.etysoft.cuteframework.exceptions.ResponseException;

/**
 * Simple GET-request to server with String response
 */
public class GET {

    public static String execute(String url) throws ResponseException {
        try {
            OkHttpClient client = new OkHttpClient();

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


    public static String executeForTimeout(String url, int timeDelay) throws ResponseException {
        try {
            OkHttpClient client = new OkHttpClient.Builder().connectTimeout(timeDelay, TimeUnit.SECONDS)
                    .writeTimeout(timeDelay, TimeUnit.SECONDS)
                    .readTimeout(timeDelay, TimeUnit.SECONDS).build();

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
