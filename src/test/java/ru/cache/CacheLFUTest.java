package ru.cache;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CacheLFUTest {

    private final int size = 2;
    String KEY_FIRST = "KEY_FIRST";
    String VALUE_FIRST = "VALUE_FIRST";
    String KEY_LAST = "KEY_LAST";
    String VALUE_LAST = "VALUE_LAST";
    String KEY_FREQ = "KEY_FREQ";
    String VALUE_FREQ = "VALUE_FREQ";
    private CacheLFU<String, String> cache;

    @Before
    public void setUp() {
        cache = new CacheLFU<>(size);
    }

    @Test
    public void getForNullKey() {
        assertNull(cache.get(null));
    }

    @Test
    public void getForNotExistKey() {
        assertNull(cache.get(""));
    }

    @Test
    public void simplePutGet() {
        cache.put(KEY_FIRST, VALUE_FIRST);
        cache.put(KEY_LAST, VALUE_LAST);

        assertEquals(VALUE_FIRST, cache.get(KEY_FIRST));
        assertEquals(VALUE_LAST, cache.get(KEY_LAST));


    }

    @Test
    public void evict() {
        // KEY_FIRST д.б. выселен, т.к. частота использования KEY_FREQ больше,
        // а KEY_LAST зашел последним
        cache.put(KEY_FREQ, VALUE_FREQ);
        cache.put(KEY_FIRST, VALUE_FIRST);
        cache.get(KEY_FREQ);
        cache.put(KEY_LAST, VALUE_LAST);

        assertNull(cache.get(KEY_FIRST));
        assertEquals(VALUE_FREQ, cache.get(KEY_FREQ));
        assertEquals(VALUE_LAST, cache.get(KEY_LAST));
    }
}