package dev.masterflomaster1.jwa;

import static dev.masterflomaster1.jwa.model.RevisionsProp.RvProp;

import java.util.Set;
import java.util.stream.Collectors;

public class UrlHelper {

    public static String concat(Set<RvProp> set) {
        return set.stream()
                .map(RvProp::value)
                .collect(Collectors.joining("%7C"));
    }

}
