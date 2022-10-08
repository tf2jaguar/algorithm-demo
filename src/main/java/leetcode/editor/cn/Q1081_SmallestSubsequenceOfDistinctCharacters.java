//返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。 
//
// 注意：该题与 316 https://leetcode.com/problems/remove-duplicate-letters/ 相同 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// Related Topics 栈 贪心 字符串 单调栈 👍 162 👎 0

package leetcode.editor.cn;

import java.util.Stack;

/**
 * title: 1081 : 不同字符的最小子序列
 * create: 2022-09-09 10:58:01
 */
public class Q1081_SmallestSubsequenceOfDistinctCharacters {
    public static void main(String[] args) {
        Solution solution = new Q1081_SmallestSubsequenceOfDistinctCharacters().new Solution();
        String bcabc = solution.smallestSubsequence("bcabc");
        System.out.println(bcabc);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String smallestSubsequence(String s) {
            int len = 0;
            for (char c : s.toCharArray()) {
                len = Math.max(len, c);
            }
            int[] count = new int[len + 1];
            for (char c : s.toCharArray()) {
                count[c]++;
            }

            Stack<Character> stack = new Stack<>();
            boolean[] inStack = new boolean[len + 1];

            for (char c : s.toCharArray()) {
                count[c]--;
                if (inStack[c]) continue;

                while (!stack.isEmpty() && stack.peek() > c) {
                    if (count[stack.peek()] == 0) break;
                    inStack[stack.pop()] = false;
                }

                stack.push(c);
                inStack[c] = true;
            }

            StringBuilder res = new StringBuilder();
            while (!stack.isEmpty()) {
                res.append(stack.pop());
            }
            return res.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}