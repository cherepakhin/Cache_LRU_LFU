package ru.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapLRU<K, V> extends LinkedHashMap<K, V> {
    private final int maxSize;

    public LinkedHashMapLRU(int maxSize) {
        super(maxSize);
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxSize;
    }
}
