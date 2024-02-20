package dev.masterflomaster1.jwa.model.prop;

import dev.masterflomaster1.jwa.common.Namespace;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Returns global image usage for a certain image.
 *
 * @see <a href="https://www.mediawiki.org/w/api.php?action=help&modules=query%2Bglobalusage">www.mediawiki.org</a>
 */
public class GlobalUsageProp extends AbstractProp {

    private Set<GuProp> guProp;
    private int guLimit;
    private Set<Namespace> guNamespace;
    private String guContinue;
    private boolean guFilterLocal;

    private GlobalUsageProp() {
        url = "&prop=globalusage";
    }

    public Set<GuProp> getGuProp() {
        return guProp;
    }

    public int getGuLimit() {
        return guLimit;
    }

    public Set<Namespace> getGuNamespace() {
        return guNamespace;
    }

    public String getGuContinue() {
        return guContinue;
    }

    public boolean isGuFilterLocal() {
        return guFilterLocal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GlobalUsageProp that = (GlobalUsageProp) o;

        if (guLimit != that.guLimit) return false;
        if (guFilterLocal != that.guFilterLocal) return false;
        if (!Objects.equals(guProp, that.guProp)) return false;
        if (!Objects.equals(guNamespace, that.guNamespace)) return false;
        return Objects.equals(guContinue, that.guContinue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guProp, guLimit, guNamespace, guContinue, guFilterLocal);
    }

    public static class Builder {

        private final GlobalUsageProp globalUsageProp = new GlobalUsageProp();

        /**
         * Which properties to return.
         * @return {@code Builder}
         */
        public Builder guProp(Set<GuProp> guProp) {
            globalUsageProp.guProp = guProp;
            globalUsageProp.url += "&guprop=" + guProp.stream()
                    .map(GuProp::getValue)
                    .collect(Collectors.joining("%7C"));
            return this;
        }

        /**
         * How many links to return.
         * @param guLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder guLimit(int guLimit) {
            globalUsageProp.guLimit = guLimit;
            globalUsageProp.url += "&gulimit=" + guLimit;
            return this;
        }

        /**
         * Limit results to these namespaces.
         * @return {@code Builder}
         */
        public Builder guNamespace(Set<Namespace> guNamespace) {
            globalUsageProp.guNamespace = guNamespace;
            globalUsageProp.url += "&gunamespace=" + guNamespace.stream()
                    .map(Namespace::getValue)
                    .collect(Collectors.joining("%7C"));
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder guContinue(String guContinue) {
            globalUsageProp.guContinue = guContinue;
            globalUsageProp.url += "&gucontinue=" + URLEncoder.encode(guContinue, StandardCharsets.UTF_8);
            return this;
        }

        /**
         * Filter local usage of the file.
         * @return {@code Builder}
         */
        public Builder guFilterLocal() {
            globalUsageProp.guFilterLocal = true;
            globalUsageProp.url += "&gufilterlocal=1";
            return this;
        }

        public GlobalUsageProp build() {
            return globalUsageProp;
        }

    }

    public enum GuProp {
        NAMESPACE ("namespace"),
        PAGE_ID ("pageid"),
        URL ("url");

        private final String value;

        GuProp(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
