//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
// Related Topics 广度优先搜索 数学 动态规划 👍 1108 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * title: 279 : 完全平方数
 * create: 2021-10-13 10:49:22
 */
public class Q279_PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new Q279_PerfectSquares().new Solution();
        System.out.println(solution.numSquares(12));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            // dp[i]: 和为i的完全平方数的最小数量
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int num = 1; num <= Math.sqrt(n); num++) {
                for (int i = 0; i <= n; i++) {
                    if (i >= num * num) {
                        dp[i] = Math.min(dp[i], dp[i - num * num] + 1);
                    }
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}