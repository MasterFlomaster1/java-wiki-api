package dev.masterflomaster1.jwa.request.meta;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TokensMetaTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    void testLogin() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new TokensMeta.Builder()
                                        .type(Set.of(TokensMeta.Type.LOGIN, TokensMeta.Type.CSRF))
                                        .build()
                        ))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getTokens());
    }

    @Test
    @DisplayName("Retrieve a csrf token (the default).")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new TokensMeta.Builder()
                                        .build()
                        ))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getTokens());
    }

    @Test
    @DisplayName("Retrieve a watch token and a patrol token.")
    void testExample2() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new TokensMeta.Builder()
                                        .type(Set.of(TokensMeta.Type.WATCH, TokensMeta.Type.PATROL))
                                        .build()
                        ))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getTokens().getWatchToken());
        assertNotNull(r.getQuery().getTokens().getPatrolToken());
    }

    @Test
    void testBuilder() {
        var a = new TokensMeta.Builder()
                .type(Set.of(TokensMeta.Type.WATCH, TokensMeta.Type.PATROL))
                .build();

        assertEquals(Set.of(TokensMeta.Type.WATCH, TokensMeta.Type.PATROL), a.getType());
    }

}