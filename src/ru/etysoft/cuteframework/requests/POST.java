package ru.etysoft.cuteframework.requests;

import okhttp3.Request;
import okhttp3.*;
import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.Logger;
import ru.etysoft.cuteframework.requests.attachements.ImageFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;


/**
 * POST-request to server with several file-types
 */
public class POST {

    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    public static String execute( RequestHolder requestHolder) {


        try {

            String methodName = requestHolder.getMethod();
            String body = requestHolder.getBody();

            String url = requestHolder.getUrl();

            HashMap<String, Object> headers = requestHolder.getHeaders();



            String debugInfo = methodName + "<< POST\n> Request params";

            String result;
            OkHttpClient client = new OkHttpClient();
            MultipartBody.Builder requestBodyBuilder = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM);


            System.out.println(body);
            // requestBodyBuilder.addPart();





             Request.Builder builder = new Request.Builder()
                    .url(url)
                    .post(RequestBody.create( body, MEDIA_TYPE_JSON));

            for(String key : headers.keySet())
            {
                if(headers.get(key) instanceof String)
                {
                    String value = (String) headers.get(key);
                    builder.addHeader(key, value);

                }
            }

            Request request = builder.build();

            System.out.println(debugInfo);
            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful())
                   System.out.println("Unexpected code " + response.body().string());
                result = response.body().string();
            }
            System.out.println(result);
            return result;
        } catch (final Exception e) {
            e.printStackTrace();
            return null;
        }

    }


}
