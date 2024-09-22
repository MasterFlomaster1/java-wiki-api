package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.common.Namespace;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;
import java.util.stream.Collectors;

/**
 * Enumerate all links that point to a given namespace.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/API:Alllinks">API:Alllinks</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class AllLinksList extends AbstractList {

    private String alContinue;
    private String alFrom;
    private String alTo;
    private String prefix;
    private boolean alUnique;
    private EnumSet<AlProp> alProp;
    private EnumSet<Namespace> alNamespace;
    private int alLimit;
    private Dir.Order alDir;

    private AllLinksList() {
        name = "alllinks";
    }

    public static class Builder {

        private final AllLinksList allLinksList = new AllLinksList();

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder alContinue(final String alContinue) {
            allLinksList.alContinue = alContinue;
            allLinksList.apiUrl.putQuery("alcontinue", alContinue);
            return this;
        }

        /**
         * The title of the link to start enumerating from.
         * @return {@code Builder}
         */
        public Builder alFrom(final String alFrom) {
            allLinksList.alFrom = alFrom;
            allLinksList.apiUrl.putQuery("alfrom", alFrom);
            return this;
        }

        /**
         * The title of the link to stop enumerating at.
         * @return {@code Builder}
         */
        public Builder alTo(final String alTo) {
            allLinksList.alTo = alTo;
            allLinksList.apiUrl.putQuery("alto", alTo);
            return this;
        }

        /**
         * Search for all linked titles that begin with this value.
         * @return {@code Builder}
         */
        public Builder prefix(final String prefix) {
            allLinksList.prefix = prefix;
            allLinksList.apiUrl.putQuery("prefix", prefix);
            return this;
        }

        /**
         * Only show distinct linked titles. Cannot be used with {@code alprop=ids}. When used as a generator, yields
         * target pages instead of source pages.
         * @return {@code Builder}
         */
        public Builder alUnique() {
            allLinksList.alUnique = true;
            allLinksList.apiUrl.putQuery("alunique", "1");
            return this;
        }

        /**
         * Which pieces of information to include.
         * @return {@code Builder}
         */
        public Builder alProp(EnumSet<AlProp> alProp) {
            allLinksList.alProp = alProp;
            allLinksList.apiUrl.putQuery("alprop", alProp.stream()
                    .map(AlProp::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * The namespace to enumerate.
         * @return {@code Builder}
         */
        public Builder alNamespace(EnumSet<Namespace> alNamespace) {
            allLinksList.alNamespace = alNamespace;
            allLinksList.apiUrl.putQuery("cmnamespace", alNamespace.stream()
                    .map(Namespace::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * How many images in total to return.
         * @param alLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder alLimit(int alLimit) {
            allLinksList.alLimit = alLimit;
            allLinksList.apiUrl.putQuery("allimit", alLimit);
            return this;
        }

        /**
         * The direction in which to list.
         * @return {@code Builder}
         */
        public Builder alDir(final Dir.Order alDir) {
            allLinksList.alDir = alDir;
            allLinksList.apiUrl.putQuery("aldir", alDir.getValue());
            return this;
        }

        public AllLinksList build() {
            return allLinksList;
        }

    }

    @Getter
    public enum AlProp {

        /**
         * Adds the page ID of the linking page (cannot be used with alunique).
         */
        IDS("ids"),

        /**
         * Adds the title of the link.
         */
        TITLE("title");

        private final String value;

        AlProp(String value) {
            this.value = value;
        }

    }

}
