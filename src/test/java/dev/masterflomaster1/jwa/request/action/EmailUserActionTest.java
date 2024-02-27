package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

class EmailUserActionTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new EmailUserAction.Builder()
                        .target("Example")
                        .subject("Demo subject")
                        .text("Content")
                        .token(Shared.tokens().getCsrfToken())
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assumeFalse(r.getError() != null && r.getError().getCode().equals("cantsend"), "cantsend, skipping");
        assertNotNull(r.getEmailUser());
    }

    @Test
    void testBuilder() {
        var a = new EmailUserAction.Builder()
                .target("Example")
                .subject("Demo subject")
                .text("Content")
                .ccMe()
                .token("token")
                .build();

        assertEquals("Example", a.getTarget());
        assertEquals("Demo subject", a.getSubject());
        assertEquals("Content", a.getText());
        assertTrue(a.isCcMe());
        assertEquals("token", a.getToken());
    }

}