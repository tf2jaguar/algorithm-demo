/*
 * 描述
 * 给出不同面额的硬币以及一个总金额. 写一个方法来计算给出的总金额可以换取的最少的硬币数量. 如果已有硬币的任意组合均无法与总金额面额相等, 那么返回 -1.
 * <p>
 * 你可以假设每种硬币均有无数个
 * 总金额不会超过10000
 * 硬币的种类数不会超过500, 每种硬币的面额不会超过100
 * <p>
 * 样例
 * 样例1
 * <p>
 * 输入：
 * [1, 2, 5]
 * 11
 * 输出： 3
 * 解释： 11 = 5 + 5 + 1
 * 样例2
 * <p>
 * 输入：
 * [2]
 * 3
 * 输出： -1
 */
package lintcode.com;


/**
 * 669 · 换硬币
 *
 * @author zhangguodong
 */
public class CoinChange {
    public static void main(String[] args) {
        CoinChange slo = new CoinChange();
        int[] c = new int[]{1, 2, 5};
        int a = 11;
        int res = slo.coinChange(c, a);
        System.out.println(res);
    }

    /**
     * @param coins:  a list of integer
     * @param amount: a total amount of money amount
     * @return the fewest number of coins that you need to make up
     */
    public int coinChange(int[] coins, int amount) {
        // 确定状态 dp[i] 为 能组合成面额为 i 的硬币最少数量
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        // 转移方程 f(n) = Math.min(f(n - coins[1]) + 1,...,f(n - coins[n]) + 1)
        // f(n)等于所有coins中最小的和，即子问题最优时。最后应计算到amount这个值
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                // 边界条件，面额amount 应大于等于硬币coin大小
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
