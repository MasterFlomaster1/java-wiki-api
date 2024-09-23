package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BetaFeaturesListTest extends BaseApiTest {

    @Test
    @DisplayName("Get all available beta features and show how many users have enabled them")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new BetaFeaturesList.Builder()
                                        .bdCounts()
                                        .build()
                        ))
                        .build()
                )
                .build();

        Response r = api.execute(a);

        System.out.println(r.getQuery().getBetafeatures());

        assertNotNull(r.getQuery().getBetafeatures());
    }

    @Test
    void testBuilder() {
        var a = new BetaFeaturesList.Builder()
                .bdCounts()
                .build();

        assertTrue(a.isBfCounts());
    }

}