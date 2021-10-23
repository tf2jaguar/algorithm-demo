//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 👍 303 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * title: 剑指 Offer 29 : 顺时针打印矩阵
 * since: 2021-10-23 16:18:42
 */
public class ShunShiZhenDaYinJuZhenLcof {
    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length < 1) {
                return new int[0];
            }
            List<Integer> res = new LinkedList<>();
            int ar = 0, ac = 0;
            int br = matrix.length - 1, bc = matrix[0].length - 1;
            while (ar <= br && ac <= bc) {
                printEdge(matrix, ar++, ac++, br--, bc--, res);
            }
            return res.stream().mapToInt(r -> r).toArray();
        }

        private void printEdge(int[][] matrix, int ar, int ac, int br, int bc, List<Integer> res) {
            // 同一行
            if (ar == br) {
                for (int i = ac; i <= bc; i++) {
                    res.add(matrix[ar][i]);
                }
            } else if (ac == bc) { // 同一列
                for (int i = ar; i <= br; i++) {
                    res.add(matrix[i][ac]);
                }
            } else {
                int curRow = ar;
                int curColumn = ac;
                while (curColumn < bc) {
                    res.add(matrix[curRow][curColumn++]);
                }
                while (curRow < br) {
                    res.add(matrix[curRow++][curColumn]);
                }
                while (curColumn > ac) {
                    res.add(matrix[curRow][curColumn--]);
                }
                while (curRow > ar) {
                    res.add(matrix[curRow--][curColumn]);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}