package com.simplyatul.java_samples;

import java.util.*;
import java.util.Map.Entry;
import java.util.logging.Logger;

class Node {
    public int key;
    public int value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key))
            return -1;

        Node node = keyToNode.get(key);
        cache.remove(node);
        cache.add(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (keyToNode.containsKey(key)) {
            keyToNode.get(key).value = value;
            get(key);
            return;
        }

        if (cache.size() == capacity) {
            Node lastNode = cache.iterator().next();
            cache.remove(lastNode);
            keyToNode.remove(lastNode.key);
        }

        Node node = new Node(key, value);
        cache.add(node);
        keyToNode.put(key, node);
    }

    public void printCache() {
        Iterator<Entry<Integer, Node>> it = keyToNode.entrySet().iterator();
        System.out.printf("-----------------------------\n");
        while(it.hasNext()) {
            System.out.printf("%d ", it.next().getKey());
        }
        System.out.printf("\n");

        Iterator<Node> i = cache.iterator();
        while(i.hasNext()) {
            System.out.printf("%d ", i.next().key);
        }
        System.out.printf("\n-----------------------------\n");
    }

    private int capacity;
    private Set<Node> cache = new LinkedHashSet<>();
    private Map<Integer, Node> keyToNode = new HashMap<>();

    public static void main(String[] args) {
        LRUCache c = new LRUCache(3);
        c.put(1, 100);
        c.put(20, 200);
        c.put(3, 300);
        System.out.printf("Initial State \n");
        c.printCache();
        c.put(4, 40);
        System.out.printf("After adding key 4 \n");
        c.printCache();
        c.get(20);
        System.out.printf("After acceessing key 20 \n");
        c.printCache();
    }

  }

