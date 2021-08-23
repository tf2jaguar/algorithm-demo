//给定一个字符串 s，请将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
// 
// 
//
// 
//
// 注意：本题与主站 132 题相同： https://leetcode-cn.com/problems/palindrome-partitioning-
//ii/ 
// Related Topics 字符串 动态规划 👍 1 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * title: 剑指 Offer II 094 : 最少回文分割
 * create: 2021-08-21 15:27:10
 */
public class OmKAoA {
    public static void main(String[] args) {
        Solution solution = new OmKAoA().new Solution();
//        System.out.println(solution.minCut("eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj"));
        System.out.println(solution.minCut("cabababcbc"));
//        System.out.println("cabababcbc".substring(9,10));
//        c ababa bcb c
//        0 12345 678 9

//        c a babab cbc
//        0 1 23456 789
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCut(String s) {
            boolean[][] bool = new boolean[s.length()][s.length()];
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (i + 1 > j - 1) {
                            bool[i][j] = true;
                        } else {
                            bool[i][j] = bool[i + 1][j - 1];
                        }
                    }
                }
            }
            int[] dp = new int[s.length()];
            dp[0] = 1;
            for (int i = 0; i < s.length(); i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j <= i; j++) {
                    if (bool[j][i]) {
                        dp[i] = Math.min(dp[i], (j - 1 >= 0 ? dp[j - 1] : 0) + 1);
                    }
                }
            }
            return dp[s.length() - 1] - 1;
        }

        public boolean isH(String str) {
            int len = str.length();
            boolean res = true;
            for (int i = 0, j = len - 1; i < j; i++, j--) {
                if (str.charAt(i) != str.charAt(j)) {
                    res = false;
                    break;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}