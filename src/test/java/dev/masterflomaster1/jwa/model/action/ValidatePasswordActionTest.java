package dev.masterflomaster1.jwa.model.action;

import com.google.gson.Gson;
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
    private static Gson gson;

    @BeforeAll
    static void before() {
        api = new WikiApi();
        gson = new Gson();
    }

    @Test
    @DisplayName("Validate the password foobar for the current user.")
    void testExample1() throws WikiApiSyntaxException, IOException, InterruptedException {
        var a = new WikiApiRequest.Builder()
                .action(new ValidatePasswordAction.Builder()
                        .password("foobar")
                        .build()
                )
                .build();

        Response r = gson.fromJson(api.execute(a), Response.class);
        System.out.println(r);
    }

    @Test
    @DisplayName("Validate the password qwerty for creating user Example.")
    void testExample2() throws WikiApiSyntaxException, IOException, InterruptedException {
        var a = new WikiApiRequest.Builder()
                .action(new ValidatePasswordAction.Builder()
                        .password("qwerty")
                        .user("Example")
                        .build()
                )
                .build();

        Response r = gson.fromJson(api.execute(a), Response.class);
        System.out.println(r);
    }

    @Test
    void getPassword() throws WikiApiSyntaxException {
        var a = new ValidatePasswordAction.Builder()
                .password("12345")
                .build();

        assertEquals("12345", a.getPassword());
    }

    @Test
    void getUser() throws WikiApiSyntaxException {
        var a = new ValidatePasswordAction.Builder()
                .password("12345")
                .user("user")
                .build();

        assertEquals("user", a.getUser());
    }

    @Test
    void getEmail() throws WikiApiSyntaxException {
        var a = new ValidatePasswordAction.Builder()
                .password("12345")
                .email("email")
                .build();

        assertEquals("email", a.getEmail());
    }

    @Test
    void getRealName() throws WikiApiSyntaxException {
        var a = new ValidatePasswordAction.Builder()
                .password("12345")
                .realName("name")
                .build();

        assertEquals("name", a.getRealName());
    }
}