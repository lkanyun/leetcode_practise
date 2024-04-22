package cn.shun.leetcode;


import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node {
        private int key;
        private int value;
        private Node left;
        private Node right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int capacity;

    private Map<Integer, Node> cache;


    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            reOrder(node);
            return node.value;
        }
    }

    private void reOrder(Node node) {
        if (cache.size() <= 1 || node.right == null) {
            return;
        }
        Node left = node.left;
        Node right = node.right;
        right.left = node.left;
        if (left != null) {
            left.right = node.right;
        } else {
            head = node.right;
        }
        node.left = tail;
        node.right = null;
        tail.right = node;
        tail = node;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        node = putNode(key, value, node);
        reOrder(node);
        removeOlderElement();
    }

    private void removeOlderElement() {
        if (cache.size() <= capacity) {
            return;
        }
        cache.remove(head.key);
        Node right = head.right;
        right.left = null;
        head.right = null;
        head = right;

    }

    private Node putNode(int key, int value, Node node) {
        if (node == null) {
            node = new Node(key, value);
            if (cache.isEmpty()) {
                tail = node;
                head = node;
            } else {
                tail.right = node;
                node.left = tail;
                tail = node;
            }
            cache.put(key, node);
        } else {
            node.value = value;
        }
        return node;
    }
}
