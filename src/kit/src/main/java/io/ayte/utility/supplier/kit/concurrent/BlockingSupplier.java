package io.ayte.utility.supplier.kit.concurrent;

import io.ayte.utility.supplier.ThreadSafeSupplier;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.function.Supplier;

@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BlockingSupplier<T> implements ThreadSafeSupplier<T> {
    private final Supplier<T> delegate;

    @Override
    public synchronized T get() {
        return delegate.get();
    }

    public static <T> ThreadSafeSupplier<T> create(@NonNull Supplier<T> delegate) {
        if (delegate instanceof ThreadSafeSupplier) {
            return ((ThreadSafeSupplier<T>) delegate);
        }
        return new BlockingSupplier<>(delegate);
    }
}
