/*
 * 描述
 * 给定一个只含非负整数的m*nm∗n网格，找到一条从左上角到右下角的可以使数字和最小的路径。
 *
 * 你在同一时间只能向下或者向右移动一步
 *
 * 样例
 * 样例 1：
 *
 * 输入：
 *
 * grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：
 *
 * 7
 * 解释：
 *
 * 路线为： 1 -> 3 -> 1 -> 1 -> 1
 *
 * 样例 2：
 *
 * 输入：
 *
 * grid = [[1,3,2]]
 * 输出：
 *
 * 6
 * 解释：
 *
 * 路线是： 1 -> 3 -> 2
 */
package lintcode.com.coordinate;

/**
 * @author zhangguodong
 * @date 2021/9/24 16:12
 */
public class MinPathSum {
    public static void main(String[] args) {
        MinPathSum mps = new MinPathSum();
//        int i = mps.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        int i = mps.minPathSum(new int[][]{{7, 4, 8, 7, 9, 3, 7, 5, 0}, {1, 8, 2, 2, 7, 1, 4, 5, 7}, {4, 6, 4, 7, 7, 4, 8, 2, 1}, {1, 9, 6, 9, 8, 2, 9, 7, 2}, {5, 5, 7, 5, 8, 7, 9, 1, 4}, {0, 7, 9, 9, 1, 5, 3, 9, 4}});
        System.out.println(i);
    }

    /**
     * 110 · 最小路径和
     *
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // 确定状态: f[i][j] 表示从左上角走到当前位置最小的累加和； 坐标型动态规划：
        //          数组下标[i][j] 即为 坐标(i,j)
        // 转移方程: f[i][j] = min{data[i-1][j] , data[i][j-1]} + f[i][j]
        // 初始条件、边界条件: f[i][j] = data[i][j]，i==0 只有左边列的累加；j==0，只有上边行的累加
        // 计算顺序: 按行从左到右，从上到下
        int m = grid.length;
        if (m < 1) {
            return 0;
        }
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }

                int tmp = Integer.MAX_VALUE;
                if (i > 0) {
                    tmp = Math.min(tmp, dp[i - 1][j]);
                }
                if (j > 0) {
                    tmp = Math.min(tmp, dp[i][j - 1]);
                }
                dp[i][j] = tmp + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
