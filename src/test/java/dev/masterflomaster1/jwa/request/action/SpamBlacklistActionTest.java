package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApiRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SpamBlacklistActionTest extends BaseApiTest {

    @Test
    @DisplayName("Check two URLs against the block list")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new SpamBlacklistAction.Builder()
                        .url(Set.of("https://www.example.com/", "https://www.example.org/"))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getSpamBlacklist());
    }

    @Test
    void testBuilder() {
        var a = new SpamBlacklistAction.Builder()
                .url(Set.of("https://www.example.com/", "https://www.example.org/"))
                .build();

        assertEquals(Set.of("https://www.example.com/", "https://www.example.org/"), a.getUrl());
    }

}