package com.es2.ConnectionPool;

import com.es2.Exceptions.ObjectNotFoundException;
import com.es2.Exceptions.PoolExhaustedException;

import java.util.ArrayList;

public abstract class ObjectPool<T> {
    protected int poolSize;
    protected ArrayList<T> inUse = new ArrayList<>();
    protected ArrayList<T> isAvailable = new ArrayList<>();

    public ObjectPool(int poolSize) {
        this.poolSize = poolSize;
    }

    public abstract T acquire() throws PoolExhaustedException;

    public abstract void release(T obj) throws ObjectNotFoundException;

    public synchronized void resetPool() {
        isAvailable.clear();
        inUse.clear();
    }

    public synchronized void setMaxPoolSize(int size) {
        poolSize = size;
    }
}
