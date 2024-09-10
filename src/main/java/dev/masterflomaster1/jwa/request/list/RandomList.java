package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.common.Namespace;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;
import java.util.stream.Collectors;

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
public class RandomList extends AbstractList {

    private EnumSet<Namespace> rnNamespace;
    private RnFilterRedir rnFilterRedir;
    private int rnLimit;
    private String rnContinue;

    private RandomList() {
        name = "random";
    }

    public static class Builder {

        private final RandomList randomList = new RandomList();

        /**
         * Return pages in these namespaces only.
         * @return {@code Builder}
         */
        public Builder rnNamespace(final EnumSet<Namespace> rnNamespace) {
            randomList.rnNamespace = rnNamespace;
            randomList.apiUrl.putQuery("rnnamespace", rnNamespace.stream()
                    .map(Namespace::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * How to filter for redirects.
         * @return {@code Builder}
         */
        public Builder rnFilterRedir(final RnFilterRedir rnFilterRedir) {
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

    @Getter
    public enum RnFilterRedir {

        ALL("all"),
        NON_REDIRECTS("nonredirects"),
        REDIRECTS("redirects");

        private final String value;

        RnFilterRedir(String value) {
            this.value = value;
        }

    }

}
