package com.algorithm.set;

/**
 * author : Chip
 * time   : 2023/8/2
 * desc   :
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int size();

    boolean isEmpty();
}
