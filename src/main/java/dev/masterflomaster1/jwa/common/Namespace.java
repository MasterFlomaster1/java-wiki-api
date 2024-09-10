package dev.masterflomaster1.jwa.common;

import lombok.Getter;

/**
 * @see <a href="https://en.wikipedia.org/wiki/Wikipedia:Namespace">Wikipedia:Namespace</a>
 */
@Getter
public enum Namespace {

    ALL_NAMESPACES ("*"),
    MEDIA ("-2"),
    SPECIAL ("-1"),
    ARTICLE ("0"),
    TALK ("1"),
    USER ("2"),
    USER_TALK ("3"),
    WIKIPEDIA ("4"),
    WIKIPEDIA_TALK ("5"),
    FILE ("6"),
    FILE_TALK ("7"),
    MEDIAWIKI ("8"),
    MEDIAWIKI_TALK ("9"),
    TEMPLATE ("10"),
    TEMPLATE_TALK ("11"),
    HELP ("12"),
    HELP_TALK ("13"),
    CATEGORY ("14"),
    CATEGORY_TALK ("15"),
    PORTAL ("100"),
    PORTAL_TALK ("101"),
    DRAFT ("118"),
    DRAFT_TALK ("119"),
    TIMED_TEXT ("710"),
    TIMED_TEXT_TALK ("711"),
    MODULE ("828"),
    MODULE_TALK ("829"),
    GADGET ("2300"),
    GADGET_TALK ("2301"),
    GADGET_DEFINITION ("2302"),
    GADGET_DEFINITION_TALK ("2303");

    private final String value;

    Namespace(String value) {
        this.value = value;
    }

    public static Namespace of(String value) {
        for (Namespace namespace : Namespace.values()) {
            if (namespace.value.equals(value)) {
                return namespace;
            }
        }

        throw new IllegalArgumentException("No such namespace: " + value);
    }

}
