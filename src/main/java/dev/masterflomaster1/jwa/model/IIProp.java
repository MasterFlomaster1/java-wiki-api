package dev.masterflomaster1.jwa.model;

public enum IIProp {

    COMMENT ("comment"),
    EXTMETADATA ("extmetadata"),
    TIMESTAMP ("timestamp"),
    URL ("url"),
    USER ("user");

    public final String value;

    IIProp(String value) {
        this.value = value;
    }

}
