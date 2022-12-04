//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 1858 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * title: 78 : 子集
 * create: 2022-11-17 10:47:00
 */
public class Q78_Subsets {
    public static void main(String[] args) {
        Solution solution = new Q78_Subsets().new Solution();
        List<List<Integer>> subsets = solution.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> subsets(int[] nums) {
            LinkedList<Integer> track = new LinkedList<>();

            backtrack(nums, track, 0);
            return res;
        }

        private void backtrack(int[] nums, LinkedList<Integer> track, int start) {
            res.add(new LinkedList<>(track));

            for (int i = start; i < nums.length; i++) {
                track.add(nums[i]);
                // 注意这里的下标。i 会逐步往后叠加，所以从 i + 1 而不是 start + 1
                backtrack(nums, track, i + 1);
                track.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}