/*
 * 描述
 * 在上次打劫完一条街道之后，窃贼又发现了一个新的可以打劫的地方，但这次所有的房子围成了一个圈，这就意味着第一间房子和最后一间房子是挨着的。
 * 每个房子都存放着特定金额的钱。你面临的唯一约束条件是：相邻的房子装着相互联系的防盗系统，且 当相邻的两个房子同一天被打劫时，该系统会自动报警。
 *
 * 给定一个非负整数列表，表示每个房子中存放的钱， 算一算，如果今晚去打劫，在不触动报警装置的情况下, 你最多可以得到多少钱 。
 *
 * 这题是House Robber的扩展，只不过是由直线变成了圈
 *
 * 样例
 * 样例1
 *
 * 输入: nums = [3,6,4]
 * 输出: 6
 * 样例2
 *
 * 输入: nums = [2,3,2,3]
 * 输出: 6
 */
package lintcode.com.dynamic.sequence;

/**
 * 534 · 打劫房屋 II
 *
 * @author zhangguodong
 * @date 2021/10/2 08:37
 */
public class HouseRobber2 {
    public static void main(String[] args) {
        HouseRobber2 h2 = new HouseRobber2();
        System.out.println(h2.houseRobber2(new int[]{1, 3, 2, 1, 5}));
    }

    /**
     * @param nums: An array of non-negative integers.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        // 破圈为线
        int[] n = new int[nums.length - 1];
        int i, res = Integer.MIN_VALUE;

        // 1。没偷房子0， 线为 1 ～ n-1
        for (i = 0; i < nums.length - 1; i++) {
            n[i] = nums[i + 1];
        }
        res = Math.max(res, calc(n));

        // 2。没偷房子 n-1， 线为 0 ～ n-2
        for (i = 0; i < nums.length - 1; i++) {
            n[i] = nums[i];
        }
        res = Math.max(res, calc(n));

        return res;
    }

    /**
     * hostRobber 的解法
     */
    public int calc(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }

        int old = 0, cur = arr[0];
        for (int i = 2; i <= arr.length; i++) {
            int tmp = Math.max(cur, old + arr[i - 1]);
            old = cur;
            cur = tmp;
        }
        return cur;
    }
}
