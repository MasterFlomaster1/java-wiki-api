package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.common.Namespace;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public final class RedirectsProp extends AbstractProp {

    private Set<RdProp> rdProp;
    private Set<Namespace> rdNamespace;
    private RdShow rdShow;
    private int rdLimit;
    private String rdContinue;

    private RedirectsProp() {
        name = "redirects";
    }

    public Set<RdProp> getRdProp() {
        return rdProp;
    }

    public Set<Namespace> getRdNamespace() {
        return rdNamespace;
    }

    public RdShow getRdShow() {
        return rdShow;
    }

    public int getRdLimit() {
        return rdLimit;
    }

    public String getRdContinue() {
        return rdContinue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RedirectsProp that = (RedirectsProp) o;

        if (rdLimit != that.rdLimit) return false;
        if (!Objects.equals(rdProp, that.rdProp)) return false;
        if (!Objects.equals(rdNamespace, that.rdNamespace)) return false;
        if (rdShow != that.rdShow) return false;
        return Objects.equals(rdContinue, that.rdContinue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rdProp, rdNamespace, rdShow, rdLimit, rdContinue);
    }

    public static class Builder {

        private final RedirectsProp redirectsProp = new RedirectsProp();

        /**
         * Which properties to get
         * @return {@code Builder}
         */
        public Builder rdProp(Set<RdProp> rdProp) {
            redirectsProp.rdProp = rdProp;
            redirectsProp.apiUrl.putQuery("rdprop", rdProp.stream()
                    .map(RdProp::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * Only include pages in these namespaces.
         * <b>Note</b>: Due to <a href="https://www.mediawiki.org/wiki/Manual:$wgMiserMode">miser mode</a>, using this
         * may result in fewer than {@code rdlimit} results returned before continuing; in extreme cases, zero results
         * may be returned.
         * @return {@code Builder}
         */
        public Builder rdNamespace(Set<Namespace> rdNamespace) {
            redirectsProp.rdNamespace = rdNamespace;
            redirectsProp.apiUrl.putQuery("rdnamespace", rdNamespace.stream()
                    .map(Namespace::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * Show only items that meet these criteria
         * @return {@code Builder}
         */
        public Builder rdShow(RdShow rdShow) {
            redirectsProp.rdShow = rdShow;
            redirectsProp.apiUrl.putQuery("rdshow", rdShow.getValue());
            return this;
        }


        /**
         * How many redirects to return.
         * @param rdLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder rdLimit(int rdLimit) {
            redirectsProp.rdLimit = rdLimit;
            redirectsProp.apiUrl.putQuery("rdlimit", rdLimit);
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder rdContinue(String rdContinue) {
            redirectsProp.rdContinue = rdContinue;
            redirectsProp.apiUrl.putQuery("rdcontinue", rdContinue);
            return this;
        }

        public RedirectsProp build() {
            return redirectsProp;
        }

    }

    public enum RdProp {

        /**
         * Fragment of each redirect, if any.
         */
        FRAGMENT ("fragment"),

        /**
         * Page ID of each redirect.
         */
        PAGE_ID ("pageid"),

        /**
         * Title of each redirect.
         */
        TITLE ("title");

        private final String value;

        RdProp(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    public enum RdShow {

        /**
         * Only show redirects without a fragment.
         */
        NOT_FRAGMENT ("!fragment"),

        /**
         * Only show redirects with a fragment.
         */
        FRAGMENT ("fragment");

        private final String value;

        RdShow(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
