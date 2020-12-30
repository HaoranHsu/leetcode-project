package leetcode146;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2019-2020, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode_146
 * @ClassName: LRUCache
 * @Author: Tristan Shu
 * @CreateDate: 2020/12/23 下午9:21
 * @Version: 1.0
 */
public class LRUCache {
    private class HLinkedNode{
        private int value;
        private int key;
        HLinkedNode(){

        }
        HLinkedNode(int key,int value){
            this.value = value;
            this.key = key;
        }
        HLinkedNode prev;
        HLinkedNode next;
    }
    private HLinkedNode head;
    private HLinkedNode tail;
    private int capacity;
    private int size;
    private Map<Integer,HLinkedNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new HLinkedNode();
        tail = new HLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        HLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }else {
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        HLinkedNode node = cache.get(key);
        if(node != null){
            node.value = value;
            moveToHead(node);
        }
        else {
            HLinkedNode newNode = new HLinkedNode(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            size++;
            if(size > capacity){
                HLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        }
    }

    private HLinkedNode removeTail() {
        HLinkedNode res = tail.prev;
        cache.remove(res.key);
        removeNode(res);
        return res;
    }

    private void addToHead(HLinkedNode newNode) {
        newNode.prev = head;
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
    }

    private void removeNode(HLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(HLinkedNode node){
        removeNode(node);
        addToHead(node);
    }
    




}
