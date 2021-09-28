/*
 * 描述
 * 给定一个整数数组（下标从 0 到 n-1， n 表示整个数组的规模），请找出该数组中的最长上升连续子序列。（最长上升连续子序列可以定义为从右到左或从左到右的序列。）
 *
 * 样例
 * 样例 1：
 *
 * 输入：[5, 4, 2, 1, 3]
 * 输出：4
 * 解释：
 * 给定 [5, 4, 2, 1, 3]，其最长上升连续子序列（LICS）为 [5, 4, 2, 1]，返回 4。
 * 样例 2：
 *
 * 输入：[5, 1, 2, 3, 4]
 * 输出：4
 * 解释：
 * 给定 [5, 1, 2, 3, 4]，其最长上升连续子序列（LICS）为 [1, 2, 3, 4]，返回 4。
 * 挑战
 * 使用 O(n) 时间和 O(1) 额外空间来解决
 */
package lintcode.com.dynamic.coordinate;

/**
 * 397 · 最长上升连续子序列
 *
 * @author zhangguodong
 * @date 2021/9/24 08:28
 */
public class LongestIncreasingContinuousSubsequence {
    /**
     * @param A: An array of Integer
     * @return an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        int len = A.length;
        if (len < 1) {
            return 0;
        }

        int l1 = LICS(A, len);
        // reverse
        int i = 0, j = len - 1, tmp;
        while (i < j) {
            tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
            i++;
            j--;
        }
        int l2 = LICS(A, len);
        return Math.max(l1, l2);
    }

    /**
     * 最长连续上升子序列
     */
    private int LICS(int[] a, int len) {
        int[] dp = new int[len];
        int res = 0;
        for (int i = 0; i < len; i++) {
            // 本身是1个
            dp[i] = 1;

            // 如果前一个比他小，就加 1
            if (i > 0 && a[i - 1] < a[i]) {
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
