package ru;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.cache.CacheManager;
import ru.cache.TypeCache;

public class CacheManagerTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void exceptionOnErrorSize() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(CacheManager.MSG_ERROR_SIZE);
        CacheManager<String, String> cacheManager = new CacheManager<>(TypeCache.LFU, -1);
    }
}