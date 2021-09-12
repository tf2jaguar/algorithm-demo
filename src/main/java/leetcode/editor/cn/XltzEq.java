//给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 本题中，将空字符串定义为有效的 回文串 。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串 
//
// 示例 2: 
//
// 
//输入: s = "race a car"
//输出: false
//解释："raceacar" 不是回文串 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
//
// 
//
// 注意：本题与主站 125 题相同： https://leetcode-cn.com/problems/valid-palindrome/ 
// Related Topics 双指针 字符串 👍 2 👎 0

package leetcode.editor.cn;

/**
 * title: 剑指 Offer II 018 : 有效的回文
 * create: 2021-09-12 12:12:12
 */
public class XltzEq {
    public static void main(String[] args) {
        Solution solution = new XltzEq().new Solution();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(solution.isPalindrome(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            char[] chars = s.toCharArray();
            int l = 0, r = chars.length - 1;
            boolean flag = true;
            while (l <= r) {
                if (!Character.isLetterOrDigit(chars[l])) {
                    l++;
                } else if (!Character.isLetterOrDigit(chars[r])) {
                    r--;
                } else if (Character.toLowerCase(chars[l++]) != Character.toLowerCase(chars[r--])) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}