package com.other;

import java.util.Objects;

public class MyHashMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int INITIAL_CAPACITY = 16;
    private Entry<K, V>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        buckets = new Entry[INITIAL_CAPACITY];
    }

    private int hash(K key) {
        return (key == null) ? 0 : key.hashCode() & (INITIAL_CAPACITY - 1); // & Much better than %
    }

    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> head = buckets[index];

        // Обновление существующего ключа
        for (Entry<K, V> e = head; e != null; e = e.next) {
            if (Objects.equals(e.key, key)) {
                e.value = value;
                return;
            }
        }

        // Новый элемент в начало списка
        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = head;
        buckets[index] = newEntry;
    }

    public V get(K key) {
        int index = hash(key);
        for (Entry<K, V> e = buckets[index]; e != null; e = e.next) {
            if (Objects.equals(e.key, key)) {
                return e.value;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }
}


class Main {
    public static void main(String[] args) {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        myHashMap.put(1, "one");
        myHashMap.put(2, "two");

        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(2));
        System.out.println(myHashMap.get(3));
    }
}