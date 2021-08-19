package com.max.learning.sourcecode.java;

import lombok.Data;

/**
 * @author max
 * 尝试自己实现HashMap的API
 * @date 2021/8/19 19:27
 */
public class HashMap<K,V> {
    //负载因子
    float fuzai = 0.75f;
    //初始大小
    int defalut_length = 16;
    //最大容量
    int max_length = 1 >>> 30;
    //长度
    int length;
    //node 节点
    @Data
    static class Node<K,V> {
        int hash;
        K key;
        V value;
        Node<K,V> next;
    }
    Node[] tables = null;


    HashMap () {
        this.length = defalut_length;
        this.tables = new Node[defalut_length];
    }
    HashMap (int length) {
        //todo 对于不是2的倍数的长度做SizeFor操作
        this.length = length;
        this.tables = new Node[length];
    }
    void set(K key, V value) {
        int hash;
        Node node;
        // todo 判断是否需要resize Map
        // 判断是否是空节点
        if(tables[(hash = hash(key)) & (this.length - 1)] == null)
            tables[hash] = setNode(hash, key,value);
        else {
            node = tables[(hash = hash(key)) & (this.length - 1)];
            if(node != null)
                node = node.next;
            node = setNode(hash,key,value);
        }
    }

    V get(K key) {
        int hash = hash(key);
        Node node;
        if((node = tables[hash * (this.length - 1)]) != null) {
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
}
