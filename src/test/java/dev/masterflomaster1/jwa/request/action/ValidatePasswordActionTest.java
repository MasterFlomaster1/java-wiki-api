package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatePasswordActionTest extends BaseApiTest {

    @Test
    @DisplayName("Validate the password foobar for the current user")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new ValidatePasswordAction.Builder()
                        .password("")
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=validatepassword&format=json&password=&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    @DisplayName("Validate the password qwerty for creating user Example")
    void testExample2() {
        var a = new WikiApiRequest.Builder()
                .action(new ValidatePasswordAction.Builder()
                        .password("")
                        .user("Example")
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=validatepassword&format=json&password=&user=Example&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
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