package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TitleBlacklistActionTest extends BaseApiTest {

    @Test
    @DisplayName("Check whether Foo is blacklisted")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new TitleBlacklistAction.Builder()
                        .tbTitle("Foo")
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=titleblacklist&format=json&tbtitle=Foo&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    @DisplayName("Check whether Bar is blacklisted for editing")
    void testExample2() {
        var a = new WikiApiRequest.Builder()
                .action(new TitleBlacklistAction.Builder()
                        .tbTitle("Bar")
                        .tbAction(TitleBlacklistAction.TbAction.EDIT)
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=titleblacklist&format=json&tbtitle=Bar&tbaction=edit&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new TitleBlacklistAction.Builder()
                .tbTitle("Bar")
                .tbAction(TitleBlacklistAction.TbAction.EDIT)
                .tbNoOverride()
                .build();

        assertEquals("Bar", a.getTbTitle());
        assertEquals(TitleBlacklistAction.TbAction.EDIT, a.getTbAction());
        assertTrue(a.isTbNoOverride());
    }

}