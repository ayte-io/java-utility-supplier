package io.ayte.utility.supplier.kit.factory;

import io.ayte.utility.supplier.ThreadSafeSupplier;
import lombok.NonNull;
import lombok.ToString;

import java.util.Comparator;
import java.util.NavigableMap;
import java.util.TreeMap;

@ToString
public class TreeMapFactory<K, V> implements ThreadSafeSupplier<NavigableMap<K, V>> {
    private final Comparator<? super K> comparator;

    private TreeMapFactory(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }

    @Override
    public NavigableMap<K, V> get() {
        return new TreeMap<>(comparator);
    }

    public static <K, V> TreeMapFactory<K, V> create(@NonNull Comparator<? super K> comparator) {
        return new TreeMapFactory<>(comparator);
    }

    public static <K extends Comparable<K>, V> TreeMapFactory<K, V> create() {
        return create(Comparator.naturalOrder());
    }
}
