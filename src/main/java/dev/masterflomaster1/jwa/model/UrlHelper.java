package dev.masterflomaster1.jwa.model;

import static dev.masterflomaster1.jwa.model.prop.Revisions.RvProp;

import java.util.Set;
import java.util.stream.Collectors;

public class UrlHelper {

    public static String concat(Set<RvProp> set) {
        return set.stream()
                .map(RvProp::value)
                .collect(Collectors.joining("|"));
    }

//    public static String concat(Set<Prop> set) {
//        return set.stream()
//                .map(Prop::getValue)
//                .collect(Collectors.joining(""));
//    }

}
