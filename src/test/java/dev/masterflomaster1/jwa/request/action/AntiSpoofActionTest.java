package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApiRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AntiSpoofActionTest extends BaseApiTest {

    @Test
    @DisplayName("Check username 'Foo' against AntiSpoof")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new AntiSpoofAction.Builder()
                        .username("Foo")
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getAntiSpoof());
    }

    @Test
    void testBuilder() {
        var a = new AntiSpoofAction.Builder()
                .username("test")
                .build();

        assertEquals("test", a.getUsername());
    }

}