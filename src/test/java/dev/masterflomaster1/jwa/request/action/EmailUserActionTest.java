package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

class EmailUserActionTest extends BaseApiTest {

    @Test
    @DisplayName("Send an email to the user WikiSysop with the text Content")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new EmailUserAction.Builder()
                        .target("WikiSysop")
                        .subject("Test")
                        .text("Content")
                        .token("+\\")
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=emailuser&format=json&target=WikiSysop&subject=Test&text=Content&token=%2B%5C&formatversion=2",
                a.getUrl()
        ));
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