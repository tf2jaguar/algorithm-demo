package zgd.base.org.wrr;

/**
 * @author zhangguodong
 * @since 2021/12/22 19:08
 */
public class Main {
    public static void main(String[] args) {
        Element[] elements = new Element[]{
                new Element("A", 7),
                new Element("B", 2),
                new Element("C", 1),
        };
        int count = 10;
//        IWrr wrr = new WrrSmooth(elements);
        IWrr wrr = new WrrSecurityLoopTreeMap(elements);
        for (int i = 0; i < count; i++) {
            System.out.print(wrr.next() + ",");
        }
        System.out.println();
    }
}
