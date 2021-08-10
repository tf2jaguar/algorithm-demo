//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
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
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 
// 👍 1116 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * title: 239 : 滑动窗口最大值
 * create: 2021-08-10 17:58:22
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        int[] nums = new int[]{9, 11};
        solution.maxSlidingWindow(nums, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Deque<Integer> queue = new ArrayDeque<>();

        /**
         * 1. 找到每次移动窗口后，窗口中的最大值。堆/优先级队列，用来确定当前数据中的最大值
         * 2. 添加：数据中的每个数都要进队列一次，且队列中要弹出比当前数小的数
         * 3. 移除：进一个，需要从另一端出一个。这时候判断队顶是不是要出的，是则出队
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            List<Integer> res = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                push(nums[i]);
                if (i < k - 1) {
                    continue;
                }
                res.add(queue.getFirst());

                pop(nums[i - k + 1]);
            }
            return res.stream().mapToInt(Integer::intValue).toArray();
        }

        public void push(int val) {
            while (!queue.isEmpty() && queue.getLast() < val) {
                queue.removeLast();
            }
            queue.addLast(val);
        }

        public void pop(int val) {
            if (!queue.isEmpty() && queue.getFirst() == val) {
                queue.removeFirst();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}