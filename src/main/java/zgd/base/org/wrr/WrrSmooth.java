package zgd.base.org.wrr;

import java.util.Arrays;

/**
 * 加权轮询算法(wrr)
 * Nginx版本
 */
public class WrrSmooth implements IWrr {
    class Wrr {
        Element ele;
        int current = 0;

        Wrr(Element ele) {
            this.ele = ele;
        }
    }

    final Wrr[] cachedWeights;

    public WrrSmooth(Element[] elements) {
        this.cachedWeights = Arrays.stream(elements).map(Wrr::new).toArray(Wrr[]::new);
    }

    @Override
    public String next() {
        int total = 0;
        Wrr shed = cachedWeights[0];

        for (Wrr item : cachedWeights) {
            int weight = item.ele.weight;
            total += weight;

            item.current += weight;
            if (item.current > shed.current) {
                shed = item;
            }
        }
        shed.current -= total;
        return shed.ele.peer;
    }
}