//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
//
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 1995 👎 0

package leetcode.editor.cn;

/**
 * title: 96 : 不同的二叉搜索树
 * create: 2022-11-14 14:06:45
 */
public class Q96_UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new Q96_UniqueBinarySearchTrees().new Solution();
        int i = solution.numTrees(2);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            // 动态规划
            return dp(n);

            // 卡塔兰数
//            return katalan(n);
        }

        int dp(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            // 给定序列 1⋯n，我们选择数字 i 作为根，则根为 i 的所有二叉搜索树的集合是左子树集合和右子树集合的笛卡尔积，
            // 对于笛卡尔积中的每个元素，加上根节点之后形成完整的二叉搜索树
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];
        }

        /**
         * 卡塔兰数
         * <p>
         * C_0 = 1, C_{n+1} = 2(2n+1) / (n+2) * C_n
         */
        int katalan(int n) {
            // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
            long C = 1;
            for (int i = 0; i < n; ++i) {
                C = C * 2 * (2 * i + 1) / (i + 2);
            }
            return (int) C;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}