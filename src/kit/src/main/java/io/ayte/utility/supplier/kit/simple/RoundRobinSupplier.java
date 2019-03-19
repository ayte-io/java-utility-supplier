package io.ayte.utility.supplier.kit.simple;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;
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
    private final List<? extends T> source;
    private int cursor = 0;

    @Override
    public T get() {
        return source.get(cursor++ % source.size());
    }

    /**
     * Creates new supplier. On zero and single item lists will shortcut
     * to {@link EmptySupplier} and {@link ConstantSupplier}.
     *
     * @param source List to iterate.
     * @param <T> Supplied type.
     *
     * @return New Supplier.
     */
    public static <T> Supplier<T> create(@NonNull List<? extends T> source) {
        switch (source.size()) {
            case 0:
                return EmptySupplier.create();
            case 1:
                return ConstantSupplier.create(source.get(0));
            default:
                return new RoundRobinSupplier<>(source);
        }
    }
}
