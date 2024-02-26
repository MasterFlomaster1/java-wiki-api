package dev.masterflomaster1.jwa.request.prop;

public class IsReviewedProp extends AbstractProp {

    private IsReviewedProp() {
        name = "isreviewed";
    }

    public static class Builder {

        private final IsReviewedProp isReviewedProp = new IsReviewedProp();

        public IsReviewedProp build() {
            return isReviewedProp;
        }

    }

}
