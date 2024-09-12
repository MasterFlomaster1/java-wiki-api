package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.ContentFormat;
import dev.masterflomaster1.jwa.common.ContentModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;

class ParseActionTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Parse a page.")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new ParseAction.Builder()
                        .page("Project:Sandbox")
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getParse());
    }

    @Test
    @DisplayName("Parse wikitext.")
    void testExample2() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new ParseAction.Builder()
                        .text("{{Project:Sandbox}}")
                        .contentModel(ContentModel.WIKITEXT)
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getParse());
    }

    @Test
    @DisplayName("Parse wikitext, specifying the page title.")
    void testExample3() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new ParseAction.Builder()
                        .title("Test")
                        .text("{{PAGENAME}}")
                        .contentModel(ContentModel.WIKITEXT)
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getParse());
    }

    @Test
    void testBuilder() {
        var a = new ParseAction.Builder()
                .title("Test")
                .text("{{Project:Sandbox}}")
                .revId(8888L)
                .summary("Some [[link]]")
                .page("Project:Sandbox")
                .pageId(2333)
                .redirects()
                .oldId(7777L)
                .prop(EnumSet.of(ParseAction.Prop.CATEGORIES))
                .wrapOutputClass("mw-parser-output")
                .parsoid()
                .pst()
                .onlyPst()
                .section("s")
                .sectionTitle("ss")
                .disableLimitReport()
                .disableEditSection()
                .disableStyleDeduplication()
                .showStrategyKeys()
                .preview()
                .sectionPreview()
                .disableToc()
                .useSkin(ParseAction.UseSkin.VECTOR)
                .contentFormat(ContentFormat.TEXT_PLAIN)
                .contentModel(ContentModel.WIKITEXT)
                .mobileFormat()
                .build();

        assertEquals("Test", a.getTitle());
        assertEquals("{{Project:Sandbox}}", a.getText());
        assertEquals(8888L, a.getRevId());
        assertEquals("Some [[link]]", a.getSummary());
        assertEquals("Project:Sandbox", a.getPage());
        assertEquals(2333, a.getPageId());
        assertTrue(a.isRedirects());
        assertEquals(7777L, a.getOldId());
        assertEquals(EnumSet.of(ParseAction.Prop.CATEGORIES), a.getProp());
        assertEquals("mw-parser-output", a.getWrapOutputClass());
        assertTrue(a.isParsoid());
        assertTrue(a.isPst());
        assertTrue(a.isOnlyPst());
        assertEquals("s", a.getSection());
        assertEquals("ss", a.getSectionTitle());
        assertTrue(a.isDisableLimitReport());
        assertTrue(a.isDisableEditSection());
        assertTrue(a.isDisableStyleDeduplication());
        assertTrue(a.isShowStrategyKeys());
        assertTrue(a.isPreview());
        assertTrue(a.isSectionPreview());
        assertEquals(ParseAction.UseSkin.VECTOR, a.getUseSkin());
        assertEquals(ContentFormat.TEXT_PLAIN, a.getContentFormat());
        assertEquals(ContentModel.WIKITEXT, a.getContentModel());
        assertTrue(a.isMobileFormat());
    }

}