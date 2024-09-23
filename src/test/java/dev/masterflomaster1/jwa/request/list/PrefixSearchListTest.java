package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PrefixSearchListTest extends BaseApiTest {

    @Test
    @DisplayName("Search for page titles beginning with meaning")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new PrefixSearchList.Builder()
                                        .psSearch("meaning")
                                        .build()
                        ))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&list=prefixsearch&formatversion=2&pssearch=meaning",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new PrefixSearchList.Builder()
                .psSearch("meaning")
                .psNamespace(EnumSet.of(Namespace.MEDIA, Namespace.ARTICLE))
                .psLimit(30)
                .psOffset(10)
                .psProfile(PrefixSearchList.PsProfile.STRICT)
                .build();

        assertEquals("meaning", a.getPsSearch());
        assertEquals(EnumSet.of(Namespace.MEDIA, Namespace.ARTICLE), a.getPsNamespace());
        assertEquals(30, a.getPsLimit());
        assertEquals(10, a.getPsOffset());
        assertEquals(PrefixSearchList.PsProfile.STRICT, a.getPsProfile());
    }

}