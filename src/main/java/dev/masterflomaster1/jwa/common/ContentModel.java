package dev.masterflomaster1.jwa.common;

public enum ContentModel {

    WIKITEXT ("wikitext");

    private final String value;

    ContentModel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
