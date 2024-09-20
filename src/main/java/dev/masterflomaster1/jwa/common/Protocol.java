package dev.masterflomaster1.jwa.common;

import lombok.Getter;

@Getter
@SuppressWarnings("SpellCheckingInspection")
public enum Protocol {

    BITCOIN ("bitcoin"),
    FTP ("ftp"),
    FTPS ("ftps"),
    GEO ("geo"),
    GIT ("git"),
    GOPHER ("gopher"),
    HTTP ("http"),
    HTTPS ("https"),
    IRC ("irc"),
    IRCS ("ircs"),
    MAGNET ("magnet"),
    MAILTO ("mailto"),
    MATRIX ("matrix"),
    MMS ("mms"),
    NEWS ("news"),
    NNTP ("nntp"),
    REDIS ("redis"),
    SFTP ("sftp"),
    SIP ("sip"),
    SIPS ("sips"),
    SMS ("sms"),
    SSH ("ssh"),
    SVN ("svn"),
    TEL ("tel"),
    TELNET ("telnet"),
    URN ("urn"),
    WORLDWIND ("worldwind"),
    XMPP ("xmpp");

    private final String value;

    Protocol(String value) {
        this.value = value;
    }

}
