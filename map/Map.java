package com.algorithm.map;

/**
 * author : Chip
 * time   : 2023/8/2
 * desc   : Map接口
 */
public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V value);

    int size();

    boolean isEmpty();
}
