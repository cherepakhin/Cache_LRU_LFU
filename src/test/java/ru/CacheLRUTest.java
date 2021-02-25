package ru;

import org.junit.Before;
import org.junit.Test;
import ru.cache.CacheLRU;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CacheLRUTest {
    private final int SIZE = 2;
    Integer KEY_FIRST = 0;
    String VALUE_FIRST = "VALUE_FIRST";
    Integer KEY_LAST = 1;
    String VALUE_LAST = "VALUE_LAST";
    private CacheLRU<Object, Object> cache;

    @Before
    public void setUp() {
        cache = new CacheLRU<>(SIZE);
    }

    @Test
    public void checkPutGet() {
        cache.put(KEY_FIRST, VALUE_FIRST);
        cache.put(KEY_LAST, VALUE_LAST);
        assertEquals(VALUE_FIRST, cache.get(KEY_FIRST));
        assertEquals(VALUE_LAST, cache.get(KEY_LAST));
    }

    @Test
    public void checkModify() {
        cache.put(KEY_FIRST, VALUE_FIRST);
        cache.put(KEY_FIRST, VALUE_LAST);
        assertEquals(VALUE_LAST, cache.get(KEY_FIRST));
        assertNull(cache.get(KEY_LAST));
    }
}