package ru.job4j.cache;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DirFileCacheTest {

    @Test
    public void whenLoadFileThenGetText() {
        DirFileCache dirFileCache = new DirFileCache();
        String text = dirFileCache.load("src/test/resources/text.txt");
        assertThat(text, is("This is sample file.\nRead me.\n:)"));
    }

    @Test(expected = RuntimeException.class)
    public void whenFileDoesNotExistThenGetException() {
        AbstractCache<String, String> cache = new DirFileCache();
        cache.get("RuntimeException");
    }

    @Test
    public void whenFileExistButDoesNotLoadedThenLoadFileAndGet() {
        AbstractCache<String, String> cache = new DirFileCache();
        String text = cache.load("src/test/resources/text.txt");
        assertThat(text, is("This is sample file.\nRead me.\n:)"));
    }
}