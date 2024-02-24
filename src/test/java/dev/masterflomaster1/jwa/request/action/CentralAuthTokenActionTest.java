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

class CentralAuthTokenActionTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Fetch a centralauthtoken")
    void testExample1() throws WikiApiSyntaxException, IOException {
        var a = new WikiApiRequest.Builder()
                .action(new CentralAuthTokenAction.Builder()
                        .build()
                )
                .build();

        Response r = api.execute(a);

        if (r.getError() != null)
            assertEquals("notloggedin", r.getError().getCode());
    }

}