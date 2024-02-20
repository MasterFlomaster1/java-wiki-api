package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.request.list.UsersList;
import dev.masterflomaster1.jwa.request.meta.SiteInfoMeta;
import dev.masterflomaster1.jwa.request.prop.RevisionsProp;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueryActionTest {

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
