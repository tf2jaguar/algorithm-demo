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
public class SingleElementInASortedArray {
    public static void main(String[] args) {
        Solution solution = new SingleElementInASortedArray().new Solution();
        int i = solution.singleNonDuplicate(new int[]{1, 1, 3, 3, 2, 4, 4, 8, 8});
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            // 排好序的，只会出现一次
            // 1。长度为1
            // 2。第一个/最后一个是唯一出现的
            // 3。只会出现在下表为偶数情况
            if (nums.length < 2 || nums[0] != nums[1]) return nums[0];
            for (int i = 2; i < nums.length - 1; i = i + 2) {
                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) return nums[i];
            }
            return nums[nums.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
// (r-m)/2+m = x
}