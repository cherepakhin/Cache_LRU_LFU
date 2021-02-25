package ru.cache;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CacheManagerTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void exceptionOnErrorSize() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CacheManager.MSG_ERROR_SIZE);
        CacheManager<String, String> cacheManager = new CacheManager<>(TypeCache.LFU, -1);
    }

    @Test
    public void createCacheLFU() {
        CacheManager<String, String> cacheManager = new CacheManager<>(TypeCache.LFU, 1);
        assertEquals(CacheLFU.class, cacheManager.cache.getClass());
    }

    @Test
    public void createCacheLRU() {
        CacheManager<String, String> cacheManager = new CacheManager<>(TypeCache.LRU, 1);
        assertEquals(CacheLRU.class, cacheManager.cache.getClass());
    }
}