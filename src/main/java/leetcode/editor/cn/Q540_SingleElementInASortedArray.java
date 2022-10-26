//给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。 
//
// 请你找出并返回只出现一次的那个数。 
//
// 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,2,3,3,4,4,8,8]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums =  [3,3,7,7,10,11,11]
//输出: 10
// 
//
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 二分查找 👍 403 👎 0

package leetcode.editor.cn;

/**
 * title: 540 : 有序数组中的单一元素
 * create: 2022-02-14 15:30:52
 */
public class Q540_SingleElementInASortedArray {
    public static void main(String[] args) {
        Solution solution = new Q540_SingleElementInASortedArray().new Solution();
        int i = solution.singleNonDuplicate(new int[]{1, 1, 3, 3, 2, 4, 4, 8, 8});
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 由于只出现一次的元素所在下标 xx 的左边有偶数个元素，因此下标 xx 一定是偶数，可以在偶数下标范围内二分查找
        public int singleNonDuplicate(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int m = l + (r - l) / 2;
                m -= m & 1;
                if (nums[m] == nums[m + 1]) {
                    l = m + 2;
                } else {
                    r = m;
                }
            }
            return nums[l];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
// (r-m)/2+m = x
}