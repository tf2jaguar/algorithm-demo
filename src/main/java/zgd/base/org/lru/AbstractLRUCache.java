package zgd.base.org.lru;

/**
 * @author : zhangguodong
 * @since : 2022/9/17 11:46
 */
public interface AbstractLRUCache {

    Object get(Object k);

    void put(Object k, Object v);
}
