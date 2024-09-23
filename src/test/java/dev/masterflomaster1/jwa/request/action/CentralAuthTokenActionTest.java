package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApiRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assumptions.assumeFalse;

class CentralAuthTokenActionTest extends BaseApiTest {

    @Test
    @DisplayName("Fetch a centralauthtoken")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new CentralAuthTokenAction.Builder()
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assumeFalse(r.getError() != null && r.getError().getCode().equals("notloggedin"), "Not logged in, skipping");
    }

}