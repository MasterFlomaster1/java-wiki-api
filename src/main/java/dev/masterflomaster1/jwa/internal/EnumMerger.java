package dev.masterflomaster1.jwa.internal;

import java.util.Set;

public interface EnumMerger {

    <T extends EnumValueProvider> String merge(Set<T> items);

}
