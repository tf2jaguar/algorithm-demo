/*
 * 描述
 * 给定一个整数序列，找到最长上升子序列（LIS），返回LIS的长度。
 *
 * 最长上升子序列的定义：
 *
 * 最长上升子序列问题是在一个无序的给定序列中找到一个尽可能长的由低到高排列的子序列，这种子序列不一定是连续的或者唯一的。
 * https://en.wikipedia.org/wiki/Longest_increasing_subsequence
 *
 * 样例
 * 样例 1：
 *
 * 输入：
 *
 * nums = [5,4,1,2,3]
 * 输出：
 *
 * 3
 * 解释：
 *
 * LIS 是 [1,2,3]
 * 样例 2：
 *
 * 输入：
 *
 * nums = [4,2,4,5,3,7]
 * 输出：
 *
 * 4
 * 解释：
 *
 * LIS 是 [2,4,5,7]
 *
 * 挑战
 * 要求时间复杂度为O(n^2) 或者 O(nlogn)
 */
package lintcode.com.dynamic.coordinate;

/**
 * 76 · 最长上升子序列
 *
 * @author zhangguodong
 * @date 2021/10/4 09:44
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println(lis.longestIncreasingSubsequence(new int[]{4, 2, 4, 5, 3, 7}));
    }

    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        // O(N^2)
        int res = LIS(nums, nums.length);
        // O(nlogN)
//        int res = LIS2(nums, nums.length);
        return res;
    }

    /**
     * O(nlogN)
     */
    private int LIS2(int[] nums, int len) {
        int[] dp = new int[len];
        int size = 0;
        for (int num : nums) {
            int l = 0, r = size;
            while (l < r) {
                int m = l + ((r - l) >> 1);
                if (dp[m] < num) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            dp[l] = num;
            if (r == size){
                size++;
            }
        }
        return size;
    }

    /**
     * O(N^2)
     */
    private int LIS(int[] nums, int len) {
        int[] dp = new int[len];
        int res = 0;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
