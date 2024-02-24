package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TorBlockActionTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Check if the IP address 192.0.2.18 is blocked as a Tor exit node.")
    void test() throws IOException, WikiApiSyntaxException {
        var a = new WikiApiRequest.Builder()
                .action(new TorBlockAction.Builder()
                        .ip("192.0.2.18")
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getTorBlock());
    }

    @Test
    void getIp() throws WikiApiSyntaxException {
        var a = new TorBlockAction.Builder()
                .ip("127.0.0.1")
                .build();

        assertEquals("127.0.0.1", a.getIp());
    }
}