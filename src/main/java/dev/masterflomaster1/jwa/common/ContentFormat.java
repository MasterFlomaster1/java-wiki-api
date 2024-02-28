package dev.masterflomaster1.jwa.common;

public enum ContentFormat {

    APPLICATION_JSON ("application/json"),
    APPLICATION_OCTET_STREAM ("application/octet-stream"),
    APPLICATION_UNKNOWN ("application/unknown"),
    APPLICATION_X_BINARY ("application/x-binary"),
    TEXT_CSS ("text/css"),
    TEXT_JAVASCRIPT ("text/javascript"),
    TEXT_PLAIN ("text/plain"),
    TEXT_UNKNOWN ("text/unknown"),
    TEXT_X_WIKI ("text/x-wiki"),
    UNKNOWN_UNKNOWN ("unknown/unknown");

    private final String value;

    ContentFormat(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
