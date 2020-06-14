package week8;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {


    class DLinkNode {
        int val;
        int key;
        DLinkNode prev;
        DLinkNode next;

        public DLinkNode() {

        }

        public DLinkNode(int key, int val) {
            this.key = key;
            this.val = val;
        }


    }

    private Map<Integer, DLinkNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }


    public int get(int key) {
        DLinkNode dLinkNode = cache.get(key);
        if (dLinkNode == null) {
            return -1;
        }
        moveToHead(dLinkNode);
        return dLinkNode.val;

    }

    public void put(int key, int val) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            node = new DLinkNode(key, val);
            cache.put(key, node);
            addToHead(node);
            size++;
            if (size > capacity) {
                DLinkNode dLinkNode = removeTail();
                cache.remove(dLinkNode.key);
                --size;
            }

        } else {
            node.val = val;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkNode dLinkNode) {
        dLinkNode.prev = head;
        dLinkNode.next = head.next;
        head.next.prev = dLinkNode;
        head.next = dLinkNode;
    }

    private void removeNode(DLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    private void moveToHead(DLinkNode dLinkNode) {
        removeNode(dLinkNode);
        addToHead(dLinkNode);
    }

    public DLinkNode removeTail() {
        DLinkNode prev = tail.prev;
        removeNode(prev);
        return prev;

    }
}

class Solution{
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            count ++;
            n = n & (n-1);
        }
        return count;
    }
}
