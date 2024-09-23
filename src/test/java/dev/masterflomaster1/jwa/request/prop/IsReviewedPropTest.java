package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

class IsReviewedPropTest extends BaseApiTest {

    @Test
    @DisplayName("Determine if Main Page is marked as reviewed.")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new IsReviewedProp.Builder()
                                        .build()
                                )
                        )
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertTrue(r.getQuery().getPages().get(0).getIsReviewed());
    }

}