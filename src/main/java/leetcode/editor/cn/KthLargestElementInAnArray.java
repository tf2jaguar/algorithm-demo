//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1425 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * title: 215 : 数组中的第K个最大元素
 * since: 2021-12-26 10:51:17
 */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return method1(nums, k);
        }

        /**
         * 方法一：暴力解法
         * 排序后取第k大元素
         */
        public int method1(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }

        /**
         * 方法二：减而治之（逐渐缩小问题规模）
         */
        public int method2(int[] nums, int k) {
            int len = nums.length;
            int left = 0;
            int right = len - 1;

            // 转换一下，第 k 大元素的下标是 len - k
            int target = len - k;

            while (true) {
                int index = partition(nums, left, right);
                if (index == target) {
                    return nums[index];
                } else if (index < target) {
                    left = index + 1;
                } else {
                    right = index - 1;
                }
            }
        }

        /**
         * 对数组 nums 的子区间 [left..right] 执行 partition 操作，返回 nums[left] 排序以后应该在的位置
         * 在遍历过程中保持循环不变量的定义：
         * nums[left + 1..j] < nums[left]
         * nums(j..i) >= nums[left]
         */
        public int partition(int[] nums, int left, int right) {
            int pivot = nums[left];
            int j = left;
            for (int i = left + 1; i <= right; i++) {
                if (nums[i] < pivot) {
                    // j 的初值为 left，先右移，再交换，小于 pivot 的元素都被交换到前面
                    j++;
                    swap(nums, j, i);
                }
            }
            // 在之前遍历的过程中，满足 nums[left + 1..j] < pivot，并且 nums(j..i) >= pivot
            swap(nums, j, left);
            // 交换以后 nums[left..j - 1] < pivot, nums[j] = pivot, nums[j + 1..right] >= pivot
            return j;
        }

        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}