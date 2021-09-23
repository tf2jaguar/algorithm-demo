/*
 * 描述
 * 这里有n个房子在一列直线上，现在我们需要给房屋染色，分别有红色蓝色和绿色。每个房屋染不同的颜色费用也不同，你需要设计一种染色方案使得相邻的房屋颜色不同，并且费用最小，返回最小的费用。
 *
 * 费用通过一个nx3 的矩阵给出，比如cost[0][0]表示房屋0染红色的费用，cost[1][2]表示房屋1染绿色的费用，依此类推。找到油漆所有房子的最低成本。
 *
 * 所有费用都是正整数
 *
 * 样例
 * 样例 1:
 *
 * 输入: [[14,2,11],[11,14,5],[14,3,10]]
 * 输出: 10
 * 解释: 第一个屋子染蓝色，第二个染绿色，第三个染蓝色，最小花费：2 + 5 + 3 = 10.
 *
 * 样例 2:
 * 输入: [[1,2,3],[1,4,6]]
 * 输出: 3
 */
package lintcode.com.sequence;

/**
 * 515 · 房屋染色
 *
 * 注意dp数组大小问题
 * @author zhangguodong
 * @date 2021/9/23 07:30
 */
public class MinCost {
    /**
     * @param costs: n x 3 cost matrix
     * @return An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // 确定状态: 房子i-1是红色、蓝色、绿色的最小花费 dp[i][0],dp[i][1],dp[i][2]
        // 转移方程:
        // 1. 房子i是红色，房子i-1为蓝色、绿色
        //dp[i][0] = min{dp[i-1][1] + cost[i-1][0], dp[i-1][2] + cost[i-1][0]}
        //
        // 2. 房子i是蓝色，房子i-1为红色、绿色
        //dp[i][1] = min{dp[i-1][0] + cost[i-1][1], dp[i-1][2] + cost[i-1][1]}
        //
        // 3. 房子i是绿色，房子i-1为红色、蓝色
        //dp[i][2] = min{dp[i-1][0] + cost[i-1][2], dp[i-1][1] + cost[i-1][2]}
        // 初始条件、边界条件: dp[0][0] = dp[0][1] = dp[0][2] = 0
        // 计算顺序: dp[0][0]、dp[0][1]、dp[0][2]；dp[1][0]、dp[1][1]、dp[1][2]
        int m = costs.length;
        if (m < 1) {
            return 0;
        }

        int[][] dp = new int[m + 1][3];
        dp[0][0] = dp[0][1] = dp[0][2] = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (j != k) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + costs[i - 1][j]);
                    }
                }
            }
        }

        return Math.min(dp[m][0], Math.min(dp[m][1], dp[m][2]));
    }
}
