package dev.masterflomaster1.jwa.model.action;

import dev.masterflomaster1.jwa.model.Meta;
import dev.masterflomaster1.jwa.model.prop.AbstractProp;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Fetch data from and about MediaWiki.
 * All data modifications will first have to use query to acquire a token to prevent abuse from malicious sites.
 */
public class Query extends AbstractAction {

    // Which properties to get for the queried pages.
    private Set<AbstractProp> prop = new HashSet<>();

    /*
    Which lists to get.

    Maximum number of values is 50 (500 for clients that are allowed higher limits).
     */
    private Set<String> list;

    // Which metadata to get.
    private Set<Meta> meta;

    // Include an additional pageids section listing all returned page IDs.
    private boolean indexPageIDs = false;

    // Export the current revisions of all given or generated pages.
    private boolean export = false;

    /**
     * A list of titles to work on.
     * Maximum number of values is 50 (500 for clients that are allowed higher limits).
     */
    private Set<String> titles;



    private Query() {
        urlPart = "?action=query";
    }

    public static class Builder {

        private Query query = new Query();

        public Builder addProp(AbstractProp prop) {
            query.prop.add(prop);
            query.urlPart += prop.getUrl();
            return this;
        }

        public Builder setProps(Set<AbstractProp> props) {
            query.prop = props;
            return this;
        }

        public Builder setTitles(Set<String> titles) {
            query.titles = titles;
            query.urlPart += "&titles=" + String.join("|", titles);
            return this;
        }

        public Query build() {
            return query;
        }

    }

}
