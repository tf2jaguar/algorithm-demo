//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 👍 4221 👎 0

package leetcode.editor.cn;

/**
 * title: 5 : 最长回文子串
 * create: 2021-10-20 20:06:46
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("babad"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 1) {
                return "";
            }
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                // 奇数
                int len1 = expandAroundCenter(s, i, i);
                // 偶数
                int len2 = expandAroundCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                // 判断是否比当前记录的最大的值
                if (len > end - start) {
                    // i 是当前的回文中心，长度除以2 为当前回文串的半径 [) 即为 i-(len -1)/2 ~ i- len/2
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        private int expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                --left;
                ++right;
            }
            return right - left - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}