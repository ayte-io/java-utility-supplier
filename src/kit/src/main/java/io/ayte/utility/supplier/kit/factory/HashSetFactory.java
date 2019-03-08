package io.ayte.utility.supplier.kit.factory;

import lombok.ToString;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

@ToString
public class HashSetFactory<T> implements Supplier<Set<T>> {
    public static final int DEFAULT_CAPACITY = 16;
    public static final float DEFAULT_LOAD_FACTOR = 0.75F;

    private final int capacity;
    private final float loadFactor;

    public HashSetFactory(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
    }

    @Override
    public Set<T> get() {
        return new HashSet<>(capacity, loadFactor);
    }

    public static <T> HashSetFactory<T> create(int capacity, float loadFactor) {
        return new HashSetFactory<>(capacity, loadFactor);
    }

    public static <T> HashSetFactory<T> create(int capacity) {
        return create(capacity, DEFAULT_LOAD_FACTOR);
    }

    public static <T> HashSetFactory<T> create() {
        return create(DEFAULT_CAPACITY);
    }
}
