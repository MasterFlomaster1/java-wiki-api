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

import static org.junit.jupiter.api.Assertions.assertEquals;

class TorBlockActionTest {

    private static WikiApi api;
    private static Gson gson;

    @BeforeAll
    static void before() {
        api = new WikiApi();
        gson = new Gson();
    }

    @Test
    @DisplayName("Check if the IP address 192.0.2.18 is blocked as a Tor exit node.")
    void test() throws IOException, InterruptedException, WikiApiSyntaxException {
        var a = new WikiApiRequest.Builder()
                .action(new TorBlockAction.Builder()
                        .ip("102.130.119.48")
                        .build()
                )
                .build();

        Response r = gson.fromJson(api.execute(a), Response.class);
        System.out.println(r);
    }

    @Test
    void getIp() throws WikiApiSyntaxException {
        var a = new TorBlockAction.Builder()
                .ip("127.0.0.1")
                .build();

        assertEquals("127.0.0.1", a.getIp());
    }
}