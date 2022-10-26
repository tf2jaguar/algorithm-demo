////给你一个大小为 m x n 的二进制矩阵 grid 。 
////
//// 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边
//缘都
////被 0（代表水）包围着。 
////
//// 岛屿的面积是岛上值为 1 的单元格的数目。 
////
//// 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。 
////
//// 
////
//// 示例 1： 
////
//// 
////输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,
//1,
////0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,
//0,0,
////0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]
//]
////输出：6
////解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
//// 
////
//// 示例 2： 
////
//// 
////输入：grid = [[0,0,0,0,0,0,0,0]]
////输出：0
//// 
////
//// 
////
//// 提示： 
////
//// 
//// m == grid.length 
//// n == grid[i].length 
//// 1 <= m, n <= 50 
//// grid[i][j] 为 0 或 1 
//// 
//// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 741 👎 0
//

package leetcode.editor.cn;

/**
 * title: 695 : 岛屿的最大面积
 * create: 2022-04-07 07:51:49
 */
public class Q695_MaxAreaOfIsland {
    public static void main(String[] args) {
        Solution solution = new Q695_MaxAreaOfIsland().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int r = grid.length;
            int c = grid[0].length;
            int res = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (grid[i][j] == 1) {
                        res = Math.max(res, area(grid, i, j, r, c));
                    }
                }
            }
            return res;
        }

        private int area(int[][] grid, int i, int j, int r, int c) {
            if (i < 0 || i >= r || j < 0 || j >= c || grid[i][j] != 1) {
                return 0;
            }
            // 标记已经处理的岛屿
            grid[i][j] = 0;
            return 1 + area(grid, i + 1, j, r, c) + area(grid, i - 1, j, r, c) + area(grid, i, j + 1, r, c) + area(grid, i, j - 1, r, c);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}