//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 
// 👍 1425 👎 0

package leetcode.editor.cn;

import java.util.Stack;

/**
 * title: 32 : 最长有效括号
 * create: 2021-08-25 16:36:47
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            Stack<Integer> st = new Stack<Integer>();
            int ans = 0;
            for (int i = 0, start = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    st.add(i);
                } else {
                    if (!st.isEmpty()) {
                        st.pop();
                        if (st.isEmpty()) {
                            ans = Math.max(ans, i - start + 1);
                        } else {
                            ans = Math.max(ans, i - st.peek());
                        }
                    } else {
                        start = i + 1;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}