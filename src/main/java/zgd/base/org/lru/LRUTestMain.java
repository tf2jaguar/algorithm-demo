package zgd.base.org.lru;

/**
 * @author : zhangguodong
 * @since : 2022/9/18 09:33
 */
public class LRUTestMain {
    public static void main(String[] args) {
        LRUCache<String, String> lru = new LRUCache<>(10);
        for (int i = 0; i < 99; i++) {
            lru.put("Key"+i, ""+i);
        }

        System.out.println(lru);
    }
}
