package dev.masterflomaster1.jwa.common;

import lombok.Getter;

@Getter
@SuppressWarnings("SpellCheckingInspection")
public enum Group {

    ABUSE_FILTER("abusefilter"),
    ABUSE_FILTER_HELPER("abusefilter-helper"),
    ACCOUNT_CREATOR("accountcreator"),
    AUTO_REVIEWER("autoreviewer"),
    BOT("bot"),
    BUREAUCRAT("bureaucrat"),
    CHECK_USER("checkuser"),
    CHECK_USER_TEMPORARY_ACCOUNT_VIEWER("checkuser-temporary-account-viewer"),
    CONFIRMED("confirmed"),
    COPY_VIOBOT("copyviobot"),
    EVENT_COORDINATOR("eventcoordinator"),
    EXTENDED_CONFIRMED("extendedconfirmed"),
    EXTENDED_MOVER("extendedmover"),
    FILE_MOVER("filemover"),
    FOUNDER("founder"),
    IMPORT("import"),
    INTERFACE_ADMIN("interface-admin"),
    IP_BLOCK_EXEMPT("ipblockexempt"),
    MASS_MESSAGE_SENDER("massmessage-sender"),
    NO_IP_INFO("no-ipinfo"),
    PATROLLER("patroller"),
    RESEARCHER("researcher"),
    REVIEWER("reviewer"),
    ROLLBACKER("rollbacker"),
    STEWARD("steward"),
    SUPPRESS("suppress"),
    SYSOP("sysop"),
    TEMPLATE_EDITOR("templateeditor"),
    TRANSWIKI("transwiki");

    private final String value;

    Group(String value) {
        this.value = value;
    }

}
