package dev.masterflomaster1.jwa.model;

public enum Prop {

    CATEGORIES ("categories"),
    CATEGORY_INFO ("categoryinfo"),
    CONTRIBUTORS ("contributors"),
    DESCRIPTION ("description"),
    EXTLINKS ("extlinks"),
    FILE_USAGE ("fileusage"),
    IMAGE_INFO ("imageinfo"),
    IMAGES ("images"),
    INFO ("info"),
    LINKS ("links"),
    REVISIONS ("revisions"),
    TEMPLATES ("templates"),
    VIDEO_INFO ("videoinfo");

    private final String value;

    Prop(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
