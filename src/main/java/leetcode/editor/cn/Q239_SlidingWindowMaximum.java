//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 1847 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * title: 239 : 滑动窗口最大值
 * create: 2022-09-08 10:10:14
 */
public class Q239_SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new Q239_SlidingWindowMaximum().new Solution();
        int[] ints = solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);

        for (int i : ints) {
            System.out.print(i + ", ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Deque<Integer> window = new ArrayDeque<>();

        public int[] maxSlidingWindow(int[] nums, int k) {
            List<Integer> res = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                push(nums[i]);
                // 这里从第一个窗口时就要开始统计
                if (i < k - 1) {
                    continue;
                }
                res.add(window.getFirst());
                pop(nums[i - k + 1]);
            }
            return res.stream().mapToInt(Integer::intValue).toArray();
        }

        private void push(int i) {
            // 这里要弹出之前所有比当前值小的数（相等不处理），从旧向新检查 last -> first
            while (!window.isEmpty() && window.getLast() < i) {
                window.pollLast();
            }
            window.offerLast(i);
        }

        private void pop(int i) {
            // 弹出时，只需要检查当前最大值是否为要弹出的值即可，不需要循环
            if (!window.isEmpty() && window.getFirst() == i) {
                window.pollFirst();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}