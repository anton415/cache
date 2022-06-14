package ru.job4j.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static AbstractCache<String, String> cache = new DirFileCache("");
    private static final String SET_CACHE_DIR = "1. Set cache dir.";
    private static final String LOAD_FILE_TO_CACHE = "2. Load file to cache.";
    private static final String GET_FILE_FROM_CACHE = "3. Get file from cache.";
    private static final String EXIT = "4. Exit.";

    public static void main(String[] args) {
        LOG.info("Menu.");
        LOG.info(SET_CACHE_DIR);
        LOG.info(LOAD_FILE_TO_CACHE);
        LOG.info(GET_FILE_FROM_CACHE);
        LOG.info(EXIT);

        while (true) {
            LOG.info("Enter menu number:");
            Scanner scanner = new Scanner(System.in);
            String userChoice = scanner.nextLine();

            if (userChoice.equals("1")) {
                LOG.info("Enter dir name:");
                String dirName = scanner.nextLine();
                setCacheDir(dirName);
            } else if (userChoice.equals("2")) {
                LOG.info("Enter file name:");
                String fileName = scanner.nextLine();
                loadFileToCache(fileName);
            } else if (userChoice.equals("3")) {
                LOG.info("Enter file name:");
                String fileName = scanner.nextLine();
                LOG.info("\n" + getFileFromCache(fileName));
            } else if (userChoice.equals("4")) {
                break;
            }
        }
    }

    public static void setCacheDir(String dir) {
        cache = new DirFileCache(dir);
    }

    public static void loadFileToCache(String file) {
        cache.put(file, cache.load(file));
    }

    public static String getFileFromCache(String file) {
        return cache.get(file);
    }
}
