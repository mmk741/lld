package com.lld.hashMap;

import java.util.Objects;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//we can use ReentrantReadWrite lock for more efficient lock only write and not read
//Source :: chatGpt
public class ThreadSafeHashMap {
}

 class UsingMethodLevelLockHashMap<K, V> {

    static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K, V>[] table;
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private int size;

    public UsingMethodLevelLockHashMap() {
        table = new Node[DEFAULT_CAPACITY];
    }

    private int hash(K key) {
        return (key == null) ? 0 : Math.abs(key.hashCode() % table.length);
    }

    public synchronized void put(K key, V value) {
        int index = hash(key);
        Node<K, V> newNode = new Node<>(key, value);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node<K, V> current = table[index];
            Node<K, V> previous = null;
            while (current != null) {
                if (Objects.equals(current.key, key)) {
                    current.value = value;
                    return;
                }
                previous = current;
                current = current.next;
            }
            previous.next = newNode;
        }
        size++;

        if (size > LOAD_FACTOR * table.length) {
            resize();
        }
    }

    public synchronized V get(K key) {
        int index = hash(key);
        Node<K, V> node = table[index];
        while (node != null) {
            if (Objects.equals(node.key, key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public synchronized boolean containsKey(K key) {
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

    public synchronized void remove(K key) {
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

    private synchronized void resize() {
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

    public synchronized int size() {
        return size;
    }

    public static void main(String[] args) {
        UsingMethodLevelLockHashMap<String, Integer> map = new UsingMethodLevelLockHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println("Size: " + map.size());
        System.out.println("Get 'two': " + map.get("two"));
        System.out.println("Contains 'three': " + map.containsKey("three"));

        map.remove("two");
        System.out.println("Get 'two' after removal: " + map.get("two"));
    }
}

 class FineGrainedLockHashMap<K, V> {

    static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K, V>[] table;
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private int size;
    private  Object[] locks; // Lock array for fine-grained locking

    public FineGrainedLockHashMap() {
        table = new Node[DEFAULT_CAPACITY];
        locks = new Object[DEFAULT_CAPACITY];
        for (int i = 0; i < locks.length; i++) {
            locks[i] = new Object();
        }
    }

    private int hash(K key) {
        return (key == null) ? 0 : Math.abs(key.hashCode() % table.length);
    }

    public void put(K key, V value) {
        int index = hash(key);
        synchronized (locks[index]) {
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
                previous.next = newNode;
            }
            size++;

            if (size > LOAD_FACTOR * table.length) {
                resize();
            }
        }
    }

    public V get(K key) {
        int index = hash(key);
        synchronized (locks[index]) {
            Node<K, V> node = table[index];
            while (node != null) {
                if (Objects.equals(node.key, key)) {
                    return node.value;
                }
                node = node.next;
            }
            return null;
        }
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        synchronized (locks[index]) {
            Node<K, V> node = table[index];
            while (node != null) {
                if (Objects.equals(node.key, key)) {
                    return true;
                }
                node = node.next;
            }
            return false;
        }
    }

    public void remove(K key) {
        int index = hash(key);
        synchronized (locks[index]) {
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
    }

    private void resize() {
        synchronized (this) {
            Node<K, V>[] oldTable = table;
            table = new Node[oldTable.length * 2];
            Object[] newLocks = new Object[table.length];
            for (int i = 0; i < newLocks.length; i++) {
                newLocks[i] = new Object();
            }
            locks = newLocks; // Replace lock array after resizing
            size = 0;

            for (Node<K, V> node : oldTable) {
                while (node != null) {
                    put(node.key, node.value);
                    node = node.next;
                }
            }
        }
    }

    public int size() {
        synchronized (this) {
            return size;
        }
    }

    public static void main(String[] args) {
        FineGrainedLockHashMap<String, Integer> map = new FineGrainedLockHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println("Size: " + map.size());
        System.out.println("Get 'two': " + map.get("two"));
        System.out.println("Contains 'three': " + map.containsKey("three"));

        map.remove("two");
        System.out.println("Get 'two' after removal: " + map.get("two"));
    }
}

class ReentrantLockHashMap<K, V> {

    static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K, V>[] table;
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private int size;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public ReentrantLockHashMap() {
        table = new Node[DEFAULT_CAPACITY];
    }

    private int hash(K key) {
        return (key == null) ? 0 : Math.abs(key.hashCode() % table.length);
    }

    public void put(K key, V value) {
        lock.writeLock().lock();
        try {
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
                previous.next = newNode;
            }
            size++;

            if (size > LOAD_FACTOR * table.length) {
                resize();
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public V get(K key) {
        lock.readLock().lock();
        try {
            int index = hash(key);
            Node<K, V> node = table[index];
            while (node != null) {
                if (Objects.equals(node.key, key)) {
                    return node.value;
                }
                node = node.next;
            }
            return null;
        } finally {
            lock.readLock().unlock();
        }
    }

    public boolean containsKey(K key) {
        lock.readLock().lock();
        try {
            int index = hash(key);
            Node<K, V> node = table[index];
            while (node != null) {
                if (Objects.equals(node.key, key)) {
                    return true;
                }
                node = node.next;
            }
            return false;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void remove(K key) {
        lock.writeLock().lock();
        try {
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
        } finally {
            lock.writeLock().unlock();
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
        lock.readLock().lock();
        try {
            return size;
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Writer thread
        Thread writer = new Thread(() -> {
            map.put("one", 1);
            map.put("two", 2);
            map.put("three", 3);
        });

        // Reader threads
        Thread reader1 = new Thread(() -> System.out.println("Get 'two': " + map.get("two")));
        Thread reader2 = new Thread(() -> System.out.println("Contains 'three': " + map.containsKey("three")));

        writer.start();
        reader1.start();
        reader2.start();
    }
}
