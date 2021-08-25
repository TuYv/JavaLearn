package com.max.learning.sourcecode.java;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author max
 * 尝试自己实现HashMap的API
 * @date 2021/8/19 19:27
 */
@Slf4j
public class HashMap<K, V> implements Map<K, V> {
    //默认 负载因子
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    //初始大小
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    //最大容量
    static final int MAXIMUM_CAPACITY = 1 >>> 30;
    //链表转树的阈值
    static final int TREEIFY_THRESHOLD = 8;
    //长度
    int threshold;
    //负载因子
    final float loadFactor;

    transient int size;
    //修改次数
    transient int modCount;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        Node<K, V>[] tab;
        Node first, e;
        int n, hash;
        K k;
        if ((tab = tables) != null && (n = tab.length) > 0 && (first = tab[(n - 1) & (hash = hash(key))]) != null) {
            if (first.hash == hash && ((k = (K) first.key) == key) || (key != null && key.equals(k))) {
                return (V) first.value;
            }
            if ((e = first.next) != null) {
                //todo treeNode 逻辑
                do {
                    if (e.hash == hash && ((k = (K) e.key) == key) || (key != null && key.equals(k))) {
                        return (V) e.value;
                    }
                } while ((e = e.next) != null);
            }

        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        Node<K, V>[] tab;
        Node<K, V> p;
        int n, i, hash;
        if ((tab = tables) == null && (n = tab.length) == 0) {
            // todo 判断是否需要resize Map
        }
        // 判断是否是空节点
        if ((p = tab[i = (hash = hash(key)) & (n - 1)]) == null) {
            tab[i] = newNode(hash, key, value, null);
        } else {
            Node<K, V> e;
            K k;
            //判断key是否一致
            if (p.hash == hash && ((k = p.key) == key) || (key != null && key.equals(k))) {
                e = p;
            }
            //todo 判断是否为树节点
            //else if (p instanceof )
            else {
                for (int binCount = 0; ; ++binCount) {
                    //如果节点是空 插入node
                    if ((e = (p.next)) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) {
                            //链表转树
                        }
                        break;
                    }
                    //判断key是否一致
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                        break;
                    }
                    p = e;
                }
            }
            //上面的逻辑会使e p 都指向最后一个节点 但是不一定有写入新值
            if (e != null) {
                V oldValue = e.value;
                //todo 根据参数 onlyIfAbsent 判断是否覆盖
                e.value = value;
                return oldValue;
            }
        }
        ++modCount;
        if(++size > threshold) {
            //todo resize()map
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {

    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    //node 节点
    @Data
    @AllArgsConstructor
    static class Node<K, V> {
        int hash;
        K key;
        V value;
        Node<K, V> next;
    }

    Node[] tables = null;


    public HashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            log.error("初始化长度不能为负数: " + initialCapacity);
        }
        initialCapacity = Math.min(initialCapacity, MAXIMUM_CAPACITY);
        if (loadFactor < 0 || Float.isNaN(loadFactor)) {
            log.error("负载因子不能为空: " + loadFactor);
        }
        this.loadFactor = loadFactor;
        // 对于不是2的倍数的长度做SizeFor操作
        this.threshold = tableSizeFor(initialCapacity);
    }

    public HashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        ;
    }

    public HashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    int hash(Object key) {
        //定义变量减少一次hashcode计算
        int h;
        //使用扰动函数保证hash值更加的均匀
        return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    Node<K, V> newNode(int hash, K key, V value, Node<K, V> next) {
        return new Node<>(hash, key, value, next);
    }

    int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n > MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.size());
    }
}
