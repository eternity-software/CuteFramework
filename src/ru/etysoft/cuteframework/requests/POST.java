package ru.etysoft.cuteframework.requests;

import okhttp3.Request;
import okhttp3.*;
import ru.etysoft.cuteframework.CuteFramework;
import ru.etysoft.cuteframework.requests.attachements.ImageFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;


/**
 * POST-request to server with several file-types
 */
public class POST {

    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");

    public static String execute(String url, final HashMap<String, Object> params, final String methodName) {


        try {
            url += "?v=" + CuteFramework.API_VERSION;
            String debugInfo = methodName + "<< POST\n> Request params";

            String result;
            OkHttpClient client = new OkHttpClient();
            MultipartBody.Builder requestBodyBuilder = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM);

            Set<String> keys = params.keySet();
            int imageIndex = 1;
            for (String key : keys) {
                Object data = params.get(key);
                if (data instanceof String) {
                    requestBodyBuilder.addFormDataPart(key, (String) data);
                    debugInfo = debugInfo + "\n" + key + ": " + data;
                } else if (data instanceof ImageFile) {
                    requestBodyBuilder.addFormDataPart(key, "image" + imageIndex + ".png",
                            RequestBody.create(MEDIA_TYPE_PNG, (ImageFile) data));
                    imageIndex++;
                    debugInfo = debugInfo + "\n" + key + ": " + ((ImageFile) data).getAbsolutePath();
                }

            }


            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBodyBuilder.build())
                    .build();

            System.out.println(debugInfo);
            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful())
                    throw new IOException("Unexpected code " + response);
                result = response.body().string();
            }
            return result;
        } catch (final Exception e) {
            e.printStackTrace();
            return null;
        }

    }


}
