//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
// Related Topics 数组 哈希表 前缀和 👍 1564 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * title: 560 : 和为 K 的子数组
 * create: 2022-07-06 15:16:29
 */
public class Q560_SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new Q560_SubarraySumEqualsK().new Solution();
        int i = solution.subarraySum(new int[]{1, 1, 0}, 3);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 子数组和为 k 的数量。
         * sum(nums[j...i]) = k，则 sum(nums[0...i]) - sum(nums[0...j]) = k 即 sum(nums[0...i]) - k = sum(nums[0...j])
         */
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int pre = 0, count = 0;
            for (int num : nums) {
                // 前缀和
                pre += num;
                if (map.containsKey(pre - k)) {
                    count += map.get(pre - k);
                }
                // 定义 pre
                map.put(pre, map.getOrDefault(pre, 0) + 1);
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}