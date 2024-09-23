package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.list.UsersList;
import dev.masterflomaster1.jwa.request.meta.SiteInfoMeta;
import dev.masterflomaster1.jwa.request.prop.RevisionsProp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class QueryActionTest extends BaseApiTest {

    @Test
    @DisplayName("Fetch site info and revisions of Main Page")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(new RevisionsProp.Builder()
                                .rvProp(EnumSet.of(RevisionsProp.RvProp.USER, RevisionsProp.RvProp.COMMENT))
                                .build()
                        ))
                        .meta(Set.of(new SiteInfoMeta.Builder()
                                .build()
                        ))
                        .continue_("")
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&meta=siteinfo&continue=&titles=Main%20Page&formatversion=2&rvprop=user%7Ccomment",
                a.getUrl()
        ));

    }

    @Test
    void testBuilder() {
        var a = new QueryAction.Builder()
                .prop(Set.of(new RevisionsProp.Builder().build()))
                .list(Set.of(new UsersList.Builder().build()))
                .meta(Set.of(new SiteInfoMeta.Builder().build()))
                .indexPageIds()
                .export()
                .build();

        assertEquals(Set.of(new RevisionsProp.Builder().build()), a.getProp());
        assertEquals(Set.of(new UsersList.Builder().build()), a.getList());
        assertEquals(Set.of(new SiteInfoMeta.Builder().build()), a.getMeta());
        assertTrue(a.isIndexPageIDs());
        assertTrue(a.isExport());
    }

}
