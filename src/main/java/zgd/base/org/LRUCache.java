package zgd.base.org;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 最近最少使用
 *
 * @author zhangguodong
 * @date 2021/9/10 15:05
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int CACHE_SIZE;

    public LRUCache(int cacheSize) {
        // 设置一个HashMap的初始大小、加载因子、是否按照访问顺序排序
        super((int) (Math.ceil(cacheSize / 0.75) + 1), 0.75f, true);
        CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > CACHE_SIZE;
    }

    public static void main(String[] args) {
        LRUCache<String, String> lru = new LRUCache<>(10);
        for (int i = 0; i < 99; i++) {
            lru.put("Key"+i, ""+i);
        }

        System.out.println(lru);
    }
}
