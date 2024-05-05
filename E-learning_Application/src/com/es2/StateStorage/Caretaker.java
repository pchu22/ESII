package com.es2.StateStorage;

import java.util.HashMap;
import java.util.Map;

public class Caretaker<T> {
    private Map<String, Memento<T>> memento = new HashMap<>();

    public void saveState(String key, Memento<T> _memento) {
        memento.put(key, _memento);
    }

    public Memento<T> restoreState(String key) {
        return memento.get(key);
    }
}
