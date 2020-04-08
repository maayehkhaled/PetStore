package helpers;

import com.google.gson.Gson;
import model.Pet;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class HttpRequester {

    private final OkHttpClient httpClient = new OkHttpClient();
    public String responseBody;
    public int statusCode;


    public HttpRequester() {

    }

    public Request request(Verb verb, String endpoint, Map<String, String> params, @Nullable RequestBody body) {

        if (!params.isEmpty()) {
            endpoint = endpoint + ParameterizedEndPoint(params);
        }
        Request.Builder request = new Request.Builder()
                .url("http://petstore.swagger.io/v2" + endpoint)
                .addHeader("accept", "application/json");
        switch (verb) {
            case GET:
                request.get();
                break;
            case POST:
                request.addHeader("Content-Type", "application/json");

                if (body != null) {
                    request.post(body);
                }
                break;
            case DELETE:
                request.delete();
                break;
        }
        return request.build();
    }

    public String ParameterizedEndPoint(Map<String, String> params) {
        StringBuilder paramterizedEndPoint = new StringBuilder();
        params.forEach((k, v) -> paramterizedEndPoint.append(k).append("=").append(v).append("&"));
        return paramterizedEndPoint.toString().substring(0, paramterizedEndPoint.toString().length() - 1);
    }

    public String requestBodybuilder(Pet pet) {

        Gson gson = new Gson();
        String requestBody = gson.toJson(pet);
        return requestBody;
    }


    public Response response(Request request) throws Exception {
        System.out.println(request.url().toString());

        try (Response response = httpClient.newCall(request).execute()) {
            statusCode = response.code();
            responseBody = response.body().string();

            //if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response object
            return response;
        }

    }


}
