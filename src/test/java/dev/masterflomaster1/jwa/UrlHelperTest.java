package dev.masterflomaster1.jwa;

import dev.masterflomaster1.jwa.model.UrlHelper;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static dev.masterflomaster1.jwa.model.prop.Revisions.RvProp;

public class UrlHelperTest {

    @Test
    void test() {
        System.out.println(UrlHelper.concat(Set.of(RvProp.IDS, RvProp.TIMESTAMP, RvProp.USER)));
    }

}
