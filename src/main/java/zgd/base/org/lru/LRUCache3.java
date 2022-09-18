package zgd.base.org.lru;

import java.util.HashMap;

/**
 * Hash表 + 双向链表来实现
 *
 * @author : zhangguodong
 * @since : 2022/9/18 09:32
 */
public class LRUCache3 implements AbstractLRUCache {
    HashMap<Integer, Node> map;
    Node doubleList;
    int capacity;

    public LRUCache3(int cap) {
        capacity = cap;
        map = new HashMap<>();
        doubleList = new Node();
    }

    @Override
    public Object get(Object k) {
        if (map.containsKey(k)) {
            return map.get(k);
        }
        return -1;
    }

    @Override
    public void put(Object k, Object v) {
        if (map.containsKey(k)) {
            deleteKey((int) k);
            addRecently((int) k, (int) v);
            return;
        }
        if (doubleList.size() == capacity) {
            removeLeastRecently();
        }
        addRecently((int) k, (int) v);
    }

    /* 将某个 void key 提升为最近使⽤的*/
    private void makeRecently(int key) {
        Node node = map.get(key);
        doubleList.remove(node);
        doubleList.addLast(node);
    }

    /*添加最近使用的元素*/
    private void addRecently(int key, int val) {
        Node node = new Node(key, val);
        doubleList.addLast(node);
        map.put(key, node);
    }

    /*删除某一个key*/
    private void deleteKey(int key) {
        Node node = map.get(key);
        doubleList.remove(node);
        map.remove(key);
    }

    /*删除最久未使用的元素*/
    private void removeLeastRecently() {
        Node node = doubleList.removeFirst();
        map.remove(node.key);
    }

    class Node {
        int key, val;
        int size;
        Node pre, next;
        Node head, tail;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public Node() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        // 在链表尾部添加节点 x，时间 O(1)
        public void addLast(Node x) {
            x.pre = tail.pre;
            x.next = tail;
            tail.pre.next = x;
            tail.pre = x;
            size++;
        }

        // 删除链表中的 x 节点（ x ⼀定存在）
        public void remove(Node x) {
            x.pre.next = x.next;
            x.next.pre = x.pre;
            // 清空指针
            x.next = null;
            size--;
        }

        public Node removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Node next = head.next;
            remove(next);
            return next;
        }

        public int size() {
            return size;
        }
    }

}
