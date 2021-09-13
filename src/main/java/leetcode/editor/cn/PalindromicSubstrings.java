//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 673 👎 0

package leetcode.editor.cn;

/**
 * title: 647 : 回文子串
 * create: 2021-09-13 15:50:40
 */
public class PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
        int abacdad = solution.countSubstrings("abacdad");
        System.out.println(abacdad);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char[] manacherString(String str) {
            char[] chars = str.toCharArray();
            char[] res = new char[2 * chars.length + 1];
            int j = 0;
            for (int i = 0; i < res.length; i++) {
                res[i] = (i & 1) == 0 ? '#' : chars[j++];
            }
            return res;
        }

        public int countSubstrings(String s) {

            return 0;
        }

        // 动态规划版
        //   ➡ j 从左往右
        // ⬇  i 从上往下
        public int countSubstrings1(String s) {
            int len = 0, res = 0;
            if (s == null || (len = s.length()) < 1) {
                return 0;
            }

            // 表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
            // i 从上往下；j 从左往右 (i,j) 是不是回文，需要看(i+1,j-1) 两个位置是否相等
            boolean[][] dp = new boolean[len][len];
            // 注意遍历顺序
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (j - i <= 1) {
                            dp[i][j] = true;
                        } else if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                        }
                    }
                }
            }

            for (boolean[] dps : dp) {
                for (boolean b : dps) {
                    if (b) {
                        res++;

                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}