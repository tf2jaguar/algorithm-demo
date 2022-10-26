//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// Related Topics 位运算 数组 👍 470 👎 0

package leetcode.editor.cn;

/**
 * title: 剑指 Offer 56 - I : 数组中数字出现的次数
 * create: 2021-09-28 19:20:38
 */
public class Q剑指Offer56I_ShuZuZhongShuZiChuXianDeCiShuLcof {
    public static void main(String[] args) {
        Solution solution = new Q剑指Offer56I_ShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
        int[] ints = solution.singleNumbers(new int[]{1, 2, 10, 4, 1, 4, 3, 3});
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumbers(int[] nums) {
            int re = 0;
            for (int n : nums) {
                re ^= n;
            }
            // 在异或结果中找到任意为 1 的位。
            int div = 1;
            while ((div & re) == 0) {
                div <<= 1;
            }

            int a = 0, b = 0;
            for (int num : nums) {
                if ((num & div) == 0) {
                    a ^= num;
                } else {
                    b ^= num;
                }
            }
            return new int[]{a, b};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}