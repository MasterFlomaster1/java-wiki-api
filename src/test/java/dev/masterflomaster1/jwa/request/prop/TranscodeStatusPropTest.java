package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TranscodeStatusPropTest extends BaseApiTest {

    @Test
    @DisplayName("Get transcode status for File:Clip.webm")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new TranscodeStatusProp.Builder()
                                        .build()
                        ))
                        .titles(Set.of("File:Clip.webm"))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=transcodestatus&titles=File%3AClip.webm&formatversion=2",
                a.getUrl()
        ));
    }

}