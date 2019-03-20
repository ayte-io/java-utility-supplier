package io.ayte.utility.supplier.kit.factory;

import io.ayte.utility.supplier.ThreadSafeSupplier;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class HashMapFactory<K, V> implements ThreadSafeSupplier<Map<K, V>> {
    public static final int DEFAULT_CAPACITY = 16;
    public static final float DEFAULT_LOAD_FACTOR = 0.75F;

    private final int capacity;
    private final float loadFactor;

    private HashMapFactory(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
    }

    @Override
    public Map<K, V> get() {
        return new HashMap<>(capacity, loadFactor);
    }

    public static <K, V> HashMapFactory<K, V> create(int capacity, float loadFactor) {
        return new HashMapFactory<>(capacity, loadFactor);
    }

    public static <K, V> HashMapFactory<K, V> create(int capacity) {
        return create(capacity, DEFAULT_LOAD_FACTOR);
    }

    public static <K, V> HashMapFactory<K, V> create() {
        return create(DEFAULT_CAPACITY);
    }
}
