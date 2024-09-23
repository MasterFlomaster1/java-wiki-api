package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProjectsListTest extends BaseApiTest {

    @Test
    @DisplayName("Get a list of all the projects and subprojects")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new ProjectsList.Builder()
                                        .pjSubProjects()
                                        .build()
                        ))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&list=projects&formatversion=2&pjsubprojects=1",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new ProjectsList.Builder()
                .pjSubProjects()
                .build();

        assertTrue(a.isPjSubProjects());
    }

}