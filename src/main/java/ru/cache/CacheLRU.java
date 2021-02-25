package ru.cache;

/**
 * Класс для кеша со способом вытеснения LRU
 * @param <K> - тип ключей
 * @param <V> - тип значений
 */
public class CacheLRU<K, V> implements ICache<K, V> {
    private final LinkedHashMapLRU<K, V> hashMap;

    /**
     * @param size - размер кеша
     */
    public CacheLRU(int size) {
        hashMap = new LinkedHashMapLRU<>(size);
    }

    @Override
    public void put(K key, V val) {
        hashMap.put(key, val);
    }

    @Override
    public V get(K key) {
        return hashMap.get(key);
    }
}
