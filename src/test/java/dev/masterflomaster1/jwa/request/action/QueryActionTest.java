package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.request.list.RecentChangesList;
import dev.masterflomaster1.jwa.request.list.UsersList;
import dev.masterflomaster1.jwa.request.meta.SiteInfoMeta;
import dev.masterflomaster1.jwa.request.prop.CategoriesProp;
import dev.masterflomaster1.jwa.request.prop.ContributorsProp;
import dev.masterflomaster1.jwa.request.prop.ImagesProp;
import dev.masterflomaster1.jwa.request.prop.RevisionsProp;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class QueryActionTest extends BaseApiTest {

    @Test
    void testMultipleListProp() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new CategoriesProp.Builder()
                                        .build(),
                                new ContributorsProp.Builder()
                                        .build(),
                                new ImagesProp.Builder()
                                        .build()
                        ))
                        .list(Set.of(
                                new RecentChangesList.Builder()
                                        .build(),
                                new UsersList.Builder()
                                        .build()
                        ))
                        .titles(Set.of("PAVE"))
                        .build()
                )
                .build();

        Response r = api.execute(a);

        assertNotNull(r.getQuery().getPages().get(0).getCategories());
        assertNotNull(r.getQuery().getPages().get(0).getContributors());
        assertNotNull(r.getQuery().getPages().get(0).getImages());
        assertNotNull(r.getQuery().getUsers());
        assertNotNull(r.getQuery().getRecentChanges());
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
