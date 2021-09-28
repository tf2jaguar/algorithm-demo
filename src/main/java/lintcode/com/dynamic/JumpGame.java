/*
 * 描述
 * 给出一个非负整数数组，你最初定位在数组的第一个位置。
 *
 * 数组中的每个元素代表你在那个位置可以跳跃的最大长度。
 *
 * 判断你是否能到达数组的最后一个位置。
 *
 * 数组A的长度不超过5000，每个元素的大小不超过5000
 *
 * 样例
 * 样例 1：
 *
 * 输入：
 *
 * A = [2,3,1,1,4]
 * 输出：
 *
 * true
 * 解释：
 *
 * 0 -> 1 -> 4（这里的数字为下标）是一种合理的方案。
 *
 * 样例 2：
 *
 * 输入：
 *
 * A = [3,2,1,0,4]
 * 输出：
 *
 * false
 * 解释：
 *
 * 不存在任何方案能够到达终点。
 *
 * 挑战
 * 这个问题有两个方法，一个是贪心和 动态规划。
 *
 * 贪心方法时间复杂度为O(N)
 *
 * 动态规划方法的时间复杂度为为O(n^2)
 *
 * 为能够让大家使用两种方法通过测试，我们设置的是小型数据集。这仅仅是为了让大家学会如何使用动态规划的方式解决此问题。如果您用动态规划的方式完成它，你可以尝试贪心法，以使其再次通过一次。
 */
package lintcode.com.dynamic;

/**
 * 116 · 跳跃游戏
 *
 * @author zhangguodong
 * @date 2021/9/21 17:19
 */
public class JumpGame {
    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        boolean canJump = jg.canJump(new int[]{2, 3, 1, 1, 4});
        System.out.println(canJump);
    }

    /**
     * @param A: A list of integers
     * @return A boolean
     */
    public boolean canJump(int[] A) {
        // 确定状态: dp[i] 能不能跳到 i 位置 0 <= i <= A.length()
        // 转移方程: dp[i] = dp[j] && j + A[j] >= i
        // 初始条件、边界条件: dp[0] = true，默认跳不到（false）
        // 计算顺序: 从左到右
        boolean[] dp = new boolean[A.length];
        dp[0] = true;

        for (int i = 1; i < A.length; i++) {
            dp[i] = false;
            // 穷举i前边的位置，能否跳到i
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + A[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[A.length - 1];
    }
}
