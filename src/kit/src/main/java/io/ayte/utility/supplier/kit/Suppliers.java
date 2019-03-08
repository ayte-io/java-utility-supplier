package io.ayte.utility.supplier.kit;

import io.ayte.utility.supplier.kit.factory.ArrayListFactory;
import io.ayte.utility.supplier.kit.factory.HashMapFactory;
import io.ayte.utility.supplier.kit.factory.HashSetFactory;
import io.ayte.utility.supplier.kit.factory.LinkedListFactory;
import io.ayte.utility.supplier.kit.factory.TreeMapFactory;
import io.ayte.utility.supplier.kit.factory.TreeSetFactory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.function.Supplier;

// @Amplified
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Suppliers {
    public static <E> Supplier<Set<E>> hashSetFactory() {
        return Factories.hashSet();
    }

    public static <E> Supplier<Set<E>> hashSetFactory(int capacity) {
        return Factories.hashSet(capacity);
    }

    public static <E> Supplier<Set<E>> hashSetFactory(int capacity, float loadFactor) {
        return Factories.hashSet(capacity, loadFactor);
    }

    public static <E> Supplier<NavigableSet<E>> treeSetFactory(@NonNull Comparator<? super E> comparator) {
        return Factories.treeSet(comparator);
    }

    public static <E extends Comparable<E>> Supplier<NavigableSet<E>> treeSetFactory() {
        return Factories.treeSet();
    }

    public static <K, V> Supplier<Map<K, V>> hashMapFactory() {
        return Factories.hashMap();
    }

    public static <K, V> Supplier<Map<K, V>> hashMapFactory(int capacity) {
        return Factories.hashMap(capacity);
    }

    public static <K, V> Supplier<Map<K, V>> hashMapFactory(int capacity, float loadFactor) {
        return Factories.hashMap(capacity, loadFactor);
    }

    public static <K, V> Supplier<NavigableMap<K, V>> treeMapFactory(@NonNull Comparator<K> comparator) {
        return Factories.treeMap(comparator);
    }

    public static <K extends Comparable<K>, V> Supplier<NavigableMap<K, V>> treeMapFactory() {
        return Factories.treeMap();
    }

    public static <E> Supplier<List<E>> arrayListFactory(int capacity) {
        return Factories.arrayList(capacity);
    }

    public static <E> Supplier<List<E>> arrayListFactory() {
        return Factories.arrayList();
    }

    public static <E> Supplier<List<E>> linkedListFactory() {
        return Factories.linkedList();
    }
}
