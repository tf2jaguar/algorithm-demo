//给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则： 
//
// 
// 任何左括号 ( 必须有相应的右括号 )。 
// 任何右括号 ) 必须有相应的左括号 ( 。 
// 左括号 ( 必须在对应的右括号之前 )。 
// * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。 
// 一个空字符串也被视为有效字符串。 
// 
//
// 示例 1: 
//
// 
//输入: "()"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "(*)"
//输出: True
// 
//
// 示例 3: 
//
// 
//输入: "(*))"
//输出: True
// 
//
// 注意: 
//
// 
// 字符串大小将在 [1，100] 范围内。 
// 
// Related Topics 栈 贪心 字符串 动态规划 👍 305 👎 0

package leetcode.editor.cn;

/**
 * title: 678 : 有效的括号字符串
 * create: 2021-09-12 10:11:29
 */
public class ValidParenthesisString {
    public static void main(String[] args) {
        Solution solution = new ValidParenthesisString().new Solution();
//        String str = "(**))"; // * 代表 ( 和一个空字符
//        String str = "(()()(*)";// * 代表一个 )
        String str = "())*)";//  触发 h<0 情况
        solution.checkValidString(str);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1. l、h  分别代表不同情况下，左括号的数量
         * 2. l: 假定字符串中的 * 都代表 ) 时，左括号的数量
         * 3. h: 假定字符串中的 * 都代表 ( 时，左括号的数量
         */
        public boolean checkValidString(String s) {
            int l = 0, h = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    l++;
                    h++;
                } else if (c == ')') {
                    l = Math.max(0, l - 1);
                    h--;
                    // 如果h<0，说明当前位置以前的所以字符，将 * 当做左括号也无法凑成一对 () ，返回false
                    if (h < 0) {
                        return false;
                    }
                } else {
                    // 这里匹配到了 '*'
                    // l: 假定字符串中的 * 都代表 ) 时，左括号的数量，抵消一个 ) 所以这里要减一
                    // h: 假定字符串中的 * 都代表 ( 时，左括号的数量，所以这里要加一
                    l = Math.max(0, l - 1);
                    h++;
                }
            }
            return l == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}