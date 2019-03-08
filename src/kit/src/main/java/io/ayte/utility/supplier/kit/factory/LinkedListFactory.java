package io.ayte.utility.supplier.kit.factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LinkedListFactory<T> implements Supplier<List<T>> {
    private static final LinkedListFactory INSTANCE = new LinkedListFactory<>();

    @Override
    public List<T> get() {
        return new LinkedList<>();
    }

    @SuppressWarnings("unchecked")
    public static <T> LinkedListFactory<T> create() {
        return INSTANCE;
    }
}
