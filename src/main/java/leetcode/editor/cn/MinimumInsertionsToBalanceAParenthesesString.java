//给你一个括号字符串 s ，它只包含字符 '(' 和 ')' 。一个括号字符串被称为平衡的当它满足： 
//
// 
// 任何左括号 '(' 必须对应两个连续的右括号 '))' 。 
// 左括号 '(' 必须在对应的连续两个右括号 '))' 之前。 
// 
//
// 比方说 "())"， "())(())))" 和 "(())())))" 都是平衡的， ")()"， "()))" 和 "(()))" 都是不平衡的。 
//
// 你可以在任意位置插入字符 '(' 和 ')' 使字符串平衡。 
//
// 请你返回让 s 平衡的最少插入次数。 
//
// 
//
// 示例 1： 
//
// 输入：s = "(()))"
//输出：1
//解释：第二个左括号有与之匹配的两个右括号，但是第一个左括号只有一个右括号。我们需要在字符串结尾额外增加一个 ')' 使字符串变成平衡字符串 "(())))
//" 。
// 
//
// 示例 2： 
//
// 输入：s = "())"
//输出：0
//解释：字符串已经平衡了。
// 
//
// 示例 3： 
//
// 输入：s = "))())("
//输出：3
//解释：添加 '(' 去匹配最开头的 '))' ，然后添加 '))' 去匹配最后一个 '(' 。
// 
//
// 示例 4： 
//
// 输入：s = "(((((("
//输出：12
//解释：添加 12 个 ')' 得到平衡字符串。
// 
//
// 示例 5： 
//
// 输入：s = ")))))))"
//输出：5
//解释：在字符串开头添加 4 个 '(' 并在结尾添加 1 个 ')' ，字符串变成平衡字符串 "(((())))))))" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// s 只包含 '(' 和 ')' 。 
// 
//
// Related Topics 栈 贪心 字符串 👍 53 👎 0

package leetcode.editor.cn;

/**
 * title: 1541 : 平衡括号字符串的最少插入次数
 * create: 2022-09-04 11:39:19
 */
public class MinimumInsertionsToBalanceAParenthesesString {
    public static void main(String[] args) {
        Solution solution = new MinimumInsertionsToBalanceAParenthesesString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minInsertions(String s) {
            // res 记录插入次数，need记录右括号需求数量
            int res = 0, need = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    need += 2;

                    // 当遇到左括号时，若对右括号的需求量为奇数，需要插入1个右括号。
                    // 因为一个左括号需要两个右括号，右括号的需求必须是偶数，这一点也是本题的难点。
                    // 当前右括号数量为奇数，增加一个右括号，减少一个右括号的需求
                    if ((need & 1) == 1) {
                        res++;
                        need--;
                    }
                }

                if (c == ')') {
                    need--;

                    // 右括号太多了，需要增加一个左括号，同时还需要增加一个右括号的需求
                    if (need == -1) {
                        res++;
                        need = 1;
                    }
                }
            }
            return res + need;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}