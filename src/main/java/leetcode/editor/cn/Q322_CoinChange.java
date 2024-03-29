//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
// Related Topics 广度优先搜索 数组 动态规划 👍 1524 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * title: 322 : 零钱兑换
 * create: 2021-10-13 11:40:40
 */
public class Q322_CoinChange {
    public static void main(String[] args) {
        Solution solution = new Q322_CoinChange().new Solution();
        System.out.println(solution.coinChange(new int[]{2}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            long[] dp = new long[amount + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int coin : coins) {
                for (int i = 0; i <= amount; i++) {
                    if (i >= coin) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            return dp[amount] == Integer.MAX_VALUE ? -1 : (int) dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}