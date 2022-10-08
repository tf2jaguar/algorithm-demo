//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 动态规划 👍 1448 👎 0

package leetcode.editor.cn;

/**
 * 和 116题一样
 * title: 55 : 跳跃游戏
 * since: 2021-10-23 16:09:34
 */
public class Q55_JumpGame {
    public static void main(String[] args) {
        Solution solution = new Q55_JumpGame().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            boolean[] dp = new boolean[nums.length];
            dp[0] = true;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = false;
                for (int j = 0; j < i; j++) {
                    if (dp[j] && j + nums[j] >= i) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[nums.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}