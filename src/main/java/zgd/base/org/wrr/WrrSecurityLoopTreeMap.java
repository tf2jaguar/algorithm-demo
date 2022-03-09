package zgd.base.org.wrr;

import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 加权轮询算法(wrr)
 * 红黑树版本
 */
public class WrrSecurityLoopTreeMap implements IWrr {
    final int total;
    final AtomicInteger count = new AtomicInteger();
    final TreeMap<Integer, Element> pool = new TreeMap<>();

    public WrrSecurityLoopTreeMap(Element[] elements) {
        int total = 0;
        for (Element ele : elements) {
            total += ele.weight;
            pool.put(total - 1, ele);
        }
        this.total = total;
    }

    @Override
    public String next() {
        final int modulo = total;
        for (; ; ) {
            int hit = count.get();
            int next = (hit + 1) % modulo;
            if (count.compareAndSet(hit, next) && hit < modulo) {
                return pool.ceilingEntry(hit).getValue().peer;
            }
        }
    }

}