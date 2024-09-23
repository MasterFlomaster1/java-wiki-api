package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

class ReviewActionTest extends BaseApiTest {

    @Test
    @DisplayName("Approve revision 12345 with comment 'Ok'")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new ReviewAction.Builder()
                        .revId(12345)
                        .comment("Ok")
                        .token("123AB")
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=review&format=json&revid=12345&comment=Ok&token=123AB&formatversion=2",
                a.getUrl()
        ));
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