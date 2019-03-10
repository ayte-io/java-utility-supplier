package io.ayte.utility.supplier.kit.simple;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.function.Supplier;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ConstantSupplier<T> implements Supplier<T> {
    private final T value;

    @Override
    public T get() {
        return value;
    }

    public static <T> ConstantSupplier<T> create(T value) {
        return new ConstantSupplier<>(value);
    }
}
