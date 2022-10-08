//「快乐前缀」是在原字符串中既是 非空 前缀也是后缀（不包括原字符串自身）的字符串。 
//
// 给你一个字符串 s，请你返回它的 最长快乐前缀。 
//
// 如果不存在满足题意的前缀，则返回一个空字符串。 
//
// 
//
// 示例 1： 
//
// 输入：s = "level"
//输出："l"
//解释：不包括 s 自己，一共有 4 个前缀（"l", "le", "lev", "leve"）和 4 个后缀（"l", "el", "vel", 
//"evel"）。最长的既是前缀也是后缀的字符串是 "l" 。
// 
//
// 示例 2： 
//
// 输入：s = "ababab"
//输出："abab"
//解释："abab" 是最长的既是前缀也是后缀的字符串。题目允许前后缀在原字符串中重叠。
// 
//
// 示例 3： 
//
// 输入：s = "leetcodeleet"
//输出："leet"
// 
//
// 示例 4： 
//
// 输入：s = "a"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// s 只含有小写英文字母 
// 
// Related Topics 字符串 字符串匹配 哈希函数 滚动哈希 👍 71 👎 0

package leetcode.editor.cn;

/**
 * title: 1392 : 最长快乐前缀
 * since: 2021-10-17 19:11:11
 */
public class Q1392_LongestHappyPrefix {
    public static void main(String[] args) {
        Solution solution = new Q1392_LongestHappyPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPrefix(String s) {
            if (s == null || s.length() < 1) {
                return "";
            }
            int[] next = new int[s.length()];
            int j = 0;
            for (int i = 1; i < s.length(); i++) {
                while (j > 0 && s.charAt(i) != s.charAt(j)) {
                    j = next[j - 1];
                }
                if (s.charAt(i) == s.charAt(j)) {
                    j++;
                }
                next[i] = j;
            }
            return s.substring(0, next[s.length() - 1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}