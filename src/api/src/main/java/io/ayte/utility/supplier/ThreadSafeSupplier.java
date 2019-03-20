package io.ayte.utility.supplier;

import java.util.function.Supplier;

/**
 * Marker interface that tells client that supplier can be safely used
 * in concurrent environment
 *
 * @param <T> Supplier value type.
 */
public interface ThreadSafeSupplier<T> extends Supplier<T> {}
