package com.max.design.behavioral.iterator.lang;

/**
 * @author Rick
 * @date 2021-12-02 21:24
 */
public interface Collection<E, L> extends Iterable<E> {

    boolean add(E element);

    boolean remove(E element);

    boolean addLink(String key, L l);

    boolean removeLink(String key);

    Iterator<E> iterator();
}
