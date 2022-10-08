//给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。 
//
// 示例 1: 
//
// 
//输入: "abab"
//
//输出: True
//
//解释: 可由子字符串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: "aba"
//
//输出: False
// 
//
// 示例 3: 
//
// 
//输入: "abcabcabcabc"
//
//输出: True
//
//解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
// 
// Related Topics 字符串 字符串匹配 👍 545 👎 0

package leetcode.editor.cn;

/**
 * title: 459 : 重复的子字符串
 * since: 2021-10-17 19:25:59
 */
public class Q459_RepeatedSubstringPattern {
    public static void main(String[] args) {
        Solution solution = new Q459_RepeatedSubstringPattern().new Solution();
        int[] abcabcabcabcs = solution.getNext("abcabcabcabc");
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * next 数组记录的就是最长相同前后缀
         * 如果 next[len - 1] != 0，则说明字符串有最长相同的前后缀（就是字符串里的前缀子串和后缀子串相同的最长长度）。
         * <p>
         * 最长相等前后缀的长度为：next[len - 1]。
         * <p>
         * 数组长度为：len。
         * <p>
         * 如果len % (len - next[len - 1]) == 0 ，
         * 则说明 (数组长度-最长相等前后缀的长度) 正好可以被 数组的长度整除，说明有该字符串有重复的子字符串。
         */
        public boolean repeatedSubstringPattern(String s) {
            int len = s.length();
            int[] next = getNext(s);
            return next[len - 1] != 0 && len % (len - next[len - 1]) == 0;
        }

        public int[] getNext(String s) {
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
            return next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}