package io.ayte.utility.supplier.kit.simple;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.function.Supplier;

@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmptySupplier<T> implements Supplier<T> {
    private static final EmptySupplier INSTANCE = new EmptySupplier<>();

    @Override
    public T get() {
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> EmptySupplier<T> create() {
        return INSTANCE;
    }
}
