/*
 * 描述
 * 给定一个二维矩阵, 每一个格子可能是一堵墙 W,或者 一个敌人 E 或者空 0 (数字 '0'), 返回你可以用一个炸弹杀死的最大敌人数. 炸弹会杀死所有在同一行和同一列没有墙阻隔的敌人。 由于墙比较坚固，所以墙不会被摧毁.
 *
 * 你只能在空的地方放置炸弹.
 *
 * 样例
 * 样例1
 *
 * 输入:
 * grid =[
 *      "0E00",
 *      "E0WE",
 *      "0E00"
 * ]
 * 输出: 3
 * 解释:
 * 把炸弹放在 (1,1) 能杀3个敌人
 * 样例2
 *
 * 输入:
 * grid =[
 *      "0E00",
 *      "EEWE",
 *      "0E00"
 * ]
 * 输出: 2
 * 解释:
 * P把炸弹放在 (0,0) 或 (0,3) 或 (2,0) 或 (2,3) 能杀2个敌人
 */
package lintcode.com.coordinate;

/**
 * 553 · 炸弹袭击
 *
 * @author zhangguodong
 * @date 2021/9/27 10:50
 */
public class MaxKilledEnemies {
    /**
     * @param grid: Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return: an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }

        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];

        int i, j, res = 0;
        // 向上爆炸 up
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    up[i][j] = 0;
                    continue;
                }
                up[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (i > 0) {
                    up[i][j] += up[i - 1][j];
                }
            }
        }
        // 向下爆炸 down
        for (i = m - 1; i >= 0; i--) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    down[i][j] = 0;
                    continue;
                }
                down[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (i < m - 1) {
                    down[i][j] += down[i + 1][j];
                }
            }
        }
        // 向左爆炸 left
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    left[i][j] = 0;
                    continue;
                }
                left[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (j > 0) {
                    left[i][j] += left[i][j - 1];
                }
            }
        }

        // 向右爆炸 right
        for (i = 0; i < m; i++) {
            for (j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 'W') {
                    right[i][j] = 0;
                    continue;
                }
                right[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (j < n - 1) {
                    right[i][j] += right[i][j + 1];
                }
            }
        }
        // 汇总，找到空地位置中最大的
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    int tmp = up[i][j] + down[i][j] + left[i][j] + right[i][j];
                    res = Math.max(res, tmp);
                }
            }
        }
        return res;
    }
}
