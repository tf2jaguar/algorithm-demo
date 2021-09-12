//实现 strStr() 函数。 
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 字符串匹配 👍 1005 👎 0

package leetcode.editor.cn;

/**
 * title: 28 : 实现 strStr()
 * create: 2021-08-25 07:30:04
 */
public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle == null || "".equals(needle)) {
                return 0;
            }
            char[] hChars = haystack.toCharArray();
            char[] nChars = needle.toCharArray();
            int hLen = hChars.length;
            int nLen = nChars.length;
            int[] next = getNext(nChars);

            int i = 0, j = 0;
            while (i < hLen && j < nLen) {
                // 如果j = -1,或者当前字符匹配成功(src[i] = ptn[j]),都让i++,j++
                if (hChars[i] == nChars[j]) {
                    i++;
                    j++;
                } else if (next[j] == -1) {
                    i++;
                } else {
                    // 如果j!=-1且当前字符匹配失败,则令i不变,j=next[j],即让pattern模式串右移j-next[j]个单位
                    j = next[j];
                }
            }
            return j == nLen ? i - j : -1;
        }

        /**
         * 获取KMP算法中pattern字符串对应的next数组
         *
         * @param chars 模式字符串对应的字符数组
         */
        public int[] getNext(char[] chars) {
            if (chars == null || chars.length == 0) {
                return new int[]{-1};
            }

            int[] next = new int[chars.length];
            next[0] = -1;
            next[1] = 0;
            int lastNextVal = 0;
            int i = 2;
            while (i < chars.length) {
                if (chars[i - 1] == chars[lastNextVal]) {
                    next[i++] = ++lastNextVal;
                } else if (lastNextVal > 0) {
                    lastNextVal = next[lastNextVal];
                } else {
                    next[i++] = 0;
                }
            }
            return next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}