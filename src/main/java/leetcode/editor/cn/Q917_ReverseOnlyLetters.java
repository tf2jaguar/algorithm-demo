//给你一个字符串 s ，根据下述规则反转字符串： 
//
// 
// 所有非英文字母保留在原有位置。 
// 所有英文字母（小写或大写）位置反转。 
// 
//
// 返回反转后的 s 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "ab-cd"
//输出："dc-ba"
// 
//
// 
// 
//
// 示例 2： 
//
// 
//输入：s = "a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 
// 
//
// 示例 3： 
//
// 
//输入：s = "Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示 
//
// 
// 1 <= s.length <= 100 
// s 仅由 ASCII 值在范围 [33, 122] 的字符组成 
// s 不含 '\"' 或 '\\' 
// 
// Related Topics 双指针 字符串 👍 141 👎 0

package leetcode.editor.cn;

/**
 * title: 917 : 仅仅反转字母
 * create: 2022-02-23 14:31:47
 */
public class Q917_ReverseOnlyLetters {
    public static void main(String[] args) {
        Solution solution = new Q917_ReverseOnlyLetters().new Solution();
        String s = solution.reverseOnlyLetters("Test1ng-Leet=code-Q!");
        System.out.println(s + " " + s.equals("Qedo1ct-eeLg=ntse-T!"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseOnlyLetters(String s) {
            char[] chars = s.toCharArray();
            int len = chars.length;
            for (int i = 0, j = len - 1; i < j; i++, j--) {
                while (i < j && isLetter(chars[i])) {
                    i++;
                }
                while (j > i && isLetter(chars[j])) {
                    j--;
                }
                swap(chars, i, j);
            }
            return new String(chars);
        }

        private void swap(char[] chars, int i, int j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }

        private boolean isLetter(char c) {
            return (c < 'a' || c > 'z') && (c < 'A' || c > 'Z');
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}