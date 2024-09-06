package dev.masterflomaster1.jwa;

import com.google.gson.Gson;
import dev.masterflomaster1.jwa.request.action.IPost;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

@Slf4j
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

        if (request.getAction() instanceof IPost) {
            log.info("POST {}", request.getUrl());

            Request request1 = new Request.Builder()
                    .url(request.getUrl())
                    .post(((IPost) request.getAction()).getPostBody())
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36")
                    .build();

            try (okhttp3.Response response = client.newCall(request1).execute()) {
                return gson.fromJson(response.body().string(), Response.class);
            }
        }

        log.info("GET {}", request.getUrl());

        Request request1 = new Request.Builder()
                .url(request.getUrl())
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36")
                .build();

        try (okhttp3.Response response = client.newCall(request1).execute()) {
            return gson.fromJson(response.body().string(), Response.class);
        }
    }

}
