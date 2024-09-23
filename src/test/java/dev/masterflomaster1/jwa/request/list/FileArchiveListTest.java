package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FileArchiveListTest extends BaseApiTest {

    @Test
    @DisplayName("Show a list of all deleted files")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new FileArchiveList.Builder()
                                        .build()
                        ))
                        .build()
                )
                .build();

        Response r = api.execute(a);

        System.out.println(r.getQuery().getFileArchive());

        assertNotNull(r.getQuery().getFileArchive());
    }

    @Test
    void testBuilder() {
        var a = new FileArchiveList.Builder()
                .faFrom("A")
                .faTo("B")
                .faPrefix("Demo")
                .faDir(Dir.Order.DESCENDING)
                .faSha1("12345")
                .faSha1Base36("23456")
                .faProp(EnumSet.of(FileArchiveList.FaProp.TIMESTAMP))
                .faLimit(32)
                .faContinue("abc")
                .build();

        assertEquals("A", a.getFaFrom());
        assertEquals("B", a.getFaTo());
        assertEquals("Demo", a.getFaPrefix());
        assertEquals(Dir.Order.DESCENDING, a.getFaDir());
        assertEquals("12345", a.getFaSha1());
        assertEquals("23456", a.getFaSha1Base36());
        assertEquals(EnumSet.of(FileArchiveList.FaProp.TIMESTAMP), a.getFaProp());
        assertEquals(32, a.getFaLimit());
        assertEquals("abc", a.getFaContinue());
    }

}