package io.ayte.utility.supplier.kit.standard;

import io.ayte.utility.supplier.StableSupplier;
import io.ayte.utility.supplier.ThreadSafeSupplier;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ConstantSupplier<T> implements StableSupplier<T>, ThreadSafeSupplier<T> {
    private final T value;

    @Override
    public T get() {
        return value;
    }

    public static <T> ConstantSupplier<T> create(T value) {
        return new ConstantSupplier<>(value);
    }
}
