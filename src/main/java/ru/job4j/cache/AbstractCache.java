package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Структура данных кэш.
 * Можно задать ключ получения объекта кэша и в случае если его нет в памяти,
 * задать поведение загрузки этого объекта в кэш.
 * @param <K>
 * @param <V>
 */
public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public V get(K key) {
        return cache.get(key).get();
    }

    /**
     * Загрузка.
     * Фабричный метод.
     */
    protected abstract V load(K key);

}