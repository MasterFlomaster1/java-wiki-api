package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TitleBlacklistActionTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Check whether Foo is blacklisted")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new TitleBlacklistAction.Builder()
                        .tbTitle("Foo")
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getTitleBlacklist());
    }

    @Test
    @DisplayName("Check whether Bar is blacklisted for editing")
    void testExample2() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new TitleBlacklistAction.Builder()
                        .tbTitle("Bar")
                        .tbAction(TitleBlacklistAction.TbAction.EDIT)
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getTitleBlacklist());
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