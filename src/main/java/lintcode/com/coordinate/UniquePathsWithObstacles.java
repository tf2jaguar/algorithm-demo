/*
 * 描述
 * "不同的路径" 的跟进问题：
 *
 *  有一个机器人的位于一个 m × n 个网格左上角。
 *
 * 机器人每一时刻只能向下或者向右移动一步。机器人试图达到网格的右下角。
 *
 * 现在考虑网格中有障碍物，那样将会有多少条不同的路径？
 *
 * 网格中的障碍和空位置分别用 1 和 0 来表示。
 *
 * 1 ≤ n ≤ 100
 * 1 ≤ m ≤ 100
 *
 * 样例
 * 样例 1：
 *
 * 输入：
 *
 * obstacleGrid = [[0]]
 * 输出：
 *
 * 1
 * 解释：
 *
 * 只有一个点
 *
 * 样例 2：
 *
 * 输入：
 *
 * obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：
 *
 * 2
 * 解释：
 *
 * 只有 2 种不同的路径
 */
package lintcode.com.coordinate;

/**
 * @author zhangguodong
 * @date 2021/9/23 06:49
 */
public class UniquePathsWithObstacles {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 确定状态: f[i][j] 表示从左上角有多少种方式走到格子(i, j)； 坐标型动态规划：
        //          数组下标[i][j] 即为 坐标(i,j)
        // 转移方程: f[i][j] = f[i-1][j] + f[i][j-1]
        // 初始条件、边界条件: 如果左上角[0][0]或右下角[i][j] 有障碍直接输出0;
        //         否则，[0][0] = 1
        // 计算顺序: 按行从左到右
        int m = obstacleGrid.length;
        if (m < 1) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        if (n < 1) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }


        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 遇到障碍
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                // 初始条件
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                // 分别累加 左边、上边的最大步数
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
