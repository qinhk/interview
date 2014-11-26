package hongke.interview.leetcode.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hongke on 11/21/14.
 */
public class LRUCache2 {

    final int maxCapacity;
    int capacity;
    Map<Integer, Node> nodes;
    Node head, tail;

    class Node {
        Node prev, next;
        int val, key;
    }

    public LRUCache2(int capacity) {
        if (capacity <= 0) {
            throw new RuntimeException();
        }
        this.maxCapacity = capacity;
        nodes = new HashMap<Integer, Node>();
        head = new Node();
        tail = new Node();
        head.prev = tail;
        tail.next = head;
    }

    public int get(int key) {
        if (capacity <= 0 || !nodes.containsKey(key)) {
            return -1;
        } else {
            Node node = nodes.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = head.prev;
            head.prev.next = node;
            node.next = head;
            head.prev = node;
            return node.val;
        }

    }

    public void set(int key, int value) {
        if (nodes.containsKey(key)) {
            Node node = nodes.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = head.prev;
            head.prev.next = node;
            node.next = head;
            head.prev = node;
            node.val = value;
        } else {
            Node node = new Node();
            node.key = key;
            node.val = value;
            node.prev = head.prev;
            head.prev.next = node;
            node.next = head;
            head.prev = node;
            nodes.put(key, node);
            capacity ++;
            if (capacity > maxCapacity) {
                Node evict = tail.next;
                tail.next = tail.next.next;
                tail.next.prev = tail;
                nodes.remove(evict.key);
            }
        }
    }
}
