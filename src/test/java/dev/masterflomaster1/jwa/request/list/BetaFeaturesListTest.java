package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BetaFeaturesListTest extends BaseApiTest {

    @Test
    @DisplayName("Get all available beta features and show how many users have enabled them")
    void testExample1() {
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

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&list=betafeatures&formatversion=2&bfcounts=",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new BetaFeaturesList.Builder()
                .bdCounts()
                .build();

        assertTrue(a.isBfCounts());
    }

}