package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.WikiApiSyntaxException;

public class LanguageSearchAction extends AbstractAction {

    private String search;
    private int typos;

    private LanguageSearchAction() {
        urlPart = "?action=languagesearch";
    }

    public String getSearch() {
        return search;
    }

    public int getTypos() {
        return typos;
    }

    public static class Builder {

        private final LanguageSearchAction languageSearchAction = new LanguageSearchAction();

        /**
         * Search string. This parameter is required.
         * @return {@code Builder}
         */
        public Builder search(String search) {
            languageSearchAction.search = search;
            languageSearchAction.urlPart += "&search=" + search;
            return this;
        }

        /**
         * Number of spelling mistakes allowed in the search string.
         * @return {@code Builder}
         */
        public Builder typos(int typos) {
            languageSearchAction.typos = typos;
            languageSearchAction.urlPart += "&typos=" + typos;
            return this;
        }

        public LanguageSearchAction build() throws WikiApiSyntaxException {
            if (languageSearchAction.search == null)
                throw new WikiApiSyntaxException("Parameter 'search' is required");

            return languageSearchAction;
        }

    }
}
