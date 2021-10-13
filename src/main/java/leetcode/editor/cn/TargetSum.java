//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 动态规划 回溯 👍 919 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * title: 494 : 目标和
 * create: 2021-10-13 14:30:37
 */
public class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{100}, -200));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 假设所有符号为+的元素和为x，符号为-的元素和的 绝对值是y。
         * 我们想要的 s = 正数和 - 负数和的绝对值 = x - y
         * 而已知x与y的和是数组总和：sum = x + y
         * 可以求出 x = (s + sum) / 2 = target
         * <p>
         * 也就是我们要从nums数组里选出几个数，令其和为target
         * 于是就转化成了求容量为target的01背包问题 =>要装满容量为target的背包，有几种方案
         */
        public int findTargetSumWays(int[] nums, int s) {
            int sum = Arrays.stream(nums).sum();
            // 非偶数
            if (((sum + s) & 1) == 1 || sum < s) {
                return 0;
            }
            // 可能为0
            int target = Math.abs((sum + s) / 2);
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int num : nums) {
                for (int i = target; i >= num; i--) {
                    dp[i] += dp[i - num];
                }
            }
            return dp[target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}