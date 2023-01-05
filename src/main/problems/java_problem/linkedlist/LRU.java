package java_problem.linkedlist;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRU {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }

}

class LRUCache {
    int capacity;
    Deque<ListNode> deque;
    Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.deque = new LinkedList<>();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            ListNode newNode = new ListNode(node.key, node.val);
            map.put(key, newNode);
            deque.remove(node);
            deque.add(newNode);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        ListNode node = new ListNode(key, value);
        if (map.size() < capacity) {
            if (map.containsKey(key)) {
                ListNode _Node = map.get(key);
                deque.remove(_Node);
                deque.add(node);
                map.put(key, node);
            } else {
                deque.add(node);
                map.put(key, node);
            }
        } else {
            if (map.containsKey(key)) {
                ListNode _Node = map.get(key);
                deque.remove(_Node);
                map.put(key, node);
                deque.add(node);

            } else {
                ListNode removeNode = deque.poll();
                map.remove(removeNode.key);
                map.put(key, node);
                deque.add(node);
            }
        }

    }

    class ListNode {
        int key;
        int val;
        java_problem.linkedlist.ListNode node;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.node = null;
        }

    }
}





