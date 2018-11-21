package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shortener {
    private Long lastId = new Long(0);
    private StorageStrategy storageStrategy;
    Map<Long, String> storage;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
        storage = new HashMap<>();
    }

    public synchronized Long getId(String string) {
        if(storageStrategy.containsValue(string)) {
            return storageStrategy.getKey(string);
        } else {
            ++lastId;
            storageStrategy.put(lastId, string);
            return lastId;
        }
    }

    public synchronized String getString (Long id) {
        return storageStrategy.getValue(id);
    }
}

