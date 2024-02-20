package dev.masterflomaster1.jwa.model.action;

import dev.masterflomaster1.jwa.model.list.AbstractList;
import dev.masterflomaster1.jwa.model.meta.AbstractMeta;
import dev.masterflomaster1.jwa.model.prop.AbstractProp;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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
    private boolean indexPageIDs;
    private boolean export;
    private Set<String> titles;

    private QueryAction() {
        urlPart = "?action=query";
    }

    public Set<AbstractProp> getProp() {
        return prop;
    }

    public Set<AbstractList> getList() {
        return list;
    }

    public Set<AbstractMeta> getMeta() {
        return meta;
    }

    public boolean isIndexPageIDs() {
        return indexPageIDs;
    }

    public boolean isExport() {
        return export;
    }

    public Set<String> getTitles() {
        return titles;
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
         * @param list set of lists
         * @return {@code Builder}
         */
        public Builder list(Set<AbstractList> list) {
            queryAction.list = list;
            queryAction.urlPart += list.stream()
                    .map(AbstractList::getUrl)
                    .collect(Collectors.joining());
            return this;
        }

        /**
         * Which metadata to get.
         * @param meta set of metadata to get
         * @return {@code Builder}
         */
        public Builder meta(Set<AbstractMeta> meta) {
            queryAction.meta = meta;
            queryAction.urlPart += meta.stream()
                    .map(AbstractMeta::getUrl)
                    .collect(Collectors.joining());
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
            queryAction.urlPart += "&titles=" + titles.stream()
                    .map(str -> URLEncoder.encode(str, StandardCharsets.UTF_8))
                    .collect(Collectors.joining("%7C"));
            return this;
        }

        public QueryAction build() {
            return queryAction;
        }

    }

}
