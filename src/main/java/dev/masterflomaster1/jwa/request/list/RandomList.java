package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.common.FilterRedir;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;

/**
 * Get a set of random pages.
 * <p>
 * Pages are listed in a fixed sequence, only the starting point is random. This means that if, for example, Main Page
 * is the first random page in the list, List of fictional monkeys will always be second, List of people on stamps of
 * Vanuatu third, etc.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Random">API:Random</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class RandomList extends AbstractList {

    private EnumSet<Namespace> rnNamespace;
    private FilterRedir rnFilterRedir;
    private int rnLimit;
    private String rnContinue;

    private RandomList() {
        super("random");
    }

    public static class Builder extends AbstractBuilder {

        private final RandomList randomList = new RandomList();

        /**
         * Return pages in these namespaces only.
         * @return {@code Builder}
         */
        public Builder rnNamespace(final EnumSet<Namespace> rnNamespace) {
            randomList.rnNamespace = rnNamespace;
            randomList.apiUrl.putQuery("rnnamespace", merge(rnNamespace));
            return this;
        }

        /**
         * How to filter for redirects.
         * @return {@code Builder}
         */
        public Builder rnFilterRedir(final FilterRedir rnFilterRedir) {
            randomList.rnFilterRedir = rnFilterRedir;
            randomList.apiUrl.putQuery("rnfilterredir", rnFilterRedir.getValue());
            return this;
        }

        /**
         * How many total changes to return. Default: 10
         * @param rnLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder rnLimit(final int rnLimit) {
            randomList.rnLimit = rnLimit;
            randomList.apiUrl.putQuery("rnlimit", rnLimit);
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder rnContinue(final String rnContinue) {
            randomList.rnContinue = rnContinue;
            randomList.apiUrl.putQuery("rncontinue", rnContinue);
            return this;
        }

        public RandomList build() {
            return randomList;
        }

    }

}
