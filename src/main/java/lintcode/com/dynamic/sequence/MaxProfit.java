/*
 * 描述
 * 假设有一个数组，它的第i个元素是一支给定的股票在第i天的价格。如果你最多只允许完成一次交易(例如,一次买卖股票),设计一个算法来找出最大利润。
 *
 * 样例
 * 样例1
 *
 * 输入: [3, 2, 3, 1, 2]
 * 输出: 1
 * 说明：你可以在第三天买入，第四天卖出，利润是 2 - 1 = 1
 * 样例2
 *
 * 输入: [1, 2, 3, 4, 5]
 * 输出: 4
 * 说明：你可以在第0天买入，第四天卖出，利润是 5 - 1 = 4
 * 样例3
 *
 * 输入: [5, 4, 3, 2, 1]
 * 输出: 0
 * 说明：你可以不进行任何操作然后也得不到任何利润
 */
package lintcode.com.dynamic.sequence;

/**
 * 149 · 买卖股票的最佳时机
 *
 * @author zhangguodong
 * @date 2021/10/2 09:41
 */
public class MaxProfit {
    public static void main(String[] args) {
        MaxProfit mp = new MaxProfit();
        System.out.println(mp.maxProfit(new int[]{5, 4, 3, 2, 1}));
    }

    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        if (prices.length == 1) {
            return prices[0];
        }

        int res = 0;
        int min = prices[0];
        for (int price : prices) {
            res = Math.max(res, price - min);
            min = Math.min(min, price);
        }
        return res;
    }
}
