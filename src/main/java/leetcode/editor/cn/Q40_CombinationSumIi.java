//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 709 👎 0

package leetcode.editor.cn;

import java.util.*;

/**
 * title: 40 : 组合总和 II
 * create: 2021-10-13 19:22:10
 */
public class Q40_CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new Q40_CombinationSumIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            int len = candidates.length;
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }
            Arrays.sort(candidates);
            Deque<Integer> path = new ArrayDeque<>(len);
            dfs(candidates, len, 0, target, path, res);
            return res;
        }

        private void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = begin; i < len; i++) {
                if (target - candidates[i] < 0) {
                    break;
                }
                // 跳过同一层的相同节点
                if (i > begin && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                path.addLast(candidates[i]);
                dfs(candidates, len, i + 1, target - candidates[i], path, res);
                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}