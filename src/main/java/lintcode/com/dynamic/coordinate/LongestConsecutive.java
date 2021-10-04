/*
 * 描述
 * 给定一个未排序的整数数组num，找出最长连续序列的长度。
 *
 * 要求你的算法复杂度为O(n)O(n)
 * len(num) <= 10000len(num)<=10000
 * 样例
 * 样例 1：
 *
 * 输入：
 *
 * num = [100, 4, 200, 1, 3, 2]
 * 输出：
 *
 * 4
 * 解释：
 *
 * 这个最长的连续序列是 [1, 2, 3, 4]. 返回所求长度 4
 *
 * 标签
 */
package lintcode.com.dynamic.coordinate;

import java.util.HashMap;
import java.util.Map;

/**
 * 124 · 最长连续序列
 *
 * @author zhangguodong
 * @date 2021/10/4 12:08
 */
public class LongestConsecutive {
    public static void main(String[] args) {
        LongestConsecutive lc = new LongestConsecutive();
        System.out.println(lc.longestConsecutive(new int[]{4, 5, 3, 0, 2, 1}));
    }

    /**
     * @param nums: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int lc = 0, rc = 0, cc = 0, res = 0;
        for (int n : nums) {
            if (map.containsKey(n)) {
                continue;
            }
            lc = map.getOrDefault(n - 1, 0);
            rc = map.getOrDefault(n + 1, 0);
            cc = lc + 1 + rc;
            res = Math.max(res, cc);

            // 修改当前长度 和它左边和右边连续序列端点对应的长度改掉
            map.put(n, cc);
            map.put(n - lc, cc);
            map.put(n + rc, cc);
        }
        return res;
    }
}