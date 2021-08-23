package com.max.learning.sourcecode.java;

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
public class HashMap<K,V> implements Map<K,V>{
    //默认 负载因子
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    //初始大小
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    //最大容量
    static final int MAXIMUM_CAPACITY = 1 >>> 30;
    //长度
    int threshold;
    //负载因子
    final float loadFactor;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
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
        int hash = hash(key);
        Node node;
        if((node = tables[hash * (this.threshold - 1)]) != null) {
            if(hash == node.getHash() && key.equals(node.getKey())) {
                return (V) node.getValue();
            } else {
                while((node = node.next) != null  && key.equals(node.getKey())) {
                    if(hash == node.hash) {
                        return (V) node.getValue();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int hash;
        Node node;
        // todo 判断是否需要resize Map
        // 判断是否是空节点
        if(tables[(hash = hash(key)) & (this.threshold - 1)] == null)
            tables[hash] = setNode(hash, key,value);
        else {
            node = tables[(hash = hash(key)) & (this.threshold - 1)];
            while(node != null)
                node = node.next;
            node = setNode(hash,key,value);
        }
        return value;
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
    static class Node<K,V> {
        int hash;
        K key;
        V value;
        Node<K,V> next;
    }
    Node[] tables = null;


    public HashMap(int initialCapacity, float loadFactor) {
        if(initialCapacity < 0) {
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
    public HashMap () {
        this.loadFactor = DEFAULT_LOAD_FACTOR;;
    }
    public HashMap (int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }
    int hash(Object key) {
        //定义变量减少一次hashcode计算
        int h;
        //使用扰动函数保证hash值更加的均匀
        return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    Node setNode(int hash, K key, V value) {
        Node node = new Node();
        node.setHash(hash);
        node.setKey(key);
        node.setValue(value);

        return node;
    }
    int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 :(n > MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static void main(String[] args) {
        Map<String, String > map = new HashMap<>();
        System.out.println(map.size());
    }
}
