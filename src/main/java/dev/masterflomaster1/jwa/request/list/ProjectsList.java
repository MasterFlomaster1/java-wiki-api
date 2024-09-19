package dev.masterflomaster1.jwa.request.list;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * List all the projects.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Extension:PageAssessments">Extension:PageAssessments</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class ProjectsList extends AbstractList {

    private boolean pjSubProjects;

    private ProjectsList() {
        name = "projects";
    }

    public static class Builder {

        private final ProjectsList projectsList = new ProjectsList();

        /**
         * Also include subprojects.
         * @return {@code Builder}
         */
        public Builder pjSubProjects() {
            projectsList.pjSubProjects = true;
            projectsList.apiUrl.putQuery("pjsubprojects", "1");
            return this;
        }

        public ProjectsList build() {
            return projectsList;
        }

    }

}
