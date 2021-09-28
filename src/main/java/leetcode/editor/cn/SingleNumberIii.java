//给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,1,3,2,5]
//输出：[3,5]
//解释：[5, 3] 也是有效的答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [-1,0]
//输出：[-1,0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,1]
//输出：[1,0]
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 除两个只出现一次的整数外，nums 中的其他数字都出现两次 
// 
// Related Topics 位运算 数组 👍 446 👎 0

package leetcode.editor.cn;

/**
 * title: 260 : 只出现一次的数字 III
 * create: 2021-09-28 11:20:33
 */
public class SingleNumberIii {
    public static void main(String[] args) {
        Solution solution = new SingleNumberIii().new Solution();
        int[] ints = solution.singleNumber(new int[]{1, 2, 1, 3, 2, 5});

        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    /**
     * 1.与运算（&）
     * 进行运算的两个数据，按二进制位进行“与”运算。
     * <p>
     * 规则：0&0=0;   0&1=0;    1&0=0;     1&1=1;
     * 即： 两位同时为“1”，结果才为“1”，否则为0
     * <p>
     * 4.异或运算（^）
     * 参加运算的两个数据，按二进制位进行“异或”运算。
     * <p>
     * 运算规则：0^0=0；   0^1=1；   1^0=1；   1^1=0；
     * 即：参加运算的两个对象，如果两个相应位为“异”（值不同），则该位结果为1，否则为0。
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumber(int[] nums) {
            // 先对所有数字进行一次异或，得到两个出现一次的数字的异或值。
            int ret = 0;
            for (int n : nums) {
                ret ^= n;
            }
            // 在异或结果中找到任意为 1 的位。
            int div = 1;
            while ((div & ret) == 0) {
                div <<= 1;
            }
            // 根据这一位对所有的数字进行分组
            int a = 0, b = 0;
            for (int n : nums) {
                // 在每个组内进行异或操作，得到两个数字
                if ((div & n) != 0) {
                    a ^= n;
                } else {
                    b ^= n;
                }
            }
            return new int[]{a, b};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}