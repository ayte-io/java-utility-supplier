package io.ayte.utility.supplier.kit.factory;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@ToString
public class ArrayListFactory<T> implements Supplier<List<T>> {
    public static final int DEFAULT_CAPACITY = 16;

    private static final ArrayListFactory DEFAULT = create(DEFAULT_CAPACITY);

    private final int capacity;

    private ArrayListFactory(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public List<T> get() {
        return new ArrayList<>(capacity);
    }

    @SuppressWarnings("unchecked")
    public static <T> ArrayListFactory<T> create() {
        return DEFAULT;
    }

    public static <T> ArrayListFactory<T> create(int capacity) {
        return new ArrayListFactory<>(capacity);
    }
}
