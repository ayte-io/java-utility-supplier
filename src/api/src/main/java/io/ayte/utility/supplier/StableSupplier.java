package io.ayte.utility.supplier;

import java.util.function.Supplier;

/**
 * Marker interface that guarantees that every call to this supplier
 * will return same value, even though it may be not known before first
 * call.
 *
 * <p>
 * This interface doesn't guarantee thread safety, i.e. first call may
 * trigger side-effects several times. Use {@link ThreadSafeSupplier}
 * for this.
 * </p>
 *
 * @param <T> Supplier value type.
 */
public interface StableSupplier<T> extends Supplier<T> {}
