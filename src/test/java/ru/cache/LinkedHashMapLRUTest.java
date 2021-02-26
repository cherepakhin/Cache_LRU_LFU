package ru.cache;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedHashMapLRUTest {

    @Test
    public void checkEvict() {
        LinkedHashMapLRU<Integer, String> mapLRU = new LinkedHashMapLRU<>(1);
        Integer KEY_FIRST = 0;
        Integer KEY_LAST = 1;
        String VALUE = "VALUE";
        mapLRU.put(KEY_FIRST, VALUE);
        mapLRU.put(KEY_LAST, VALUE);
        assertNull(mapLRU.get(KEY_FIRST));
        assertNotNull(mapLRU.get(KEY_LAST));
    }

    @Test
    public void forNotExistKey() {
        LinkedHashMapLRU<Integer, String> mapLRU = new LinkedHashMapLRU<>(1);
        assertNull(mapLRU.get(1));
    }

    @Test
    public void getForNullKey() {
        LinkedHashMapLRU<Integer, String> mapLRU = new LinkedHashMapLRU<>(1);
        assertNull(mapLRU.get(null));
    }

    @Test
    public void putForNullKey() {
        LinkedHashMapLRU<Integer, String> mapLRU = new LinkedHashMapLRU<>(1);
        String VALUE = "VALUE";
        mapLRU.put(null, VALUE);
        assertEquals(VALUE, mapLRU.get(null));
    }
}