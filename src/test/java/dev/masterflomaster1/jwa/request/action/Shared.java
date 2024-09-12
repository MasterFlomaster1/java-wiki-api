package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.request.meta.TokensMeta;
import dev.masterflomaster1.jwa.response.Tokens;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

class Shared {

    private static Tokens tokens;

    static Tokens tokens() {
        if (tokens == null)
            tokens = getTokens();

        return tokens;
    }

    private static Tokens getTokens() {
        WikiApi api = new WikiApi();

        try {
            var a = new WikiApiRequest.Builder()
                    .action(new QueryAction.Builder()
                            .meta(Set.of(
                                    new TokensMeta.Builder()
                                            .type(EnumSet.of(TokensMeta.Type.ALL_VALUES))
                                            .build()
                            ))
                            .build()
                    )
                    .build();

            Response r = api.execute(a);

            return r.getQuery().getTokens();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
