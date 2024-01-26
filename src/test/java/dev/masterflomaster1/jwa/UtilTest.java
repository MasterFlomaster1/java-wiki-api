package dev.masterflomaster1.jwa;

import dev.masterflomaster1.jwa.model.Util;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static dev.masterflomaster1.jwa.model.prop.Revisions.RvProp;

public class UtilTest {

    @Test
    void test() {
        System.out.println(Util.concat(Set.of(RvProp.IDS, RvProp.TIMESTAMP, RvProp.USER)));
    }

}
