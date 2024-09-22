package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class LanguageSearchAction extends AbstractAction {

    private String search;
    private int typos;

    private LanguageSearchAction() {
        apiUrl.setAction("languagesearch");
    }

    public static class Builder extends AbstractBuilder {

        private final LanguageSearchAction languageSearchAction = new LanguageSearchAction();

        /**
         * Search string. This parameter is required.
         * @return {@code Builder}
         */
        public Builder search(String search) {
            languageSearchAction.search = search;
            languageSearchAction.apiUrl.putQuery("search", search);
            return this;
        }

        /**
         * Number of spelling mistakes allowed in the search string.
         * @return {@code Builder}
         */
        public Builder typos(int typos) {
            languageSearchAction.typos = typos;
            languageSearchAction.apiUrl.putQuery("typos", typos);
            return this;
        }

        public LanguageSearchAction build() {
            if (languageSearchAction.search == null)
                throw new IllegalArgumentException("Parameter 'search' is required");

            return languageSearchAction;
        }

    }
}
