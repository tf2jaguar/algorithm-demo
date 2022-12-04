//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics 回溯 👍 1196 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * title: 77 : 组合
 * create: 2022-11-17 13:24:31
 */
public class Q77_Combinations {
    public static void main(String[] args) {
        Solution solution = new Q77_Combinations().new Solution();
        System.out.println(solution.combine(4, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> combine(int n, int k) {
            LinkedList<Integer> track = new LinkedList<>();
            backtrack(n, k, 1, track);
            return res;
        }

        /**
         * 按照数字进行 回溯
         *
         * @param n     最大值，边界情况
         * @param k     分成多少组
         * @param start 因为 [1,2] 与 [2,1] 相同，则需要按照顺序处理，忽略掉已经处理的
         * @param track 当前存储数据
         */
        private void backtrack(int n, int k, int start, LinkedList<Integer> track) {
            if (track.size() == k) {
                res.add(new LinkedList<>(track));
                return;
            }
            for (int i = start; i <= n; i++) {
                if (track.contains(i)) {
                    continue;
                }
                track.add(i);
                backtrack(n, k, i, track);
                track.removeLast();
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}