/*
 * 描述
 * 给定数组 prices, 其中第 i 个元素代表某只股票在第 i 天第价格.
 *
 * 你最多可以完成 k 笔交易. 问最大的利润是多少?
 *
 * 你不可以同时参与多笔交易(你必须在再次购买前出售掉之前的股票)
 *
 * 样例
 * 样例 1:
 *
 * 输入: k = 2, prices = [4, 4, 6, 1, 1, 4, 2 ,5]
 * 输出: 6
 * 解释: 以 4 买入, 以 6 卖出. 然后再以 1 买入, 以 5 卖出. 利润为 2 + 4 = 6.
 * 样例 2:
 *
 * 输入: k = 1, prices = [3, 2, 1]
 * 输出: 0
 * 解释: 不进行交易
 * 挑战
 * O(nk) 时间复杂度. n 是 prices 数组的大小.
 */
package lintcode.com.dynamic.sequence;

/**
 * 393 · 买卖股票的最佳时机 IV
 *
 * @author zhangguodong
 * @date 2021/10/4 07:08
 */
public class MaxProfit4 {
    public static void main(String[] args) {
        MaxProfit4 mp4 = new MaxProfit4();
        System.out.println(mp4.maxProfit(2, new int[]{4, 4, 6, 1, 1, 4, 2, 5}));
    }

    /**
     * @param K:      An integer
     * @param prices: An integer array
     * @return: Maximum profit
     */
    public int maxProfit(int K, int[] prices) {
        int m = prices.length;
        if (m == 0) {
            return 0;
        }
        int n = 2 * K + 1;
        int i, j;
        // 与之前的最大收益 1～3不同，这里是任意k次，则可能造成内存溢出
        // 当买卖的次数大于 m/2 时，则只要下一次的价格大于当前价格，就能今天买入，明天卖出
        if (K > m / 2) {
            int sum = 0;
            for (i = 0; i < m - 1; i++) {
                if (prices[i + 1] > prices[i]) {
                    sum += (prices[i + 1] - prices[i]);
                }
            }
            return sum;
        }

        // 滚动数组
        int[][] dp = new int[2][n + 1];
        int old, now = 0;

        // 初始化，求最大值，此处初始化为Integer.MIN_VALUE
        dp[now][1] = 0;
        for (i = 2; i <= n; i++) {
            dp[now][i] = Integer.MIN_VALUE;
        }

        for (i = 1; i <= m; i++) {
            old = now;
            now = 1 - now;
            // 处于1、3、5、……、2K+1  -- 手中无股票状态
            for (j = 1; j <= n; j += 2) {
                dp[now][j] = dp[old][j];
                if (i > 1 && j > 1 && dp[old][j - 1] != Integer.MIN_VALUE) {
                    dp[now][j] = Math.max(dp[now][j], dp[old][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }
            // 处于2、4、6、……、2K  -- 手中有股票状态
            for (j = 2; j <= n - 1; j += 2) {
                dp[now][j] = dp[old][j - 1];
                if (i > 1 && dp[old][j] != Integer.MIN_VALUE) {
                    dp[now][j] = Math.max(dp[old][j] + prices[i - 1] - prices[i - 2], dp[now][j]);
                }
            }
        }

        int res = 0;
        for (i = 1; i <= n; i += 2) {
            res = Math.max(res, dp[now][i]);
        }
        return res;
    }
}
