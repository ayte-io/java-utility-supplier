package io.ayte.utility.supplier.kit.standard;

import io.ayte.utility.supplier.StableSupplier;
import io.ayte.utility.supplier.ThreadSafeSupplier;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmptySupplier<T> implements StableSupplier<T>, ThreadSafeSupplier<T> {
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
