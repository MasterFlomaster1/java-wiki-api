package dev.masterflomaster1.jwa.request.meta;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TokensMetaTest extends BaseApiTest {

    @Test
    void testLogin() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new TokensMeta.Builder()
                                        .type(EnumSet.of(TokensMeta.Type.LOGIN, TokensMeta.Type.CSRF))
                                        .build()
                        ))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getTokens());
    }

    @Test
    @DisplayName("Retrieve a csrf token (the default)")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new TokensMeta.Builder()
                                        .build()
                        ))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&meta=tokens&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    @DisplayName("Retrieve a watch token and a patrol token")
    void testExample2() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new TokensMeta.Builder()
                                        .type(EnumSet.of(TokensMeta.Type.WATCH, TokensMeta.Type.PATROL))
                                        .build()
                        ))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&meta=tokens&formatversion=2&type=watch%7Cpatrol",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new TokensMeta.Builder()
                .type(EnumSet.of(TokensMeta.Type.WATCH, TokensMeta.Type.PATROL))
                .build();

        assertEquals(EnumSet.of(TokensMeta.Type.WATCH, TokensMeta.Type.PATROL), a.getType());
    }

}