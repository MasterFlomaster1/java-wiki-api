package dev.masterflomaster1.jwa.request.action;

import com.google.gson.Gson;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class CentralAuthTokenActionTest {

    private static WikiApi api;
    private static Gson gson;

    @BeforeAll
    static void before() {
        api = new WikiApi();
        gson = new Gson();
    }

    @Test
    @DisplayName("Fetch a centralauthtoken")
    void testExample1() throws WikiApiSyntaxException, IOException, InterruptedException {
        var a = new WikiApiRequest.Builder()
                .action(new CentralAuthTokenAction.Builder()
                        .build()
                )
                .build();

        Response r = gson.fromJson(api.execute(a), Response.class);
    }

}