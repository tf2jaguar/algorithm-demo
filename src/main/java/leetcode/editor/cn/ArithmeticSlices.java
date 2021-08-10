//如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。 
//
// 
// 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。 
// 
//
// 
// 
// 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。 
//
// 子数组 是数组中的一个连续序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4]
//输出：3
//解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -1000 <= nums[i] <= 1000 
// 
// 
// 
// Related Topics 数组 动态规划 
// 👍 314 👎 0

package leetcode.editor.cn;

/**
 * title: 413 : 等差数列划分
 * create: 2021-08-10 17:57:25
 */
public class ArithmeticSlices {
    public static void main(String[] args) {
        Solution solution = new ArithmeticSlices().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int len, res = 0;
            if (nums == null || (len = nums.length) < 3) {
                return res;
            }

            int lastSub = nums[1] - nums[0], curCount = 0;
            for (int i = 2; i < len; i++) {
                int curSub = nums[i] - nums[i - 1];
                if (lastSub == curSub) {
                    curCount++;
                } else {
                    // 下一个和当前这个不相等。重新开始计数
                    lastSub = nums[i] - nums[i - 1];
                    curCount = 0;
                }
                res += curCount;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}