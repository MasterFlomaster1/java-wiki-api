package dev.masterflomaster1.jwa.request.prop;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Get transcode status for a given file page.
 */
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class TranscodeStatusProp extends AbstractProp {

    private TranscodeStatusProp() {
        super("transcodestatus");
    }

    public static class Builder {

        private final TranscodeStatusProp transcodeStatusProp = new TranscodeStatusProp();

        public TranscodeStatusProp build() {
            return transcodeStatusProp;
        }

    }

}
