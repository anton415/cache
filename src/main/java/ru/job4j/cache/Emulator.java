package ru.job4j.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Scanner;

/**
 * Класс для работы с пользователем.
 * Пользователю предоставляются возможности:
 * - указать кэшируемую директорию
 * - загрузить содержимое файла в кэш
 * - получить содержимое файла из кэша
 */
public class Emulator {
    private static final Logger LOG = LoggerFactory.getLogger(Emulator.class.getName());
    private static String cachingDir = "src/test/resources/";
    private static final AbstractCache<String, String> CACHE = new DirFileCache(cachingDir);

    public static void main(String[] args) {
        LOG.info("Menu.");
        LOG.info("1. Set cache dir.");
        LOG.info("2. Get cache dir.");
        LOG.info("3. Load file to cache.");
        LOG.info("4. Get file from cache.");
        LOG.info("5. Exit.");

        while (true) {
            LOG.info("Enter menu number:");
            Scanner scanner = new Scanner(System.in);
            String userChoice = scanner.nextLine();

            if (userChoice.equals("1")) {
                LOG.info("Enter dir name:");
                String dirName = scanner.nextLine();
                setCacheDir(dirName);
            } else if (userChoice.equals("2")) {
                LOG.info("\n" + getCachingDir());
            } else if (userChoice.equals("3")) {
                LOG.info("Enter file name:");
                String fileName = scanner.nextLine();
                loadFileToCache(fileName);
            } else if (userChoice.equals("4")) {
                LOG.info("Enter file name:");
                String fileName = scanner.nextLine();
                LOG.info("\n" + getFileFromCache(fileName));
            } else if (userChoice.equals("5")) {
                break;
            }
        }
    }

    public static void setCacheDir(String dir) {
        cachingDir = dir;
    }

    public static String getCachingDir() {
        return cachingDir;
    }

    public static void loadFileToCache(String file) {
        CACHE.put(file, CACHE.load(file));
    }

    public static String getFileFromCache(String file) {
        return CACHE.get(file);
    }
}
