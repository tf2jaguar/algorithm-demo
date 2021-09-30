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
 * @author zhangguodong
 * @date 2021/9/30 10:33
 */
public class MinCostII {
    public static void main(String[] args) {
        MinCostII m = new MinCostII();
        m.minCostII(new int[][]{{14, 2, 11}, {11, 14, 5}, {14, 3, 10}});
    }

    /**
     * 和 515 · 房屋染色 相似，只是颜色变成了k种
     * 这里的优化在于k个中，如果不选最低的，就选次低的，始终是两个
     *
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        int m = costs.length;
        if (m == 0) {
            return 0;
        }
        int n = costs[0].length;
        if (n == 0) {
            return 0;
        }

        int i, j, k;
        int min1, min2;
        int idx1 = 0, idx2 = 0;
        int[][] dp = new int[m + 1][n];

        for (i = 1; i < m; i++) {
            for (j = 0; j < n; j++) {

            }
        }
    }
}
