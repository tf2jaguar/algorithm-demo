//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2³¹, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 位运算 数学 👍 751 👎 0

package leetcode.editor.cn;

/**
 * title: 29 : 两数相除
 * since: 2021-10-18 08:29:01
 */
public class Q29_DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new Q29_DivideTwoIntegers().new Solution();
        System.out.println(solution.divide(7,-3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {
            long a = dividend, b = divisor, ans = 0;
            boolean isNeg = a < 0 && b > 0 || a > 0 && b < 0;
            // 试除
            a = Math.abs(a);
            b = Math.abs(b);
            while (a >= b) {
                long base = b, cnt = 1;
                // 除数不断翻倍，直至大于被除数
                while ((base << 1) <= a) {
                    base <<= 1;
                    cnt <<= 1;
                }
                // 将倍数累加
                ans += cnt;
                // 被除数在减去这个不超过被除数的除数的最大倍数
                a -= base;
            }

            if (isNeg) ans = -ans;
            if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            return (int) ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}