package com.es2;

import java.util.HashMap;
import java.util.Map;

public class GlobalConfig {
    // The field must be declared volatile so that double check lock would work correctly.
    private static volatile GlobalConfig instance;
    private final Map<String, Object> configurations = new HashMap<>();

    private GlobalConfig(){ }

    public static GlobalConfig getInstant(){
        // The approach taken here is called double-checked locking (DCL). It
        // exists to prevent race condition between multiple threads that may
        // attempt to get singleton instance at the same time, creating separate
        // instances as a result.

        GlobalConfig result = instance;
        if(result != null) {
            return result;
        }
        synchronized (GlobalConfig.class) {
            if (instance == null) {
                instance = new GlobalConfig();
            }
        }

        return instance;
    }

    public void setConfiguration(String key, Object value) {
        configurations.put(key, value);
    }

    public Object getConfiguration(String key) {
        return configurations.get(key);
    }
}