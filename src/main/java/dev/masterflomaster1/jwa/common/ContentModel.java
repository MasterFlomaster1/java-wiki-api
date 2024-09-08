package dev.masterflomaster1.jwa.common;

import lombok.Getter;

@Getter
public enum ContentModel {

    WIKITEXT ("wikitext");

    private final String value;

    ContentModel(String value) {
        this.value = value;
    }

}
