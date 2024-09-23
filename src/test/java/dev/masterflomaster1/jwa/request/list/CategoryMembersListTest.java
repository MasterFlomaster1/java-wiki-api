package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMembersListTest extends BaseApiTest {

    @Test
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new CategoryMembersList.Builder()
                                        .cmTitle("Category:Physics")
                                        .build()
                                )
                        )
                        .build()
                )
                .build();

        Response r = api.execute(a);

        assertNotNull(r.getQuery().getCategoryMembers());
    }

    @Test
    void testBuilder() {
        var a = new CategoryMembersList.Builder()
                .cmTitle("Category:Physics")
                .cmPageId(32)
                .cmProp(EnumSet.of(CategoryMembersList.CmProp.IDS, CategoryMembersList.CmProp.TITLE))
                .cmNamespace(EnumSet.of(Namespace.TEMPLATE, Namespace.CATEGORY))
                .cmType(EnumSet.of(CategoryMembersList.CmType.PAGE, CategoryMembersList.CmType.FILE))
                .cmContinue("test")
                .cmLimit(344)
                .cmSort(CategoryMembersList.CmSort.TIMESTAMP)
                .cmDir(Dir.Mixed.NEWER)
                .cmStart(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35).toInstant(ZoneOffset.UTC))
                .cmEnd(LocalDateTime.of(2023, Month.SEPTEMBER, 8, 12, 35).toInstant(ZoneOffset.UTC))
                .cmStartHexSortKey("test1")
                .cmEndHexSortKey("test2")
                .cmStartSortKeyPrefix("test3")
                .cmEndSortKeyPrefix("test4")
                .build();

        assertEquals("Category:Physics", a.getCmTitle());
        assertEquals(32, a.getCmPageId());
        assertEquals(EnumSet.of(CategoryMembersList.CmProp.IDS, CategoryMembersList.CmProp.TITLE), a.getCmProp());
        assertEquals(EnumSet.of(Namespace.TEMPLATE, Namespace.CATEGORY), a.getCmNamespace());
        assertEquals(EnumSet.of(CategoryMembersList.CmType.PAGE, CategoryMembersList.CmType.FILE), a.getCmType());
        assertEquals("test", a.getCmContinue());
        assertEquals(344, a.getCmLimit());
        assertEquals(CategoryMembersList.CmSort.TIMESTAMP, a.getCmSort());
        assertEquals(Dir.Mixed.NEWER, a.getCmDir());
        assertEquals(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35).toInstant(ZoneOffset.UTC), a.getCmStart());
        assertEquals(LocalDateTime.of(2023, Month.SEPTEMBER, 8, 12, 35).toInstant(ZoneOffset.UTC), a.getCmEnd());
        assertEquals("test1", a.getCmStartHexSortKey());
        assertEquals("test2", a.getCmEndHexSortKey());
        assertEquals("test3", a.getCmStartSortKeyPrefix());
        assertEquals("test4", a.getCmEndSortKeyPrefix());
    }


}