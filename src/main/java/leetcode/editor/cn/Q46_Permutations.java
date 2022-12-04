//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2305 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * title: 46 : 全排列
 * create: 2022-11-16 14:21:01
 */
public class Q46_Permutations {
    public static void main(String[] args) {
        Solution solution = new Q46_Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> permute(int[] nums) {
            LinkedList<Integer> track = new LinkedList<>();
            backtrack(nums, track);
            return res;
        }

        private void backtrack(int[] nums, LinkedList<Integer> track) {
            // 是否满足条件
            if (track.size() == nums.length) {
                // 添加到结果集(深拷贝)
                res.add(new LinkedList<>(track));
                return;
            }

            for (int num : nums) {
                // 做选择
                if (track.contains(num)) {
                    continue;
                }
                track.add(num);

                backtrack(nums, track);
                // 撤销选择
                track.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}