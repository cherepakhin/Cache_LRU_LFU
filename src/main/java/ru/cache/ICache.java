package ru.cache;

public interface ICache<K, V> {
    /**
     * Положить объект в кеш
     *
     * @param key ключ
     * @param val значение
     */
    void put(K key, V val);

    /**
     * Получить значение из кеша по ключу
     *
     * @param key ключ
     * @return сохраненный объект. Null если не найдено.
     */
    V get(K key);
}
