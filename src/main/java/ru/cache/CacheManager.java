package ru.cache;

public class CacheManager<K, V> {
    public static final String MSG_ERROR_SIZE = "Size must greater than 0";
    ICache<K, V> cache;

    public CacheManager(TypeCache typeCache, int size) {
        if (size < 0) {
            throw new IllegalArgumentException(MSG_ERROR_SIZE);
        }
        switch (typeCache) {
            case LFU:
                cache = new CacheLFU<>(size);
                break;
            case LRU:
                cache = new CacheLRU<>(size);
                break;
        }
    }

    public V get(K key) {
        return cache.get(key);
    }

    public void put(K key, V val) {
        cache.put(key, val);
    }
}
