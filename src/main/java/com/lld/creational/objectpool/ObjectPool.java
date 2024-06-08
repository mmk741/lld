package com.lld.creational.objectpool;

import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class ObjectPool<T> {

    //ensures that multiple threads can borrow and return objects from the pool concurrently without any risk of data corruption
    private ConcurrentLinkedQueue<T> pool;

    public ObjectPool(int size) {
        pool = new ConcurrentLinkedQueue<T>();
        initialize(size);
    }

    public abstract T create();

    private void initialize(int size) {
        for (int i = 0; i < size; i++) {
            pool.add(create());
        }
    }

    public T borrowObject() {
        T object = pool.poll();
        if (object == null) {
            object = create();
        }
        return object;
    }

    public void returnObject(T object) {
        if (object == null) {
            return;
        }
        pool.offer(object);
    }

    public int size() {
        return pool.size();
    }

}