package ru.job4j.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Программа считывает текстовые файлы из системы и выдавать текст при запросе имени файла.
 * Если в кэше файла нет. Кэш должен загрузить себе данные. По умолчанию в кэше нет ни одного файла.
 * Текстовые файл должны лежать в одной директории. Пример. Names.txt, Address.txt - файлы в системе.
 * При запросе по ключу Names.txt - кэш должен вернуть содержимое файла Names.txt.
 */
public class DirFileCache extends AbstractCache<String, String> {

    @Override
    protected String load(String key) {
        String text;
        try {
            text = Files.readString(Path.of(key));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text;
    }
}