package io.ayte.utility.supplier.kit.simple;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Supplier;

/**
 * Supplier that implements round robin scheme, walking over array and
 * getting next item on every call (wrapping on the end).
 *
 * It is implied that list contents may not change, though list is never
 * copied during creation to reduce possible memory pressure.
 *
 * @param <T> Supplied type.
 */
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class RoundRobinSupplier<T> implements Supplier<T> {
    private final Iterable<? extends T> source;
    private Iterator<? extends T> iterator;

    @Override
    public T get() {
        if (iterator == null || !iterator.hasNext()) {
            iterator = source.iterator();
        }
        return iterator.hasNext() ? iterator.next() : null;
    }

    /**
     * Creates new supplier. On zero and single item collections will
     * shortcut to {@link EmptySupplier} and {@link ConstantSupplier}.
     *
     * @param source List to iterate.
     * @param <T> Supplied type.
     *
     * @return New Supplier.
     */
    public static <T> Supplier<T> create(@NonNull Collection<? extends T> source) {
        switch (source.size()) {
            case 0:
                return EmptySupplier.create();
            case 1:
                return ConstantSupplier.create(source.iterator().next());
            default:
                return new RoundRobinSupplier<>(source);
        }
    }

    public static <T> Supplier<T> create(@NonNull Iterable<? extends T> source) {
        return new RoundRobinSupplier<>(source);
    }
}
