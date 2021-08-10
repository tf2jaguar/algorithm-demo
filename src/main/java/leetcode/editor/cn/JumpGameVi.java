//给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。 
//
// 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, 
//i + k)] 包含 两个端点的任意位置。 
//
// 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。 
//
// 请你返回你能得到的 最大得分 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-1,-2,4,-7,3], k = 2
//输出：7
//解释：你可以选择子序列 [1,-1,4,3] （上面加粗的数字），和为 7 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [10,-5,-2,4,0,3], k = 3
//输出：17
//解释：你可以选择子序列 [10,4,3] （上面加粗数字），和为 17 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length, k <= 105 
// -104 <= nums[i] <= 104 
// 
// Related Topics 队列 数组 动态规划 滑动窗口 单调队列 堆（优先队列） 
// 👍 52 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * title: 1696 : 跳跃游戏 VI
 * create: 2021-08-10 17:56:46
 */
public class JumpGameVi {
    public static void main(String[] args) {
        Solution solution = new JumpGameVi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 用来查找最近 k 步中，能找到的最多的金币个数
        Deque<Integer> queue = new ArrayDeque<>();

        /**
         * 1. 维护一个新数组，每次记录当前位置能找到的最大金币数量
         * 2. 维护一个单调队列，来取最近k步中，能找到的最大金币数量
         */
        public int maxResult(int[] nums, int k) {
            // 每一步能获取到的最多的金币数
            int[] get = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                // 队列中只能保存最近k步能获得的金币数量，且单调减
                if (i - k > 0) {
                    pop(get[i - k - 1]);
                }

                // 当前位置 i 所能获取的金币 = 最近k步中能获取到的最多的金币 + 当前位置 nums 能获取到的金币
                int lastKGet = queue.isEmpty() ? 0 : queue.getFirst();
                get[i] = lastKGet + nums[i];

                // 每一步能获取到的结果，推进队列，且维护单调减
                push(get[i]);
            }

            return get[nums.length - 1];
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