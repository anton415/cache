package ru.job4j.cache;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EmulatorTest {

    @Test
    public void whenSetCacheDirThenGetCacheDir() {
        String testDir = "highway to hell";
        Emulator emulator = new Emulator();
        emulator.setCacheDir(testDir);
        assertThat(emulator.getCachingDir(), is(testDir));
    }

    @Test
    public void whenLoadFileToCacheThenGetFileFromCache() {
        String file = "text.txt";
        Emulator emulator = new Emulator();
        emulator.loadFileToCache(file);
        assertThat(emulator.getFileFromCache(file), is("This is sample file.Read me.:)"));
    }
}