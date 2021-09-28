//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 数组 👍 2038 👎 0

package leetcode.editor.cn;

/**
 * title: 136 : 只出现一次的数字
 * create: 2021-09-28 11:05:37
 */
public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 异或运算（^）
         * <p>
         * 参加运算的两个数据，按二进制位进行“异或”运算。
         * <p>
         * 运算规则：0^0=0；   0^1=1；   1^0=1；   1^1=0；
         * 即：参加运算的两个对象，如果两个相应位为“异”（值不同），则该位结果为1，否则为0。
         */
        public int singleNumber(int[] nums) {
            int tmp = 0;
            for (int n : nums) {
                tmp ^= n;
            }
            return tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}