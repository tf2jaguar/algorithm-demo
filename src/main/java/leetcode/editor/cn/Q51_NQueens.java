//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 数组 回溯 👍 1556 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * title: 51 : N 皇后
 * create: 2022-11-16 14:55:20
 */
public class Q51_NQueens {
    public static void main(String[] args) {
        Solution solution = new Q51_NQueens().new Solution();
        List<List<String>> lists = solution.solveNQueens(4);
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> res = new LinkedList<>();

        public List<List<String>> solveNQueens(int n) {
            List<String> track = new LinkedList<>();
            StringBuilder defaultStr = new StringBuilder();
            for (int i = 0; i < n; i++) {
                defaultStr.append(".");
            }
            for (int i = 0; i < n; i++) {
                track.add(defaultStr.toString());
            }

            backtrack(track, 0);
            return res;
        }

        private void backtrack(List<String> track, int row) {
            if (track.size() == row) {
                res.add(new LinkedList<>(track));
                return;
            }

            int size = track.get(row).length();
            for (int col = 0; col < size; col++) {
                // 是否满足条件
                if (!isValid(track, row, col)) {
                    continue;
                }

                // 做选择
                String oldStr = track.get(row);
                char[] chars = oldStr.toCharArray();
                chars[col] = 'Q';
                track.set(row, new String(chars));

                backtrack(track, row + 1);
                // 撤销选择
                track.set(row, oldStr);
            }
        }

        private boolean isValid(List<String> track, int row, int col) {
            char queue = 'Q';
            int colLen = 0;
            // 正上方
            for (String s : track) {
                if (s.charAt(col) == queue) return false;
                if (colLen == 0) colLen = s.length();
            }
            // 右上方
            for (int r = row - 1, c = col + 1; r >= 0 && c < colLen; r--, c++) {
                if (track.get(r).charAt(c) == queue) return false;
            }
            // 左上方
            for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
                if (track.get(r).charAt(c) == queue) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}