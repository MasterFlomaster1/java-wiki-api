package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class IsReviewedProp extends AbstractProp {

    private IsReviewedProp() {
        super("isreviewed");
    }

    public static class Builder extends AbstractBuilder {

        private final IsReviewedProp isReviewedProp = new IsReviewedProp();

        public IsReviewedProp build() {
            return isReviewedProp;
        }

    }

}
