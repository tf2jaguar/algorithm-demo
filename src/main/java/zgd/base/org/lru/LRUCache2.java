package zgd.base.org.lru;

import java.util.LinkedHashMap;

/**
 * LinkedHashMap 通过移动节点实现
 *
 * @author : zhangguodong
 * @since : 2022/9/17 11:44
 */
public class LRUCache2 implements AbstractLRUCache {
    int size = 0;
    LinkedHashMap<Object, Object> map = new LinkedHashMap<>();

    public LRUCache2(int capacity) {
        this.size = capacity;
    }

    @Override
    public Object get(Object k) {
        if (!map.containsKey(k)) {
            return -1;
        }
        // k 变为最近使用
        makeRecently(k);
        return map.get(k);
    }

    @Override
    public void put(Object k, Object v) {
        if (map.containsKey(k)) {
            // 直接修改，同时变为最近使用
            map.put(k, v);
            makeRecently(k);
            return;
        }

        if (map.size() >= size) {
            // 链表头就是最久未使用的
            Object oldestKey = map.keySet().iterator().next();
            map.remove(oldestKey);
        }
        // 将新的k添加到链表尾部
        map.put(k, v);
    }

    private void makeRecently(Object k) {
        Object val = map.get(k);
        // 删除旧的，增加新的
        map.remove(k);
        map.put(k, val);
    }

}
