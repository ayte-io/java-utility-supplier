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
public class Factories {
    public static <E> Supplier<Set<E>> set() {
        return hashSet();
    }

    public static <E> Supplier<Set<E>> hashSet() {
        return HashSetFactory.create();
    }

    public static <E> Supplier<Set<E>> hashSet(int capacity) {
        return HashSetFactory.create(capacity);
    }
    
    public static <E> Supplier<Set<E>> hashSet(int capacity, float loadFactor) {
        return HashSetFactory.create(capacity, loadFactor);
    }
    
    public static <E> Supplier<NavigableSet<E>> treeSet(@NonNull Comparator<? super E> comparator) {
        return TreeSetFactory.create(comparator);
    }

    public static <E extends Comparable<E>> Supplier<NavigableSet<E>> treeSet() {
        return TreeSetFactory.create();
    }

    public static <K, V> Supplier<Map<K, V>> hashMap() {
        return HashMapFactory.create();
    }

    public static <K, V> Supplier<Map<K, V>> hashMap(int capacity) {
        return HashMapFactory.create(capacity);
    }

    public static <K, V> Supplier<Map<K, V>> hashMap(int capacity, float loadFactor) {
        return HashMapFactory.create(capacity, loadFactor);
    }

    public static <K, V> Supplier<NavigableMap<K, V>> treeMap(@NonNull Comparator<? super K> comparator) {
        return TreeMapFactory.create(comparator);
    }

    public static <K extends Comparable<K>, V> Supplier<NavigableMap<K, V>> treeMap() {
        return TreeMapFactory.create();
    }

    public static <E> Supplier<List<E>> arrayList() {
        return ArrayListFactory.create();
    }

    public static <E> Supplier<List<E>> arrayList(int capacity) {
        return ArrayListFactory.create(capacity);
    }

    public static <E> Supplier<List<E>> linkedList() {
        return LinkedListFactory.create();
    }
}
