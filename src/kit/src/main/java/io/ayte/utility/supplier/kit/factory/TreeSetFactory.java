package io.ayte.utility.supplier.kit.factory;

import lombok.NonNull;
import lombok.ToString;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.function.Supplier;

@ToString
public class TreeSetFactory<T> implements Supplier<NavigableSet<T>> {
    private final Comparator<? super T> comparator;

    private TreeSetFactory(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public NavigableSet<T> get() {
        return new TreeSet<>(comparator);
    }

    public static <T> TreeSetFactory<T> create(@NonNull Comparator<? super T> comparator) {
        return new TreeSetFactory<>(comparator);
    }

    public static <T extends Comparable<T>> TreeSetFactory<T> create() {
        return create(Comparator.naturalOrder());
    }
}
