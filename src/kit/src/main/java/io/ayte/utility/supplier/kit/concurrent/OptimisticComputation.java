package io.ayte.utility.supplier.kit.concurrent;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Supplier;

@RequiredArgsConstructor
public class OptimisticComputation<T, V> implements Supplier<V> {
    private final Supplier<T> provider;
    private final Function<T, V> transformer;
    private final AtomicReference<State<T, V>> state = new AtomicReference<>();

    @Override
    public V get() {
        while (true) {
            val current = state.get();
            val source = this.provider.get();
            if (current != null && Objects.equals(current.getSource(), source)) {
                return current.getValue();
            }
            val value = transformer.apply(source);
            val replacement = new State<>(source, value);
            if (state.compareAndSet(current, replacement)) {
                return value;
            }
            // Otherwise somebody else has swapped the value. Since
            // there are no guarantees that swapper has been using same
            // source and not outdated one (just by beginning earlier
            // before update), repeat the process.
        }
    }

    @Data
    private static class State<T, V> {
        private final T source;
        private final V value;
    }

    public static <T, V> Supplier<V> create(@NonNull Supplier<T> provider, @NonNull Function<T, V> transformer) {
        return new OptimisticComputation<>(provider, transformer);
    }
}
