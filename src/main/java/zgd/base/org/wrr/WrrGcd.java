package zgd.base.org.wrr;

/**
 * 加权轮询算法(wrr)
 * LVS版本(最大大公约数)
 */
public class WrrGcd implements IWrr {
    final int gcd;
    final int max;
    final Element[] elements;

    public WrrGcd(Element[] elements) {
        Integer gcd = null;
        int max = 0;
        for (Element ele : elements) {
            gcd = gcd == null ? ele.weight : gcd(gcd, ele.weight);
            max = Math.max(max, ele.weight);
        }
        this.gcd = gcd;
        this.max = max;
        this.elements = elements;
    }

    int i = -1;
    int cw = 0;

    @Override
    public String next() {
        for (; ; ) {
            final int n = elements.length;
            i = (i + 1) % n;
            if (i == 0) {
                cw = cw - gcd;
                if (cw <= 0) {
                    cw = max;
                    if (cw == 0) {
                        return null;
                    }
                }
            }
            if (elements[i].weight >= cw) {
                return elements[i].peer;
            }
        }
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}