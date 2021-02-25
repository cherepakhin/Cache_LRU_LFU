package ru.cache;

public class CacheLFU<K, V> implements ICache<K, V> {
    private final int size;

    public CacheLFU(int size) {
        this.size = size;
    }

    @Override
    public void put(K key, V val) {

    }

    @Override
    public V get(K key) {
        return null;
    }
}
