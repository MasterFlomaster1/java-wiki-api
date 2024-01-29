package dev.masterflomaster1.jwa.model;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Fetch data from and about MediaWiki.
 * All data modifications will first have to use query to acquire a token to prevent abuse from malicious sites.
 */
public class QueryAction extends AbstractAction {

    private Set<AbstractProp> prop;
    private Set<AbstractList> list;
    private Set<AbstractMeta> meta;
    private boolean indexPageIDs = false;
    private boolean export = false;
    private Set<String> titles;

    private QueryAction() {
        urlPart = "?action=query";
    }

    public static class Builder {

        private final QueryAction queryAction = new QueryAction();

        /**
         * Which properties to get for the queried pages.
         * @param props set of properties
         * @return {@code Builder}
         */
        public Builder prop(Set<AbstractProp> props) {
            queryAction.prop = props;
            queryAction.urlPart += props.stream()
                    .map(AbstractProp::getUrl)
                    .collect(Collectors.joining());

            return this;
        }

        /**
         * Which lists to get.
         * Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @param lists set of lists
         * @return {@code Builder}
         */
        public Builder list(Set<AbstractList> lists) {
            queryAction.list = lists;

            return this;
        }

        /**
         * Which metadata to get.
         * @param meta set of metadata to get
         * @return {@code Builder}
         */
        public Builder meta(Set<AbstractMeta> meta) {
            queryAction.meta = meta;
            return this;
        }

        /**
         * Include an additional pageids section listing all returned page IDs.
         * @return {@code Builder}
         */
        public Builder indexPageIds() {
            queryAction.indexPageIDs = true;
            queryAction.urlPart += "&indexpageids=1";
            return this;
        }

        /**
         * Export the current revisions of all given or generated pages.
         * @return {@code Builder}
         */
        public Builder export() {
            queryAction.export = true;
            queryAction.urlPart += "&export=1";
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
            queryAction.urlPart += "&titles=" + String.join("%7C", titles);
            return this;
        }

        public QueryAction build() {
            return queryAction;
        }

    }

}
