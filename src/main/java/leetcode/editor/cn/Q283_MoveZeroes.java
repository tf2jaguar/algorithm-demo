//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics 数组 双指针 👍 1720 👎 0

package leetcode.editor.cn;

/**
 * title: 283 : 移动零
 * create: 2022-08-30 15:26:57
 */
public class Q283_MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new Q283_MoveZeroes().new Solution();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        solution.moveZeroes(nums);

        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int left = 0, right = 0;
            while (right < nums.length) {
                if (nums[right] != 0) {
                    nums[left++] = nums[right];
                }
                right++;
            }
            // left前的都是原本非0元素，则后边直接赋值0即可
            while (left < nums.length) {
                nums[left++] = 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}