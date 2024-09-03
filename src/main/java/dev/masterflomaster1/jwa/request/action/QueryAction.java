package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.request.list.AbstractList;
import dev.masterflomaster1.jwa.request.meta.AbstractMeta;
import dev.masterflomaster1.jwa.request.prop.AbstractProp;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

/**
 * Fetch data from and about MediaWiki.
 * All data modifications will first have to use query to acquire a token to prevent abuse from malicious sites.
 */
@Getter
@ToString
public final class QueryAction extends AbstractAction {

    private Set<AbstractProp> prop;
    private Set<AbstractList> list;
    private Set<AbstractMeta> meta;
    private boolean indexPageIDs;
    private boolean export;
    private Set<String> titles;

    private QueryAction() {
        apiUrl.setAction("query");
    }

    public static class Builder {

        private final QueryAction queryAction = new QueryAction();

        /**
         * Which properties to get for the queried pages.
         * @param props set of properties
         * @return {@code Builder}
         */
        public Builder prop(Set<AbstractProp> props) {
            if (queryAction.prop != null)
                throw new IllegalArgumentException("'prop' already set");

            queryAction.prop = props;
            props.forEach(e -> queryAction.apiUrl.putProp(e.getName(), e.getApiUrl().build()));

            return this;
        }

        /**
         * Which lists to get.
         * Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @param list set of lists
         * @return {@code Builder}
         */
        public Builder list(Set<AbstractList> list) {
            if (queryAction.list != null)
                throw new IllegalArgumentException("'list' already set");

            queryAction.list = list;
            list.forEach(e -> queryAction.apiUrl.putList(e.getName(), e.getApiUrl().build()));

            return this;
        }

        /**
         * Which metadata to get.
         * @return {@code Builder}
         */
        public Builder meta(Set<AbstractMeta> meta) {
            if (queryAction.meta != null)
                throw new IllegalArgumentException("'meta' already set");

            queryAction.meta = meta;
            meta.forEach(e -> queryAction.apiUrl.putMeta(e.getName(), e.getApiUrl().build()));

            return this;
        }

        /**
         * Include an additional pageids section listing all returned page IDs.
         * @return {@code Builder}
         */
        public Builder indexPageIds() {
            queryAction.indexPageIDs = true;
            queryAction.apiUrl.putQuery("indexpageids", "1");
            return this;
        }

        /**
         * Export the current revisions of all given or generated pages.
         * @return {@code Builder}
         */
        public Builder export() {
            queryAction.export = true;
            queryAction.apiUrl.putQuery("export", "1");
            return this;
        }

        /**
         * A list of titles to work on.
         * Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @param titles set of titles
         * @return {@code Builder}
         */
        public Builder titles(Set<String> titles) {
            queryAction.titles = titles;
            queryAction.apiUrl.putQuery("titles", String.join("|", titles));
            return this;
        }

        public QueryAction build() {
            return queryAction;
        }

    }

}
