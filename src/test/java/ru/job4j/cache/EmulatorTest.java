package ru.job4j.cache;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EmulatorTest {

    @Test
    public void whenSetCacheDirThenGetCacheDir() {
        String testDir = "highway to hell";
        Emulator.setCacheDir(testDir);
        assertThat(Emulator.getCachingDir(), is(testDir));
    }

    @Test
    public void whenLoadFileToCacheThenGetFileFromCache() {
        String file = "src/test/resources/text.txt";
        Emulator.loadFileToCache(file);
        assertThat(Emulator.getFileFromCache(file), is("This is sample file.\nRead me.\n:)"));
    }
}