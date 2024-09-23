package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TagsListTest extends BaseApiTest {

    @Test
    @DisplayName("List available tags")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(new TagsList.Builder().build()))
                        .build()
                )
                .build();

        Response r = api.execute(a);

        assertNotNull(r.getQuery().getTags());
    }

    @Test
    void testBuilder() {
        var a = new TagsList.Builder()
                .tgContinue("New user changing redirect or redirecting")
                .tgLimit(20)
                .tgProp(EnumSet.of(TagsList.TgProp.SOURCE))
                .build();

        assertEquals("New user changing redirect or redirecting", a.getTgContinue());
        assertEquals(20, a.getTgLimit());
        assertEquals(EnumSet.of(TagsList.TgProp.SOURCE), a.getTgProp());
    }

}