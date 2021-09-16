//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n²) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 👍 1869 👎 0

package leetcode.editor.cn;

/**
 * title: 300 : 最长递增子序列
 * create: 2021-09-16 08:51:49
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int i = solution.lengthOfLIS(arr);
        System.out.println(1>>1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 最长递增、可以不连续（与最长连续递增子序列近似）
         */
        public int lengthOfLIS(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return 0;
            }
            return LIS(nums, len);
        }

        /**
         * 动态规划+贪心+二分
         */
        private int Lis(int[] nums) {
            // 严格单调数组
            int[] tail = new int[nums.length];
            int size = 0;
            for (int num : nums) {
                int i = 0, j = size;
                // 二分查找定位
                while (i < j) {
                    int m = (i + j) >> 1;
                    if (tail[m] < num) {
                        i = m + 1;
                    } else {
                        j = m;
                    }
                }
                tail[i] = num;
                if (size == j) {
                    size++;
                }
            }
            return size;
        }

        /**
         * 动态规划 O(N^2)
         */
        private int LIS(int[] nums, int len) {
            // 1. 确定状态: dp[i] 为nums[i]结尾的 最长递增子序列长度
            // 1.1 最优策略最后一步: dp[i] 为nums中i位置为结尾的最长递增子序列长度；
            // 1.2 第一步: dp[0] = 1 第一个字符有一个长度
            // 1.3 case1：只有一个字符； case2：有多个字符 且满足 nums[i-n] < nums[i] 则 dp[i] = max(dp[i-n] + 1, dp[i])
            // 1.4 子问题：nums[i-n] 的最长递增子序列
            // 2. 转移方程 dp[i] = max{dp[1],dp[2],...,dp[n]}
            int[] dp = new int[len];

            int res = 0;
            for (int i = 0; i < len; i++) {
                dp[i] = 1;
                for (int j = i; j > 0; j--) {
                    if (nums[j - 1] < nums[i]) {
                        dp[i] = Math.max(dp[j - 1] + 1, dp[i]);
                    }
                }
                res = Math.max(res, dp[i]);
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}