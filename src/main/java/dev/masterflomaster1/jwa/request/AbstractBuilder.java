package dev.masterflomaster1.jwa.request;

import dev.masterflomaster1.jwa.internal.EnumMerger;
import dev.masterflomaster1.jwa.internal.EnumValueProvider;

import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractBuilder implements EnumMerger {

    @Override
    public <T extends EnumValueProvider> String merge(Set<T> items) {
        return items.stream()
                .map(EnumValueProvider::getValue)
                .collect(Collectors.joining("|"));
    }

    @Override
    public String mergeInt(Set<Integer> items) {
        return items.stream()
                .map(Object::toString)
                .collect(Collectors.joining("|"));
    }

    public String mergeLong(Set<Long> items) {
        return items.stream()
                .map(Object::toString)
                .collect(Collectors.joining("|"));
    }

    @Override
    public String mergeString(Set<String> items) {
        return String.join("|", items);
    }

}
