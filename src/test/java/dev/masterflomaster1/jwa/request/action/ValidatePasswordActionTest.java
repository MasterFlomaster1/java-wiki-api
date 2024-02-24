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

class ValidatePasswordActionTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Validate the password foobar for the current user.")
    void testExample1() throws WikiApiSyntaxException, IOException {
        var a = new WikiApiRequest.Builder()
                .action(new ValidatePasswordAction.Builder()
                        .password("foobar")
                        .build()
                )
                .build();

        Response r = api.execute(a);
        System.out.println(r.getValidatePassword());

        assertNull(r.getError());
        assertNotNull(r.getValidatePassword());
    }

    @Test
    @DisplayName("Validate the password qwerty for creating user Example.")
    void testExample2() throws WikiApiSyntaxException, IOException {
        var a = new WikiApiRequest.Builder()
                .action(new ValidatePasswordAction.Builder()
                        .password("qwerty")
                        .user("Example")
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertEquals(r.getError().getCode(), "userexists");
    }

    @Test
    void testBuilder() throws WikiApiSyntaxException {
        var a = new ValidatePasswordAction.Builder()
                .password("12345")
                .user("user")
                .email("email")
                .realName("name")
                .build();

        assertEquals("12345", a.getPassword());
        assertEquals("user", a.getUser());
        assertEquals("email", a.getEmail());
        assertEquals("name", a.getRealName());
    }

}