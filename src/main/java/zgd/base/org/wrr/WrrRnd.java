package zgd.base.org.wrr;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

/**
 * 加权轮询算法(wrr)
 * 随机数版本
 */
public class WrrRnd implements IWrr {
    final int total;
    final Element[] elements;
    final Random random = new SecureRandom();

    public WrrRnd(Element[] elements) {
        this.total = Arrays.stream(elements)
                .mapToInt(ele -> ele.weight)
                .sum();

        this.elements = elements;
    }

    @Override
    public String next() {
        final int n = elements.length;
        int index = n - 1;
        int hit = random.nextInt(total);

        for (int i = 0; i < n; i++) {
            if (hit >= 0) {
                hit -= elements[i].weight;
            } else {
                index = i - 1;
                break;
            }
        }

        return elements[index].peer;
    }
}