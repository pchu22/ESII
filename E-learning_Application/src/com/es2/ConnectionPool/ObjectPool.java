package com.es2.ConnectionPool;

import java.util.Enumeration;
import java.util.Hashtable;

abstract class ObjectPool<T> {
    private static final long DEFAULT_EXPIRATION_TIME = 60000;
    protected Hashtable<T, Long> lockedResources = new Hashtable<T, Long>();
    protected Hashtable<T, Long> unlockedResources = new Hashtable<T, Long>();

    ObjectPool() { }

    abstract T create();
    abstract boolean validate(T object);
    abstract void dead(T object);

    synchronized T acquireObject()
    {
        long currentTimestamp = System.currentTimeMillis();
        T currentObject;

        if (!unlockedResources.isEmpty()) {
            Enumeration<T> enumerator = unlockedResources.keys();

            while (enumerator.hasMoreElements()) {
                currentObject = enumerator.nextElement();

                if ((currentTimestamp - unlockedResources.get(currentObject)) > DEFAULT_EXPIRATION_TIME) {
                    // object has dead
                    unlockedResources.remove(currentObject);
                    dead(currentObject);
                    currentObject = null;
                } else {
                    if (validate(currentObject)) {
                        unlockedResources.remove(currentObject);
                        lockedResources.put(currentObject, currentTimestamp);
                        return (currentObject);
                    } else {
                        // object failed validation
                        unlockedResources.remove(currentObject);
                        dead(currentObject);
                        currentObject = null;
                    }
                }
            }
        }

        // no objects available, create a new one
        currentObject = create();
        lockedResources.put(currentObject, currentTimestamp);
        return (currentObject);
    }
    synchronized void releaseObject(T object) {
        lockedResources.remove(object);
        unlockedResources.put(object, System.currentTimeMillis());
    }
}