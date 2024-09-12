package dev.masterflomaster1.jwa.request.meta;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

import static dev.masterflomaster1.jwa.request.meta.LanguageInfoMeta.LiProp.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LanguageInfoMetaTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Get the language codes of all supported languages.")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new LanguageInfoMeta.Builder()
                                        .build()
                        ))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getLanguageInfo());
    }

    @Test
    @DisplayName("Get the autonyms and German names of all supported languages.")
    void testExample2() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new LanguageInfoMeta.Builder()
                                        .liProp(EnumSet.of(AUTONYM, NAME))
                                        .build()
                        ))
                        .build()
                )
                .useLang("de")
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getLanguageInfo());
    }

    @Test
    @DisplayName("Get the fallback languages and variants of Occitan.")
    void testExample3() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new LanguageInfoMeta.Builder()
                                        .liProp(EnumSet.of(FALLBACKS, VARIANTS))
                                        .liCode(Set.of("oc"))
                                        .build()
                        ))
                        .build()
                )
                .useLang("de")
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getLanguageInfo());
    }

    @Test
    @DisplayName("Get the BCP-47 language code and direction of all supported languages.")
    void testExample4() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new LanguageInfoMeta.Builder()
                                        .liProp(EnumSet.of(BCP47, DIR))
                                        .build()
                        ))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getLanguageInfo());
    }

    @Test
    void testBuilder() {
        var a = new LanguageInfoMeta.Builder()
                .liProp(EnumSet.of(BCP47, DIR))
                .liCode(Set.of("oc"))
                .liContinue("test")
                .build();

        assertEquals(EnumSet.of(BCP47, DIR), a.getLiProp());
        assertEquals(Set.of("oc"), a.getLiCode());
        assertEquals("test", a.getLiContinue());
    }

}