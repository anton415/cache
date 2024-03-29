package ru.job4j.cache;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EmulatorTest {

    @Test
    public void whenLoadFileToCacheThenGetFileFromCache() {
        String dir = "src/test/resources/";
        String file = "text.txt";
        Emulator.setCacheDir(dir);
        Emulator.loadFileToCache(file);
        assertThat(Emulator.getFileFromCache(file), is("This is sample file.\nRead me.\n:)"));
    }
}