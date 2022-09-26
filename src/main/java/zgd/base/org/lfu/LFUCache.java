package zgd.base.org.lfu;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author : zhangguodong
 * @since : 2022/9/18 16:58
 */
public class LFUCache {
    // key 到 val 的映射
    HashMap<Integer, Integer> keyToVal;
    // key 到 freq 的映射
    HashMap<Integer, Integer> keyToFreq;
    // freq 到 key 列表的映射
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    // 记录最小的频次
    int minFreq;
    // 记录 LFU 缓存的最大容量
    int cap;

    public LFUCache(int capacity) {
        this.keyToVal = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
        this.minFreq = 0;
        this.cap = capacity;
    }

    public int get(int k) {
        if (!keyToVal.containsKey(k)) {
            return -1;
        }
        increaseFreq(k);
        return keyToVal.get(k);
    }

    public void put(int k, int v) {
        if (keyToVal.containsKey(k)) {
            keyToVal.put(k, v);
            increaseFreq(k);
            return;
        }

        if (keyToVal.size() == cap) {
            removeMinFreqKey();
        }

        keyToVal.put(k, v);
        keyToFreq.put(k, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(k);
        this.minFreq = 1;
    }

    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        Integer deletedKey = keyList.iterator().next();
        keyList.remove(deletedKey);

        keyToVal.remove(deletedKey);
        keyToFreq.remove(deletedKey);
        if (keyList.isEmpty()){
            freqToKeys.remove(this.minFreq);
        }
    }

    private void increaseFreq(int k) {
        Integer freq = keyToFreq.get(k);
        keyToFreq.put(k, freq + 1);

        freqToKeys.get(freq).remove(k);
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(k);

        if (freqToKeys.get(freq).isEmpty()){
            freqToKeys.remove(freq);
            if (freq==this.minFreq){
                this.minFreq++;
            }
        }
    }
}
