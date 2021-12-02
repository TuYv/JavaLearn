package com.max.design.behavioral.iterator.lang;

/**
 * @author Rick
 * @date 2021-12-02 21:26
 */
public interface Iterator<E> {
    boolean hasNext();

    E next();
}
