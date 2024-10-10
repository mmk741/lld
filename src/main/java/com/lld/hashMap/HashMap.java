package com.lld.hashMap;

import java.util.Objects;

public class HashMap<K, V> {

    // Node class for chaining in case of collisions
    static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K, V>[] table; // Array of linked lists
    private static final int DEFAULT_CAPACITY = 16; // Default initial capacity
    private static final float LOAD_FACTOR = 0.75f; // Load factor for resizing
    private int size;

    public HashMap() {
        table = new Node[DEFAULT_CAPACITY];
    }

    private int hash(K key) {

        return (key == null) ? 0 : Math.abs(key.hashCode() % table.length);
    }

    public void put(K key, V value) {
        int index = hash(key);
        Node<K, V> newNode = new Node<>(key, value);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node<K, V> current = table[index];
            Node<K, V> previous = null;
            while (current != null) {
                if (Objects.equals(current.key, key)) {
                    current.value = value; // Update existing value
                    return;
                }
                previous = current;
                current = current.next;
            }
            previous.next = newNode; // Add new node at the end of the chain
        }
        size++;

        if (size > LOAD_FACTOR * table.length) {
            resize();
        }
    }

    public V get(K key) {
        int index = hash(key);
        Node<K, V> node = table[index];
        while (node != null) {
            if (Objects.equals(node.key, key)) {
                return node.value;
            }
            node = node.next;
        }
        return null; // Key not found
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        Node<K, V> node = table[index];
        while (node != null) {
            if (Objects.equals(node.key, key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void remove(K key) {
        int index = hash(key);
        Node<K, V> current = table[index];
        Node<K, V> previous = null;
        while (current != null) {
            if (Objects.equals(current.key, key)) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    private void resize() {
        Node<K, V>[] oldTable = table;
        table = new Node[oldTable.length * 2];
        size = 0;

        for (Node<K, V> node : oldTable) {
            while (node != null) {
                put(node.key, node.value);
                node = node.next;
            }
        }
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println("Size: " + map.size()); // Size: 3
        System.out.println("Get 'two': " + map.get("two")); // Get 'two': 2
        System.out.println("Contains 'three': " + map.containsKey("three")); // Contains 'three': true

        map.remove("two");
        System.out.println("Get 'two' after removal: " + map.get("two")); // Get 'two' after removal: null
    }
}
