package dev.masterflomaster1.jwa;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class WikiApi {

    private OkHttpClient client;
    private final Gson gson;

    public WikiApi() {
        client = new OkHttpClient.Builder()
                .build();

        gson = new Gson();
    }

    public void setHttpClient(OkHttpClient client) {
        this.client = client;
    }

    public Response execute(WikiApiRequest request) throws IOException {
        Request request1 = new Request.Builder()
                .url(request.getUrl())
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36")
                .build();

        try (okhttp3.Response response = client.newCall(request1).execute()) {
            return gson.fromJson(response.body().string(), Response.class);
        }
    }

}
