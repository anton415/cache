package ru.job4j.cache;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DirFileCacheTest {

    @Test
    public void whenLoadFileThenGetText() {
        DirFileCache dirFileCache = new DirFileCache("src/test/resources/");
        String text = dirFileCache.load("text.txt");
        assertThat(text, is("This is sample file.Read me.:)"));
    }
}