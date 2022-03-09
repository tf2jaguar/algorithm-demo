package zgd.base.org;

/**
 * 位图算法有一个很大的缺点：数据没多少，但是值很大。如：有10个整数，最大值是10亿，那么就得按10亿这个数开辟位图数组的大小，太浪费空间
 * <p>
 * int的上限值是20亿    unsigned int的上限值是40亿
 * <p>
 * 现在有3个值，1,3，10亿，如果用位图算法：
 * - int bitmap[1000000000/32+1]  需要内存大小：30M
 * - 此时用哈希表才3*4 = 12 * 2 = 24byte
 *
 * @author zhangguodong
 * @since 2021/10/21 17:23
 */
public class Bitmap {

    public static void main(String[] args) {
        int[] list = new int[]{3, 98, 79, 43, 21, 98, 33, 44};
        int max = Integer.MIN_VALUE;
        for (int i : list) {
            max = Math.max(max, i);
        }

        int[] bitmap = new int[max / 32 + 1];
        for (int i : list) {
            int index = i / 32;
            int offset = i % 32;
            if ((bitmap[index] & (1 << offset)) == 0) {
                bitmap[index] |= (1 << offset);
            } else {
                System.out.println("第一个重复的数字: " + i);
                break;
            }
        }
    }
}
