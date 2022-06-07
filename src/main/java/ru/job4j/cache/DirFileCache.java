package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * Программа считывает текстовые файлы из системы и выдавать текст при запросе имени файла.
 * Если в кэше файла нет. Кэш должен загрузить себе данные. По умолчанию в кэше нет ни одного файла.
 * Текстовые файл должны лежать в одной директории. Пример. Names.txt, Address.txt - файлы в системе.
 * При запросе по ключу Names.txt - кэш должен вернуть содержимое файла Names.txt.
 */
public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String text;
        try (BufferedReader in = new BufferedReader(new FileReader(cachingDir + key))) {
            text = in.lines().collect(Collectors.joining());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text;
    }
}