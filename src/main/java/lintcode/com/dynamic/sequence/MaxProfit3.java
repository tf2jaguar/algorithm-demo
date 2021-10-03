/*
 * 描述
 * 假设你有一个数组，它的第i个元素是一支给定的股票在第i天的价格。设计一个算法来找到最大的利润。你最多可以完成两笔交易。
 *
 * 你不可以同时参与多笔交易(你必须在再次购买前出售掉之前的股票)
 *
 * 样例
 * 样例 1
 *
 * 输入 : [4,4,6,1,1,4,2,5]
 * 输出 : 6
 */
package lintcode.com.dynamic.sequence;

/**
 * 151 · 买卖股票的最佳时机 III
 *
 * @author zhangguodong
 * @date 2021/10/3 08:08
 */
public class MaxProfit3 {
    public static void main(String[] args) {
        MaxProfit3 mp3 = new MaxProfit3();
        System.out.println(mp3.maxProfit(new int[]{5,7,2,7,3,3,5,3,0}));
    }

    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        int m = prices.length;
        if (m == 0) {
            return 0;
        }
        // 阶段1：第一次买入前
        // 阶段2：持有
        // 阶段3：第一次卖之后，第二次买之前
        // 阶段4：持有
        // 阶段5：第二次卖之后
        int[][] dp = new int[m + 1][5 + 1];
        int i, j;
        // 初始化： 阶段1 获利为 0，其他阶段要求最大值，先初始化为最小值
        dp[0][1] = 0;
        for (i = 2; i <= 5; i++) {
            dp[0][i] = Integer.MIN_VALUE;
        }

        for (i = 1; i <= m; i++) {
            // phase: 1, 3, 5
            for (j = 1; j <= 5; j += 2) {
                // 阶段 1、3、5：前一天没有持有股票 和 前一天持有今天卖出 中最大的
                // dp[i][j] = max{dp[i-1][j], dp[i-1][j-1} + prices[i-1] - price[i-2]
                dp[i][j] = dp[i - 1][j];
                if (i >1 && j > 1 && dp[i - 1][j - 1] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }
            // phase: 2、4
            for (j = 2; j <= 5; j += 2) {
                // 阶段2、4：前一天持有今天继续获利 和 今天买入 中最大的
                // dp[i][j] = max{dp[i-1][j] + prices[i-1] - prices[i-2], dp[i-1][j-1]}
                dp[i][j] = dp[i - 1][j - 1];
                if (i >1 && dp[i - 1][j] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i - 1][j] + prices[i - 1] - prices[i - 2], dp[i][j]);
                }
            }
        }
        return Math.max(dp[m][1], Math.max(dp[m][3], dp[m][5]));
    }
}
