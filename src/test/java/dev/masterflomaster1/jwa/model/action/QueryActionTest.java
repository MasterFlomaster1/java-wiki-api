package dev.masterflomaster1.jwa.model.action;

import dev.masterflomaster1.jwa.model.list.UsersList;
import dev.masterflomaster1.jwa.model.meta.SiteInfoMeta;
import dev.masterflomaster1.jwa.model.prop.RevisionsProp;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueryActionTest {

    @Test
    void testBuild() {
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
