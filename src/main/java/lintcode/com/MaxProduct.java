/*
 * 描述
 * 找出一个序列中乘积最大的连续子序列（至少包含一个数）。
 *
 * 数组长度不超过20000
 * 乘积最大的子序列的积，小于2147483647
 *
 * 样例
 * 样例 1:
 *
 * 输入:[2,3,-2,4]
 * 输出:6
 * 样例 2:
 *
 * 输入:[-1,2,4,1]
 * 输出:8
 */
package lintcode.com;

/**
 * 191 · 乘积最大子序列
 *
 * @author zhangguodong
 * @date 2021/9/22 21:34
 */
public class MaxProduct {

    public static void main(String[] args) {
        MaxProduct mp = new MaxProduct();
        int i = mp.maxProduct(new int[]{2, 3, -2, 4});
        System.out.println(i);
    }

    /**
     * @param nums: An array of integers
     * @return An integer
     */
    public int maxProduct(int[] nums) {
        // 确定状态: 如果a[j]是正数，则希望a[j-1]结尾的连续子序列乘积最大；如果a[j]是负数，则希望a[j-1]结尾的连续子序列乘积最小
        // 转移方程: l[i] = max{a[j]*l[j-1], a[j]*s[j-1]}|j>0 以a[j]结尾的连续子序列的最大乘积
        // 转移方程: s[i] = min{a[j]*l[j-1], a[j]*s[j-1]}|j>0 以a[j]结尾的连续子序列的最小乘积
        // 初始条件、边界条件:
        // 计算顺序:
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] l = new int[nums.length];
        int[] s = new int[nums.length];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            l[i] = nums[i];
            if (i > 0) {
                l[i] = Math.max(nums[i], Math.max(nums[i] * l[i - 1], nums[i] * s[i - 1]));
            }

            s[i] = nums[i];
            if (i > 0) {
                s[i] = Math.min(nums[i], Math.min(nums[i] * l[i - 1], nums[i] * s[i - 1]));
            }
            res = Math.max(res, l[i]);
        }
        return res;
    }
}
