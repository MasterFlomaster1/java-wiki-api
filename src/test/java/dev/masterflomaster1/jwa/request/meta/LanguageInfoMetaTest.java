package dev.masterflomaster1.jwa.request.meta;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static dev.masterflomaster1.jwa.request.meta.LanguageInfoMeta.LiProp.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LanguageInfoMetaTest extends BaseApiTest {

    @Test
    @DisplayName("Get the language codes of all supported languages")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new LanguageInfoMeta.Builder()
                                        .build()
                        ))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&meta=languageinfo&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    @DisplayName("Get the autonyms and German names of all supported languages")
    void testExample2() {
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

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&uselang=de&meta=languageinfo&formatversion=2&liprop=autonym%7Cname",
                a.getUrl()
        ));
    }

    @Test
    @DisplayName("Get the fallback languages and variants of Occitan.")
    void testExample3() {
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
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&meta=languageinfo&formatversion=2&liprop=fallbacks%7Cvariants&licode=oc",
                a.getUrl()
        ));
    }

    @Test
    @DisplayName("Get the BCP-47 language code and direction of all supported languages.")
    void testExample4() {
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

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&meta=languageinfo&formatversion=2&liprop=bcp47%7Cdir",
                a.getUrl()
        ));
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