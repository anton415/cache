package ru.job4j.cache;

/**
 * Класс для работы с пользователем.
 * Пользователю предоставляются возможности:
 * - указать кэшируемую директорию
 * - загрузить содержимое файла в кэш
 * - получить содержимое файла из кэша
 */
public class Emulator {
    private String cachingDir = "src/test/resources/";
    private final AbstractCache<String, String> cache = new DirFileCache(cachingDir);

    public void setCacheDir(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    public String getCachingDir() {
        return this.cachingDir;
    }

    public void loadFileToCache(String file) {
        cache.put(file, cache.load(file));
    }

    public String getFileFromCache(String file) {
        return cache.get(file);
    }
}
