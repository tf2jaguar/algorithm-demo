/*
 * 描述
 * 这里有n个房子在一列直线上，现在我们需要给房屋染色，共有k种颜色。每个房屋染不同的颜色费用也不同，你希望每两个相邻的房屋颜色不同
 *
 * 费用通过一个nxk 的矩阵给出，比如cost[0][0]表示房屋0染颜色0的费用，cost[1][2]表示房屋1染颜色2的费用。找到油漆所有房子的最低成本。
 *
 * 所有费用都是正整数
 *
 * 样例
 * 样例1
 *
 * 输入:
 * costs = [[14,2,11],[11,14,5],[14,3,10]]
 * 输出: 10
 * 说明:
 * 三个屋子分别使用第1,2,1种颜色，总花费是10。
 * 样例2
 *
 * 输入:
 * costs = [[5]]
 * 输出: 5
 * 说明：
 * 只有一种颜色，一个房子，花费为5
 * 挑战
 * 用O(nk)的时间复杂度解决
 */
package lintcode.com.dynamic.sequence;

/**
 * 516 · 房屋染色 II
 *
 * @author zhangguodong
 * @date 2021/9/30 10:33
 */
public class MinCostII {
    public static void main(String[] args) {
        MinCostII m = new MinCostII();
        int minCostII = m.minCostII(new int[][]{{3}});
        System.out.println(minCostII);
    }

    /**
     * 和 515 · 房屋染色 相似，只是颜色变成了k种
     * 这里的优化在于k个中，如果每个房子都循环找k次找到最低的，时间复杂度将是O(NK^2)
     * 其实这里k个中，不选最低的，就选次低的，始终是两个，所以可是在循环每个房子时候，先找出当前消费的最低值和次低值
     *
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        // 边界条件
        int m = costs.length;
        if (m == 0) {
            return 0;
        }
        int n = costs[0].length;
        // 只有一个边界 [[5]]
        if (m == 1 && n == 1) {
            return costs[0][0];
        }

        int i, j, idx1 = 0;
        int min1, min2;
        int[][] dp = new int[m + 1][n];
        // 循环每个房子。因为cost[0][0]表示房屋0 染颜色0 的费用，所以这里下标应该从1开始，上边的dp数组一维纬度 m+1
        for (i = 1; i <= m; i++) {
            // 查找最小花费、次小花费。复杂度 O(K)
            min1 = min2 = Integer.MAX_VALUE;
            for (j = 0; j < n; j++) {
                if (dp[i - 1][j] < min1) {
                    min2 = min1;
                    min1 = dp[i - 1][j];
                    idx1 = j;
                } else if (dp[i - 1][j] < min2) {
                    min2 = dp[i - 1][j];
                }
            }

            // 计算dp数组
            for (j = 0; j < n; j++) {
                dp[i][j] = costs[i - 1][j];
                if (j != idx1) {
                    dp[i][j] += min1;
                } else {
                    dp[i][j] += min2;
                }
            }
        }

        // 寻找最后一个房子，涂各种颜色的 最小花费
        int res = Integer.MAX_VALUE;
        for (int c : dp[m]) {
            res = Math.min(res, c);
        }
        return res;
    }
}
