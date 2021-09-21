/*
 * 描述
 * 有一个机器人的位于一个 m × n 个网格左上角。
 *
 * 机器人每一时刻只能向下或者向右移动一步。机器人试图达到网格的右下角。
 *
 * 问有多少条不同的路径？
 *
 * n和m均不超过100
 * 且答案保证在32位整数可表示范围内。
 *
 * 样例
 * 样例 1：
 *
 * 输入：
 *
 * n = 1
 * m = 3
 * 输出：
 *
 * 1
 * 解释：
 *
 * 只有一条通往目标位置的路径。
 *
 * 样例 2：
 *
 * 输入：
 *
 * n = 3
 * m = 3
 * 输出：
 *
 * 6
 * 解释：
 *
 * D : Down
 * R : Right
 *
 * DDRR
 * DRDR
 * DRRD
 * RRDD
 * RDRD
 * RDDR
 */
package lintcode.com;

/**
 * 114 · 不同的路径
 *
 * @author zhangguodong
 * @date 2021/9/21 17:17
 */
public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        int paths = up.uniquePaths(3, 3);
        System.out.println(paths);
    }

    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return An integer
     */
    public int uniquePaths(int m, int n) {
        // 确定状态: dp[m][n] 为从左上角 (0,0) 有多少种方式可以到达 (m,n)
        // 转移方程: dp[m][n] = dp[m-1][n] + dp[m][n-1]
        // 初始条件、边界条件: dp[0][0] = 1 左上角只有一种方式可以到达；每行或每列开始，都只有一种方式可以到达
        // 计算顺序: 按行从左到右
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
