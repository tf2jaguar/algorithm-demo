/*
 * 描述
 * 给定一个数组 prices 表示一支股票每天的价格.
 *
 * 交易次数不限, 不过你不能同时参与多个交易 (也就是说, 如果你已经持有这支股票, 在再次购买之前, 你必须先卖掉它).
 *
 * 设计一个算法求出最大的利润.
 *
 * 样例
 * 样例 1:
 *
 * 输入: [2, 1, 2, 0, 1]
 * 输出: 2
 * 解释:
 *     1. 在第 2 天以 1 的价格买入, 然后在第 3 天以 2 的价格卖出, 利润 1
 *     2. 在第 4 天以 0 的价格买入, 然后在第 5 天以 1 的价格卖出, 利润 1
 *     总利润 2.
 * 样例 2:
 *
 * 输入: [4, 3, 2, 1]
 * 输出: 0
 * 解释: 不进行任何交易, 利润为0.
 */
package lintcode.com.dynamic.sequence;

/**
 * 150 · 买卖股票的最佳时机 II
 * 和 149 买卖股票问题不同点在，149 只能买卖一次，150 可以买卖任意次数，只是买之前要先卖出
 *
 * @author zhangguodong
 * @date 2021/10/2 10:39
 */
public class MaxProfit2 {
    public static void main(String[] args) {
        MaxProfit2 mp2 = new MaxProfit2();
        System.out.println(mp2.maxProfit(new int[]{2, 1, 2, 0, 1}));
    }

    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // 确定状态：dp[i] 在第 i 天，能获得的最大收益
        // 转移方程：dp[i] = max{dp[i-1], dp[i-1]+ (prices[i] - prices[i-1])}
        //         第i天的最大利润是第i-1天第最大利润，加上第i天有无买卖第利润。
        // 初始条件&边界条件：
        // 计算顺序：
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 1] + prices[i] - prices[i - 1]);
        }
        return dp[prices.length - 1];
    }
}
