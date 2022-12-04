// 给定一个非空 01 二维数组表示的网格，一个岛屿由四连通（上、下、左、右四个方向）的 1 组成，你可以认为网格的四周被海水包围。
//
//请你计算这个网格中共有多少个形状不同的岛屿。两个岛屿被认为是相同的，当且仅当一个岛屿可以通过平移变换（不可以旋转、翻转）和另一个岛屿重合。
//
//示例 1：
//11000
//11000
//00011
//00011
//给定上图，返回结果 1 。
//
//示例 2：
//11011
//10000
//00001
//11011
//给定上图，返回结果 3 。
//
//注意：
//11
//1
//和
// 1
//11
//是不同的岛屿，因为我们不考虑旋转、翻转操作。
//
//提示：
//二维数组每维的大小都不会超过 50 。

package leetcode.editor.cn;

import java.util.HashSet;

/**
 * title: 694 : 不同岛屿数量
 * create: 2022-12-01 10:01:53
 */
public class Q694_NumDistinctIslands {

    public static void main(String[] args) {
        Solution solution = new Q694_NumDistinctIslands().new Solution();
        int i = solution.numDistinctIslands(new int[][]{
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1},
        });

        System.out.println("numDistinctIslands " + i);
    }

    class Solution {

        public int numDistinctIslands(int[][] grid) {
            int m = grid.length, n = grid[0].length;

            HashSet<String> islands = new HashSet<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        StringBuilder sb = new StringBuilder();
                        // 随意指定方向dir参数即可
                        dfs(grid, i, j, sb, 666);
                        islands.add(sb.toString());
                    }
                }
            }
            // 返回不同岛屿的数量
            return islands.size();
        }

        private void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir) {
            int m = grid.length, n = grid[0].length;
            if (i < 0 || j < 0 || i >= m || j >= n) return;
            if (grid[i][j] == 0) return;

            //做一下标记防止重复
            grid[i][j] = 0;
            // 与其他的岛屿问题的不同点，追加了方向
            // 前序遍历位置：进⼊ (i, j)
            sb.append(dir).append(',');

            //搜索四个方向 上、下、左、右
            dfs(grid, i - 1, j, sb, 1);
            dfs(grid, i + 1, j, sb, 2);
            dfs(grid, i, j - 1, sb, 3);
            dfs(grid, i, j + 1, sb, 4);

            // 后序遍历位置：离开 (i, j)
            sb.append(-dir).append(',');
        }
    }
}
