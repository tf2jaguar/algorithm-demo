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
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 602 · 俄罗斯套娃信封
 *
 * @author zhangguodong
 * @date 2021/10/4 12:47
 */
public class MaxEnvelopes {
    public static void main(String[] args) {
        MaxEnvelopes me = new MaxEnvelopes();
        System.out.println(me.maxEnvelopes(new int[][]{{4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}}));
    }

    /**
     * @param envelopes: a number of envelopes with widths and heights
     * @return: the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length < 1) {
            return 0;
        }

        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int len = envelopes.length;
        int[] dp = new int[len];
        int i, j, res = 0;
        for (i = 0; i < len; i++) {
            dp[i] = 1;
            for (j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
