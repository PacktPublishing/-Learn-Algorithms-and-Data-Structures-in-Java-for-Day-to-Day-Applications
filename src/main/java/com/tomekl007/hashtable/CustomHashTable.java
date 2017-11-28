package com.tomekl007.hashtable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomHashTable<K, V> {
    private static final int NUMBER_OF_BUCKETS = 10;
    private final List<List<Entry<K, V>>> buckets;

    public CustomHashTable() {
        this.buckets = new ArrayList<>();
        IntStream.range(0, NUMBER_OF_BUCKETS).forEach(i ->
                buckets.add(i, new LinkedList<>())
        );
    }

    public void put(K k, V v) {
        int index = k.hashCode() % NUMBER_OF_BUCKETS;
        Entry<K, V> kvEntry = new Entry<>(k, v);

        List<Entry<K, V>> bucket = buckets.get(index);

        bucket.remove(kvEntry);
        bucket.add(kvEntry);
    }

    public int size() {
        return buckets
                .stream()
                .map(List::size)
                .reduce((integer, integer2) -> integer + integer2)
                .orElse(null);
    }

    public V get(K key) {
        int index = key.hashCode() % NUMBER_OF_BUCKETS;
        List<Entry<K, V>> bucket = buckets.get(index);
        List<V> result = bucket.stream()
                .filter(kv -> kv.key.equals(key))
                .map(Entry::getValue)
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
    }

    public boolean containsKey(K key) {
        return this.get(key) != null;
    }


    public List<Integer> getHashCodesDistribution() {
        return buckets.stream().map(List::size).collect(Collectors.toList());
    }


    private class Entry<K, V> {
        private final K key;
        private final V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
