//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics 数组 双指针 排序 👍 1048 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * title: 16 : 最接近的三数之和
 * create: 2022-02-23 15:20:01
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        int i = solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            // 先排序
            Arrays.sort(nums);
            int res = nums[0] + nums[1] + nums[2];
            // 穷举 i
            for (int i = 0; i < nums.length - 2; i++) {
                // 双指针
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    int tmp = nums[i] + nums[l] + nums[r];
                    if (Math.abs(res - target) > Math.abs(tmp - target)) {
                        res = tmp;
                    }
                    if (tmp > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}