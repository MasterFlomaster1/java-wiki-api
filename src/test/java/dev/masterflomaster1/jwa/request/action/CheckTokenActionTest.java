package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CheckTokenActionTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Test the validity of a csrf token.")
    void testExample1() throws WikiApiSyntaxException, IOException {
        var a = new WikiApiRequest.Builder()
                .action(new CheckTokenAction.Builder()
                        .type(CheckTokenAction.Type.CSRF)
                        .token("123ABC")
                        .build()
                )
                .build();

        Response r = api.execute(a);

        assertEquals("invalid", r.getCheckToken().getResult());
    }

    @Test
    void testBuilder() throws WikiApiSyntaxException {
        var a = new CheckTokenAction.Builder()
                .type(CheckTokenAction.Type.CSRF)
                .token("123ABC")
                .maxTokenAge(1)
                .build();

        assertEquals(CheckTokenAction.Type.CSRF, a.getType());
        assertEquals("123ABC", a.getToken());
        assertEquals(1, a.getMaxTokenAge());
    }

}