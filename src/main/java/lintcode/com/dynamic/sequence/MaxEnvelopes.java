/*
 * 描述
 * 给一定数量的信封，带有整数对 (w, h) 分别代表信封宽度和高度。一个信封的宽高均大于另一个信封时可以放下另一个信封。
 * 求最大的信封嵌套层数。
 *
 * 样例
 * 样例 1:
 *
 * 输入：[[5,4],[6,4],[6,7],[2,3]]
 * 输出：3
 * 解释：
 * 最大的信封嵌套层数是 3 ([2,3] => [5,4] => [6,7])。
 * 样例 2:
 *
 * 输入：[[4,5],[4,6],[6,7],[2,3],[1,1]]
 * 输出：4
 * 解释：
 * 最大的信封嵌套层数是 4 ([1,1] => [2,3] => [4,5] / [4,6] => [6,7])。
 */
package lintcode.com.dynamic.sequence;

import java.util.Arrays;

/**
 * 602 · 俄罗斯套娃信封
 *
 * @author zhangguodong
 * @date 2021/10/4 12:47
 */
public class MaxEnvelopes {
    public static void main(String[] args) {
        MaxEnvelopes me = new MaxEnvelopes();
        System.out.println(me.maxEnvelopes(new int[][]{{4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}}) == 4);
        System.out.println(me.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}) == 3);
        System.out.println(me.maxEnvelopes(new int[][]{{15, 8}, {2, 20}, {2, 14}, {4, 17}, {8, 19}, {8, 9}, {5, 7}, {11, 19}, {8, 11}, {13, 11}, {2, 13}, {11, 19}, {8, 11}, {13, 11}, {2, 13}, {11, 19}, {16, 1}, {18, 13}, {14, 17}, {18, 19}}) == 5);

    }

    /**
     * @param envelopes: a number of envelopes with widths and heights
     * @return: the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length < 1) {
            return 0;
        }

        /**
         * 就是当w相同时，h逆序，从大到小排列
         * 针对h求出来的最长递增子序列不会存在w相等，而h递增的情况，因为w相同的时候，右边的数总是小于等于左边的数，不会出现在最长递增子序列里面
         */
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        int len = envelopes.length;
        // 对信封的 高h 求最长递增子序列
        int[] dp = new int[len];
        int size = 0;
        for (int[] envelope : envelopes) {
            int h = envelope[1];
            int l = 0, r = size;
            while (l < r) {
                int m = l + ((r - l) >> 1);
                if (dp[m] < h) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            dp[l] = h;
            if (r == size) {
                size++;
            }
        }

        return size;
    }

}
