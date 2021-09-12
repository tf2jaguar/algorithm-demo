//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 贪心 哈希表 字符串 👍 332 👎 0

package leetcode.editor.cn;

/**
 * title: 409 : 最长回文串
 * create: 2021-09-13 07:30:20
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new LongestPalindrome().new Solution();
        System.out.println(5 / 2 * 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            // 统计每个字符出现的次数
            int[] count = new int[128];
            for (char c : s.toCharArray()) {
                count[c]++;
            }

            int res = 0;
            for (int i : count) {
                // 如果字符出现的次数 i 是偶数，则最终长度加上 i
                // 如果字符出现的次数 i 是奇数，则最终长度加上 i 向下取的最近的偶数
                res += i / 2 * 2;
                // 如果字符出现的次数 i 是奇数，且当前总的字符串的长度为偶数，则可以放在最终字符串最中心，也可成为回文
                if ((i & 1) == 1 && ((res & 1) == 0)) {
                    res++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}