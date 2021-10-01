/*
 * 描述
 * 假设你是一个专业的窃贼，准备沿着一条街打劫房屋。每个房子都存放着特定金额的钱。你面临的唯一约束条件是：相邻的房子装着相互联系的防盗系统，且 当相邻的两个房子同一天被打劫时，该系统会自动报警。
 *
 * 给定一个非负整数列表，表示每个房子中存放的钱， 算一算，如果今晚去打劫，在不触动报警装置的情况下, 你最多可以得到多少钱 。
 *
 * 样例
 * 样例 1:
 *
 * 输入: [3, 8, 4]
 * 输出: 8
 * 解释: 仅仅打劫第二个房子.
 * 样例 2:
 *
 * 输入: [5, 2, 1, 3]
 * 输出: 8
 * 解释: 抢第一个和最后一个房子
 * 挑战
 * O(n) 时间复杂度 且 O(1) 存储。
 */
package lintcode.com.dynamic.sequence;

/**
 * 392 · 打劫房屋
 *
 * @author zhangguodong
 * @date 2021/10/1 12:11
 */
public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        long l = hr.houseRobber(new int[]{5, 2, 1, 3});
        System.out.println(l);
    }
    /**
     * @param A: An array of non-negative integers
     * @return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // 确定状态：dp[i] 为打劫该房子，最终会累计多少钱。最终找到dp[i]最大值
        // 转移方程： dp[i] = max{dp[i-1], dp[i-2] + cost[i-1]}  因为不能打劫相邻的两个房子
        //          不偷最后一个房子（第i栋房子的值就是第i-1栋房子的值），偷最后一个房子（第i栋房子的金币 + 第i-2栋房子的值）
        // 初始条件、边界条件: dp[0] = 0, dp[1] = cost[0], dp[2] = max{cost[0], cost[2]}
        // 计算顺序: dp[1]、dp[2]、……、dp[n] 答案是dp[n]
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return A[0];
        }

        long[] dp = new long[A.length + 1];
        dp[0] = 0;
        dp[1] = A[0];
        for (int i = 2; i <= A.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + A[i - 1]);
        }
        return dp[A.length];
    }
}
