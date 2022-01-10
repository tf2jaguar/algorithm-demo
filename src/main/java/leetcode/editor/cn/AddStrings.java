//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
// Related Topics 数学 字符串 模拟 👍 492 👎 0

package leetcode.editor.cn;

/**
 * title: 415 : 字符串相加
 * create: 2022-01-10 16:52:54
 */
public class AddStrings {
    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
        String s = solution.addStrings("456", "77");
        System.out.println(s + " " + s.equals("533"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            int len1 = num1.length() - 1, len2 = num2.length() - 1;
            // 进位
            int carry = 0;
            StringBuilder builder = new StringBuilder();
            while (len1 >= 0 || len2 >= 0 || carry != 0) {
                int a = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
                int b = len2 >= 0 ? num2.charAt(len2) - '0' : 0;
                // 处理进位
                int r = a + b + carry;
                carry = r / 10;
                builder.append(r % 10);
                // 循环
                len1--;
                len2--;
            }
            builder.reverse();
            return builder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}