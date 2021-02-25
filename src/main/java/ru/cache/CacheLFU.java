package ru.cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

public class CacheLFU<K, V> implements ICache<K, V> {
    private final int maxSize;
    HashMap<K, V> cache; // хранилище
    HashMap<K, Integer> keyFreq; // частота использования ключа
    TreeMap<Integer, LinkedHashSet<K>> sortedFreq; // ключи, отсортированные по частоте

    public CacheLFU(int maxSize) {
        this.maxSize = maxSize;
        cache = new HashMap<>();
        keyFreq = new HashMap<>();
        sortedFreq = new TreeMap<>();
        sortedFreq.put(1, new LinkedHashSet<>());
    }

    @Override
    public void put(K key, V val) {
        if (cache.containsKey(key)) {
            cache.put(key, val);
            get(key);
            return;
        }
        // Удаление лишнего ключа
        if (cache.size() >= maxSize) {
            Map.Entry<Integer, LinkedHashSet<K>> entry = sortedFreq.firstEntry();
            K evictKey = entry.getValue().iterator().next();
            entry.getValue().remove(evictKey);
            keyFreq.remove(evictKey);
            cache.remove(evictKey);
        }
        // Добавление нового ключа
        cache.put(key, val);
        keyFreq.put(key, 1);
        sortedFreq.get(1).add(key);
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return null;
        }
        if (!cache.containsKey(key)) {
            return null;
        }
        Integer freq = keyFreq.get(key);
        keyFreq.put(key, freq + 1);
        sortedFreq.get(freq).remove(key);
        sortedFreq.putIfAbsent(freq + 1, new LinkedHashSet<>());
        sortedFreq.get(freq + 1).add(key);
        return cache.get(key);
    }
}
