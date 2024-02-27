package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

class ReviewActionTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Approve revision 12345 with comment 'Ok'")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new ReviewAction.Builder()
                        .revId(12345)
                        .comment("Ok")
                        .token(Shared.tokens().getCsrfToken())
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assumeFalse(r.getError() != null && r.getError().getCode().equals("permissiondenied"), "Permission denied, skipping");
    }

    @Test
    void testBuilder() {
        var a = new ReviewAction.Builder()
                .revId(12345)
                .comment("Ok")
                .unApprove()
                .token("token")
                .build();

        assertEquals(12345, a.getRevId());
        assertEquals("Ok", a.getComment());
        assertTrue(a.isUnApprove());
        assertEquals("token", a.getToken());
    }

}